package Repositorio;

import Interactor.ObtenerPromedioEdadEquipoUseCase;
import Model.Equipo;

public interface IRepositorioObtenerEquipo {
    Equipo obtenerEquipoPorNombre(String nombre);
}
