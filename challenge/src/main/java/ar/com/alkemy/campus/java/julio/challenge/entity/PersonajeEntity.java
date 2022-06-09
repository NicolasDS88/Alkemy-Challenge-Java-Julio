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
    //@Column como tienen el mismo nombre no hace falta
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String nombre;
    private String historia;
    private Double peso;
    private Integer edad;

    //cuando creo un personaje no le voy a poder pasar una lista de peliculas para que la cree
    //el ownersihp lo tiene pelicula, tiene mas sentido crear una pelicula con los personajes que al revez
    //por eso la definiciopn esta del lado del pais
    //buena practica despues agregar endpoints para eliminar independientemente lo que creo.
    //Defino que el personaje tenga su propia lista donde el participa.
    @ManyToMany (mappedBy = "personajes", cascade = CascadeType.ALL)
    private Set<PeliculaEntity> peliculas= new HashSet<>();
    //cuando creo

    public void addPelicula(PeliculaEntity pelicula) {this.peliculas.add(pelicula);}
    public void revovePelicula(PeliculaEntity pelicula) {this.peliculas.remove(pelicula);}
}
