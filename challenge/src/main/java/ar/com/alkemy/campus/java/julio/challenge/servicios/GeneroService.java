package ar.com.alkemy.campus.java.julio.challenge.servicios;


import ar.com.alkemy.campus.java.julio.challenge.dto.GeneroDTO;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    public GeneroDTO save(GeneroDTO dtoGuardar){
        //TODO: GUARDAR
        System.out.println("Genero Creado");
        return dtoGuardar;
    }

}
