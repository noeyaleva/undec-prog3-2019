package Repositorio;

import Model.Jugador;

public interface IRepositorioModificarJugador {
    boolean actualizar(Jugador messiDatosNuevos);

    Jugador findByDNI(String s);
}
