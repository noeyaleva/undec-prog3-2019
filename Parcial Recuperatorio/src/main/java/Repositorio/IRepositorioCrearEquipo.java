package Repositorio;

import Model.Equipo;

public interface IRepositorioCrearEquipo {
    boolean guardar(Equipo equipoNuevo);

    Equipo findByNombre(String barcelona);
}
