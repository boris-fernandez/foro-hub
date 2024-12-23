package foro.hub.proyecto.domain.usuario.data;

import jakarta.validation.constraints.NotNull;

public record RegistrarUsuario(
        @NotNull
        String nombre,
        @NotNull
        String correo,
        @NotNull
        String contrasena
) {
}
