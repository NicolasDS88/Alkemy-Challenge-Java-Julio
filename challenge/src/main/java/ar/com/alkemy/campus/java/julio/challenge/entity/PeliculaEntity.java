package ar.com.alkemy.campus.java.julio.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "peliculas")
@Getter
@Setter
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE) //sequence para que vaya autoincrementando, podria usar un wide
    private Long id;

    private String imagen; //imagino que es una URL
    private String titulo;
    private Integer calificacion;
    private boolean softDelete = Boolean.FALSE;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;

    //Pelicula se lo puede considerar el objeto mas grande ya que engloba personajes y genero
    //Lista de personajes que participan
    //Cuando creo una pelicula puedo pasar una lista de personajes y se crea la relacion many to many
    @ManyToMany(
                cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE}) //une la info
    @JoinTable(
            name = "personajes_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes = new HashSet<>();

    //@Column(name = "personaje_id", nullable = false) //de aca consigo el ID del personaje
    //private long personajeId;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", nullable = false, updatable = false) //false, solo lo uso para obtener info
    private GeneroEntity genero;
    @Column(name = "genero_id", nullable = false) //de aca consigo el ID del genero
    private long generoId;
}
