package Repositorio;

import Model.Jugador;

public interface IRepositorioCrearJugador {
    Jugador findByDocumento(String s);

    boolean guardar(Jugador elJugador);
}
