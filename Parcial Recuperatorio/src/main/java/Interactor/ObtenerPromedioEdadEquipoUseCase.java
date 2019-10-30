package Interactor;

import Model.Equipo;

public class ObtenerPromedioEdadEquipoUseCase {
    private IRepositorioObtenerEquipo iRepositorioObtenerEquipo;

    public ObtenerPromedioEdadEquipoUseCase(IRepositorioObtenerEquipo iRepositorioObtenerEquipo) {

        this.iRepositorioObtenerEquipo = iRepositorioObtenerEquipo;
    }

    public double obtenerPromedioEdad(Equipo elEquipo) {
        return Math.round(this.iRepositorioObtenerEquipo.obtenerEquipoPorNombre(elEquipo.getNombre()).obtenerPromedioEdad()*100.0)/100.0;

    }


}
