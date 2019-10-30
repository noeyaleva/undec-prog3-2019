package Interactor;

import Model.Equipo;
import Repositorio.IRepositorioCrearEquipo;

import java.util.ArrayList;
import java.util.Collection;

public class CrearEquipoUseCase implements IRepositorioCrearEquipo{
    private IRepositorioCrearEquipo iRepositorioCrearEquipo;
    private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    public CrearEquipoUseCase(IRepositorioCrearEquipo crearEquipoGateway) {

    }

    public boolean crearEquipo(Equipo equipoNuevo) {
        return iRepositorioCrearEquipo.guardar(equipoNuevo);
    }

    @Override
    public boolean guardar(Equipo equipoNuevo) {
        for (int i = 0; i < equipos.size(); i++) {
            if(equipos.iterator().next().getNombre().equals(equipoNuevo)){
                return false;
            }
            else {
                equipos.add(equipoNuevo);
                return true;
            }
        }
        return false;
    }

    @Override
    public Equipo findByNombre(String barcelona) {
        return null;
    }
}
