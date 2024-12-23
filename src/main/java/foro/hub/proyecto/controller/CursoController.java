package foro.hub.proyecto.controller;

import foro.hub.proyecto.domain.curso.Categoria;
import foro.hub.proyecto.domain.curso.CursoRepository;
import foro.hub.proyecto.domain.curso.data.ListaNombreCurso;
import foro.hub.proyecto.domain.curso.data.ListasCurso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //Listar Cursos
    @GetMapping
    public ResponseEntity<Page<ListasCurso>> listaCursos(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(cursoRepository.findAll(pageable).map(ListasCurso::new));
    }

    //Listar Cursos Por Categoria
    @GetMapping("/{categoria}")
    public ResponseEntity<Page<ListaNombreCurso>> listaCursosPorCategoria(@PageableDefault(size = 10) Pageable pageable,
                                                                           @PathVariable Categoria categoria) {
        Page<ListaNombreCurso> cursos = cursoRepository.findByCategoria(categoria, pageable).map(ListaNombreCurso::new);
        return ResponseEntity.ok(cursos);
    }
}
