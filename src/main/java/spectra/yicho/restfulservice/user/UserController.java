package spectra.yicho.restfulservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
public class UserController {

    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //한명 조회
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {

        User user = service.findOne(id);

        if(user == null) {
            System.out.println("user null");
            throw new UserNotFoundException(String.format("ID[%s] 아이디가 없습니다.", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser =  service.save(user);

        // 사용자에게 요청 값을 변환해주기
        // fromCurrentRequest() :현재 요청되어진 request값을 사용한다는 뜻
        // path : 반환 시켜줄 값
        // savedUser.getId() : {id} 가변변수에 새롭게 만들어진 id값 저장
        // toUri() : URI형태로 변환


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if(user == null) { // 아이디가 없을경우
            throw new UserNotFoundException(String.format("ID[%s] 아이디가 없습니다.", id));
        }
    }
}
