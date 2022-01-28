package bf.isge.beershop.services;

//package bf.isge.beershop.services;

import bf.isge.beershop.domain.Beer;
import bf.isge.beershop.repository.BeerRepository;
import bf.isge.beershop.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BeerService {

    private List<Beer> beers = new ArrayList<>();
    private final BeerRepository beerJpaRepository;
    //private List<B>


    public Beer register(Beer beer) {
        return beerJpaRepository.save(beer);
        //int id = beers.size() + 1;
      //  beer.setId((long) id);
     //   beers.add(beer);
      //  return beer;
    }

    public Beer findByName(String name){
        for(Beer beer: beers){
            if (name.equals(beer.getName())){
                log.info("result found:"+beer.getName());
                return beer;
            }
        }
        return new Beer();
    }
    public void deleteById(Long id){
        beerJpaRepository.deleteById(id);
    }

    public Beer deleteByName(String name) {

        for (Beer beer : beers) {
            if (name.equals(beer.getName())) {
                beers.remove(beer);
                //log.info(beer.getName());
                return beer;
            }
        }
        return new Beer();
    }

    public List<Beer> finAllBeer(){
        return beers;
    }
}
