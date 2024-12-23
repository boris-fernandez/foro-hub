package foro.hub.proyecto.domain.usuario;

import foro.hub.proyecto.domain.usuario.data.RegistrarUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "correoElectronico")
    private String correo;
    private String contrasena;

    public Usuario(@Valid RegistrarUsuario registrarUsuario) {
        this.nombre = registrarUsuario.nombre();
        this.correo = registrarUsuario.correo();
        this.contrasena = registrarUsuario.contrasena();
    }
}
