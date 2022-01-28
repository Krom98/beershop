package bf.isge.beershop.resources;

import bf.isge.beershop.domain.Beer;
import bf.isge.beershop.dto.BeerDto;
import bf.isge.beershop.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/beer")
@Slf4j
@RestController
public class BeerResource {
    private final BeerService beerService;

    public BeerResource(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping(value = "/register")
    ResponseEntity<BeerDto> register(@RequestBody BeerDto beerDto){
        Beer beer = mapToBeer(beerDto);
        return new ResponseEntity<>(mapToBeerDto(beerService.register(beer)), HttpStatus.OK);
    }

    @GetMapping(value = "/findOneRequestParam")
    ResponseEntity<BeerDto> findOneRequestParam(@RequestParam(value = "name") String name){
        //log.info("Name : {}", name);
        beerService.findByName(name);
        //   List<UserDto> userDtos = new ArrayList<>();
        Beer beer = beerService.findByName(name);
        //    mapToUserDto(user);

        return new ResponseEntity<>(mapToBeerDto(beer), HttpStatus.OK);
    }

    @GetMapping(value = "/findOnePathVariable/{name}")
    ResponseEntity<BeerDto> findOnePathVariable(@PathVariable String name){
        //log.info("name : {}", name);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findAll")
    ResponseEntity<List<BeerDto>> findAll(){
        List<BeerDto> beerDtos = new ArrayList<>();
        List<Beer> beers = beerService.finAllBeer();
        for(Beer beer: beers){
            beerDtos.add(mapToBeerDto(beer));
        }
        return new ResponseEntity<>(beerDtos, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        beerService.deleteById(id);
    }

    @GetMapping(value = "/deleteByName")
    ResponseEntity<BeerDto> deleteByName(@PathVariable String name){
       // Beer beer = mapToBeer(beerDto);
        return new ResponseEntity<>(mapToBeerDto(beerService.deleteByName(name)), HttpStatus.OK);

    }

    private Beer mapToBeer(BeerDto beerDto){
        Beer beer = new Beer();
        beer.setId(beerDto.getId());
        beer.setName(beerDto.getName());
        beer.setQuantity(beerDto.getQuantity());
     //   user.setLastname(userDto.getLastname());
    //    user.setEmail(userDto.getEmail());
        return beer;
    }

    private BeerDto mapToBeerDto(Beer beer){
        BeerDto dto = new BeerDto();
        dto.setId(beer.getId());
        dto.setName(beer.getName());
        dto.setQuantity(beer.getQuantity());
       // dto.setFirstname(user.getFirstname());
     //   dto.setLastname(user.getLastname());
      //  dto.setEmail(user.getEmail());
        return dto;
    }
}