package ar.com.alkemy.campus.java.julio.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "peliculas_series")
@Getter
@Setter
public class PeliculaSerieEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String titulo;
    private Integer calificacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;

    @ManyToMany(mappedBy = "peliculasSeries", cascade = CascadeType.ALL)
    private Set<PersonajeEntity> personajes = new HashSet<>();

    @Column(name = "personaje_id", nullable = false)
    private String personajeId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;
}
