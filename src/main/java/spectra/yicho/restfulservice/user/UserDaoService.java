package spectra.yicho.restfulservice.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {

    // 비지니스 로직 처리 Dao + Service

    private static List<User2> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User2(1, "youngIn",new Date(), "pass1", "701010-1111111"));
        users.add(new User2(2, "heeWon",new Date(), "pass2", "801010-1111111"));
        users.add(new User2(3, "Knight",new Date(), "pass3", "901010-1111111"));
    }

    public List<User2> findAll() {
        return users;
    }

    public User2 save(User2 user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User2 findOne(int id) {
        for(User2 u : users){
            if(u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    public User2 deleteById(int id) {
        Iterator<User2> iterator = users.iterator();
        while(iterator.hasNext()) {
            User2 user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
