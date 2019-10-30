package Interactor;

import Model.Equipo;
import Model.Jugador;

public class AsignarJugadorUseCase {
    private IRepositorioAsignarJugador iRepositorioAsignarJugador;

    public AsignarJugadorUseCase(IRepositorioAsignarJugador iRepositorioAsignarJugador) {

        this.iRepositorioAsignarJugador = iRepositorioAsignarJugador;
    }

    public boolean asignarJugador(Jugador elJugador, Equipo elEquipo) throws JugadorAsignadoException {
        if(elEquipo.asignarJugador(elJugador))
        {
            return true;
        }
        throw new JugadorAsignadoException();

    }
}
