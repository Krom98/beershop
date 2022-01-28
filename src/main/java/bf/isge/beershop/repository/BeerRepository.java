package bf.isge.beershop.repository;

import bf.isge.beershop.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer,Long> {
    Beer findByName(String name);
   // Beer findByQuantity()
    boolean deleteById(long id);
}
