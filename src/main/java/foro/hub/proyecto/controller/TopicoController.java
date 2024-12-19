package foro.hub.proyecto.controller;

import foro.hub.proyecto.domain.topico.model.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    public String titulo(){
        Topico topico = new Topico(null, "boris", null, null, null, null, null, null);
        return topico.getTitulo();
    }
}
