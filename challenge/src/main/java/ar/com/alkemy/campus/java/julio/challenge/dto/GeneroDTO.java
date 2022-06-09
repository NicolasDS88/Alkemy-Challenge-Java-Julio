package ar.com.alkemy.campus.java.julio.challenge.dto;

import ar.com.alkemy.campus.java.julio.challenge.entity.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GeneroDTO {
    private Long id;
    private String imagen;
    private String nombre;
    //private Set<PeliculaEntity> peliculasPorGenero= new HashSet<>();
}
