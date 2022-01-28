package bf.isge.beershop.repository;

import bf.isge.beershop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
 User findById(long id);
  // @Transactional(readOnly = true)
User findByEmail(String email);
User findByFirstnameAndLastname(String firstname, String lastname);
//User findByFirstnameOrLastname();
//User findAll();
}
