package foro.hub.proyecto.domain.topico.validations;

import foro.hub.proyecto.domain.ValidacionException;
import foro.hub.proyecto.domain.topico.TopicoRepository;
import foro.hub.proyecto.domain.topico.data.RegistroTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidacionTopicoDuplicado implements ValidadorDeDuplicado {

    private TopicoRepository topicoRepository;

    public ValidacionTopicoDuplicado(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar(RegistroTopico datos) {
        if (topicoRepository.existsTopicoByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidacionException("Topico ya existe");
        }
    }
}
