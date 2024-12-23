package foro.hub.proyecto.controller;

import foro.hub.proyecto.domain.usuario.Usuario;
import foro.hub.proyecto.domain.usuario.UsuarioRepository;
import foro.hub.proyecto.domain.usuario.data.RegistrarUsuario;
import foro.hub.proyecto.domain.usuario.data.RespuestaUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<RespuestaUsuario> registrarUsuario(@RequestBody @Valid RegistrarUsuario registrarUsuario,
                                           UriComponentsBuilder builder) {
        Usuario usuario = new Usuario(registrarUsuario);
        usuarioRepository.save(usuario);
        RespuestaUsuario respuestaUsuario = new RespuestaUsuario(usuario);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(respuestaUsuario);
    }

}
