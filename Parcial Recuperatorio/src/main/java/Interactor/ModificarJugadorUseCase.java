package Interactor;

import Model.Jugador;
import Repositorio.IRepositorioModificarJugador;

public class ModificarJugadorUseCase {
    private IRepositorioModificarJugador iRepositorioModificarJugador;

    public ModificarJugadorUseCase(IRepositorioModificarJugador iRepositorioModificarJugador) {

    }

    public boolean modificarJugador(Jugador messiDatosNuevos) {
        return iRepositorioModificarJugador.actualizar(messiDatosNuevos);
    }
}
