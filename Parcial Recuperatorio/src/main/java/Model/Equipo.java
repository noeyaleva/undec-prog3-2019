package Model;



import Exceptions.EquipoIncompletoException;
import Exceptions.JugadorAsignadoException;

import java.util.ArrayList;
import java.util.Collection;

public class Equipo {

    private Integer idEquipo;
    private String nombre;
    private Collection<Jugador> jugadores;


    public static Equipo instancia(Integer i, String barcelona, ArrayList<Jugador> jugadors) throws EquipoIncompletoException {
        if(i == null || barcelona == null || jugadors == null){
            throw new EquipoIncompletoException();
        }
        else{

            return new Equipo(i, barcelona, jugadors);
        }

    }

    private Equipo(Integer idEquipo, String nombre, Collection<Jugador> jugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    public boolean asignarJugador(Jugador elJugador) {
        if(jugadores.contains(elJugador)){
            return false;
        }
        else{
            jugadores.add(elJugador);
            return true;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public float obtenerPromedioEdad() {
        float suma = 0;
        float promedio = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            suma += jugadores.iterator().next().getEdad();
        }
        promedio = suma / jugadores.size();
        return promedio;
    }

    public float obtenerPromedioEstatura() {
        float suma = 0;
        float estatura = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            suma += jugadores.iterator().next().getEstatura();
        }
        estatura = suma / jugadores.size();
        return estatura;
    }
}
