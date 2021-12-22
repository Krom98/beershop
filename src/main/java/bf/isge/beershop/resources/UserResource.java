package bf.isge.beershop.resources;

import bf.isge.beershop.domain.User;
import bf.isge.beershop.resources.dto.UserDto;
import bf.isge.beershop.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Slf4j
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping(value = "/register")
    ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        User user = mapToUser(userDto);
        return new ResponseEntity<>(mapToUserDto(userService.register(user)), HttpStatus.OK);
    }

    @GetMapping(value = "/findOneRequestParam")
    ResponseEntity<UserDto> findOneRequestParam(@RequestParam(value = "email") String email){
        log.info("email : {}", email);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findOnePathVariable/{email}")
    ResponseEntity<UserDto> findOnePathVariable(@PathVariable String email){
        log.info("email : {}", email);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findAll")
    ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> userDtos = new ArrayList<>();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    private User mapToUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        return user;
    }

    private UserDto mapToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
