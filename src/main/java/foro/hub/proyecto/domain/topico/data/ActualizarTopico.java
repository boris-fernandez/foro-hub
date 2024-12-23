package foro.hub.proyecto.domain.topico.data;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje) {
}
