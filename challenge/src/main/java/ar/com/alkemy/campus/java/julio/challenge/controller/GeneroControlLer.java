package ar.com.alkemy.campus.java.julio.challenge.controller;

import ar.com.alkemy.campus.java.julio.challenge.dto.GeneroDTO;
import ar.com.alkemy.campus.java.julio.challenge.servicios.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generos")
public class GeneroControlLer {

    @Autowired //inicializa el servicio
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero){
        //save genero
        GeneroDTO generoGuardado = generoService.save(genero);
        //devuelvo un 201 cuando guardo, sumnado al ID ya que lo asigna la DB
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }




}
