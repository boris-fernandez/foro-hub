package foro.hub.proyecto.domain.topico;

import foro.hub.proyecto.domain.ValidacionException;
import foro.hub.proyecto.domain.curso.Curso;
import foro.hub.proyecto.domain.curso.CursoRepository;
import foro.hub.proyecto.domain.topico.data.*;
import foro.hub.proyecto.domain.topico.validations.ValidadorDeDuplicado;
import foro.hub.proyecto.domain.usuario.Usuario;
import foro.hub.proyecto.domain.usuario.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class TopicoService {

    private final CursoRepository cursoRepository;

    private final TopicoRepository topicoRepository;

    private final UsuarioRepository usuarioRepository;

    private List<ValidadorDeDuplicado> validadorDeDuplicados;

    public TopicoService(CursoRepository cursoRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, List<ValidadorDeDuplicado> validadorDeDuplicados) {
        this.cursoRepository = cursoRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.validadorDeDuplicados = validadorDeDuplicados;
    }

    public RespuestaTopico registro(RegistroTopico datos){
        if (!cursoRepository.existsById(datos.idCurso())){
            throw new ValidacionException("El curso no existe");
        }
        if (!usuarioRepository.existsById(datos.idAutor())){
            throw new ValidacionException("El usuario no existe");
        }

        //Validaciones
        validadorDeDuplicados.forEach(v -> v.validar(datos));

        LocalDateTime fechaCreacion = LocalDateTime.now();
        Boolean status = false;
        Integer respuestas = 0;
        Curso curso = cursoRepository.getReferenceById(datos.idCurso());
        Usuario autor = usuarioRepository.getReferenceById(datos.idAutor());
        Topico topico = new Topico(null, datos.titulo(), datos.mensaje(), fechaCreacion, status, autor, curso, respuestas);

        topicoRepository.save(topico);

        return new RespuestaTopico(topico);
    }

    public Page<DatosTopico> listadoTopico(Pageable pageable) {
        Page<Topico> topicos = topicoRepository.findAll(pageable);

        return topicos.map(DatosTopico::new);
    }

    public Page<DatosTopico> listadoTopicosPorCurso(String nombre, Pageable pageable) {
        Page<Topico> topicos = topicoRepository.findAllByCursoNombre(nombre, pageable);

        return topicos.map(DatosTopico::new);
    }

    public DetalleTopico detalleTopico(Long idTopico){
        if (!topicoRepository.existsById(idTopico)){
            throw new ValidacionException("El topico no existe");
        }

        DetalleTopico topico = topicoRepository.findById(idTopico).map(DetalleTopico::new).get();

        return topico;
    }

    public DatosTopico actualizar(Long id,ActualizarTopico datos){
        Optional<Topico> verificar = topicoRepository.findById(id);

        if (verificar.isPresent()){
            Topico topico = verificar.get();
            topico.actualizarDatosTopico(datos);
            return new DatosTopico(topico);
        }
        throw new ValidacionException("El topico no existe");
    }

    public void eliminarTopico(Long id){
        if (!topicoRepository.existsById(id)){
            throw new ValidacionException("El topico no existe");
        }
        topicoRepository.deleteById(id);
    }
}
