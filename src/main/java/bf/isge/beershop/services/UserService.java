package bf.isge.beershop.services;

import bf.isge.beershop.domain.User;
import bf.isge.beershop.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userJpaRepository;
    private List<User> users = new ArrayList<>();



    public User register(User user) {
        return userJpaRepository.save(user);
       // int id = users.size() + 1;
       // user.setId((long) id);
       // users.add(user);
        //return user;
    }

    public User findByEmail(String email){
        for(User user: users){
            if (email.equals(user.getEmail())){
               // log.info("result found:"+user.getUsername());
                return userJpaRepository.findByEmail(email);
            }
        }
        return new User();
    }

    public List<User> finAllUser(){
        return users;
    }
    //public
}
