package spectra.yicho.restfulservice.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {

    // 비지니스 로직 처리 Dao + Service

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "youngIn",new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "heeWon",new Date(), "pass2", "801010-1111111"));
        users.add(new User(3, "Knight",new Date(), "pass3", "901010-1111111"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User u : users){
            if(u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
