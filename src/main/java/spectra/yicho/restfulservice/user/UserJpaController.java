package spectra.yicho.restfulservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    @Autowired
    public UserRepository userRepository;

    // http://localhost:800/jpa/users
    @GetMapping("/users")
    public List<User2> retrieveAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User2 retrieveUser(@PathVariable int id) {
        Optional<User2> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s] not Found", id));
        }

        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User2> createUser(@Valid @RequestBody User2 user) {
        User2 savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
