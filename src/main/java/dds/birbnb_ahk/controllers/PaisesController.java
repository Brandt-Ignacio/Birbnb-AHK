package dds.birbnb_ahk.controllers;

import dds.birbnb_ahk.entities.ubicaciones.Pais;
import dds.birbnb_ahk.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {
    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public ResponseEntity<List<Pais>> generarPaises(){
        Pais argentina = new Pais("Argentina");
        Pais francia = new Pais("Francia");
        Pais brasil = new Pais("Brasil");

        //ESTO GENERA UN INSERT EN LA BASE
        this.paisRepository.save(argentina);
        this.paisRepository.save(francia);
        this.paisRepository.save(brasil);

        return ResponseEntity.status(HttpStatus.CREATED).body(List.of(argentina,francia,brasil));
    }
}
