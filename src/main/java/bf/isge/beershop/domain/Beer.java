package bf.isge.beershop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "beer_app")
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"name", "quantity"})
@Getter
@Setter
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity", nullable = false)
    private String quantity;
   // @Column(name = "lastname", nullable = false)
    //private String lastname;
    //private String email;

}
