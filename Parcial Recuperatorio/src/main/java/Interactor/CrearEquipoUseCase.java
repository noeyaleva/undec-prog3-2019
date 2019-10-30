package Interactor;

import Model.Equipo;
import Repositorio.IRepositorioCrearEquipo;

public class CrearEquipoUseCase {
    private IRepositorioCrearEquipo iRepositorioCrearEquipo;
    public CrearEquipoUseCase(IRepositorioCrearEquipo crearEquipoGateway) {

    }

    public boolean crearEquipo(Equipo equipoNuevo) {
        return iRepositorioCrearEquipo.guardar(equipoNuevo);
    }
}
