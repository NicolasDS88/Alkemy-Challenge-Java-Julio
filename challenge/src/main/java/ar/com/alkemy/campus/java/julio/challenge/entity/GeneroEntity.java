package ar.com.alkemy.campus.java.julio.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "genero")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    @Column(name = "pelicula_serie")
    private String nombre;

    @OneToMany(mappedBy = "genero")
    private Set<PeliculaSerieEntity> peliculasSeriesPorGenero= new HashSet<>();
}
