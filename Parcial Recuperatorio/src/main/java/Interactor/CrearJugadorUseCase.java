package Interactor;

import Exceptions.JugadorExisteException;
import Model.Jugador;
import Repositorio.IRepositorioCrearJugador;

import java.util.Collection;

public class CrearJugadorUseCase implements IRepositorioCrearJugador{
    private Collection<Jugador> jugadores;
    public CrearJugadorUseCase(IRepositorioCrearJugador crearJugadorGateway) {
    }

    public boolean crearJugador(Jugador elJugador) {
        return guardar(elJugador);
    }

    @Override
    public Jugador findByDocumento(String s) {
        return null;
    }

    @Override
    public boolean guardar(Jugador elJugador) {
       // for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.iterator().next().equals(elJugador)){
                return false;
            }
            else {
                jugadores.add(elJugador);
                return true;
            }
 //       }
    }
}
