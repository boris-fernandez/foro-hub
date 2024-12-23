package foro.hub.proyecto.domain.usuario.data;

import foro.hub.proyecto.domain.usuario.Usuario;

public record RespuestaUsuario(
        Long id,
        String nombre,
        String correo) {

    public RespuestaUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo());
    }
}
