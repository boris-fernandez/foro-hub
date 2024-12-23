package foro.hub.proyecto.domain.topico.validations;

import foro.hub.proyecto.domain.topico.data.RegistroTopico;

public interface ValidadorDeDuplicado {
    void validar(RegistroTopico datos);
}
