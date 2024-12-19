package foro.hub.proyecto.domain.curso.model;

import foro.hub.proyecto.domain.curso.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "curso")
@Table(name = "cursos")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descripcion;
}
