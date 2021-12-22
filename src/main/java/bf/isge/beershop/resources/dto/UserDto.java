package bf.isge.beershop.resources.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
}
