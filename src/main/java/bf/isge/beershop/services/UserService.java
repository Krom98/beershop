package bf.isge.beershop.services;

import bf.isge.beershop.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    private List<User> users = new ArrayList<>();


    public User register(User user) {
        int id = users.size() + 1;
        user.setId((long) id);
        users.add(user);
        return user;
    }

    public User findByEmail(String email){
        return new User();
    }

    public List<User> finAllUser(){
        return users;
    }
}
