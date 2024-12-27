package foro.hub.proyecto.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByCursoNombre(String cursoNombre, Pageable pageable);

    boolean existsTopicoByTituloAndMensaje(String titulo, String mensaje);

}
