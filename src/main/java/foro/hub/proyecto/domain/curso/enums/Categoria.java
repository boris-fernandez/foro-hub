package foro.hub.proyecto.domain.curso.enums;

import lombok.Getter;

@Getter
public enum Categoria {
    PROGRAMACION("Programación"),
    FRONTEND("Front End"),
    DATASCIENCE("Data Science"),
    INNOVACION("Innovación y Gestión"),
    DEVOPS("Dev Ops"),
    OFFTOPIC("Off Topic");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

}
