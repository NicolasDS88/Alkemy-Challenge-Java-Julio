package ar.com.alkemy.campus.java.julio.challenge.entity;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String nombre;
    private String historia;
    private Double peso;
    private Integer edad;
    private String peliculaSerieAsociada;

    @ManyToMany (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "personaje_peliculas_series",joinColumns = @JoinColumn(name="personaje_id"),
    inverseJoinColumns = @JoinColumn(name="peliculas_series_id"))
    private Set<PeliculaSerieEntity> peliculasSeries= new HashSet<>();


}
