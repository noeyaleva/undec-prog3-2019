package Interactor;

import Model.Equipo;
import Repositorio.IRepositorioObtenerEquipo;

public class ObtenerPromedioEstaturaEquipoUseCase {
    private IRepositorioObtenerEquipo iRepositorioObtenerEquipo;
    public ObtenerPromedioEstaturaEquipoUseCase(IRepositorioObtenerEquipo iRepositorioObtenerEquipo) {
    }

    public double obtenerPromedioEstatura(Equipo elEquipo) {
        Equipo equipo = iRepositorioObtenerEquipo.obtenerEquipoPorNombre(elEquipo.getNombre());
        return equipo.obtenerPromedioEstatura();
    }
}
