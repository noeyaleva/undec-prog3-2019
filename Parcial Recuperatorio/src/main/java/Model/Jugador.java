package Model;

import Exceptions.JugadorIncompletoException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Jugador {


    private Integer idJugador;
    private String nombre;
    private LocalDate fechaNacimiento;
    private double estatura;
    private String documento;

    private Jugador(Integer idJugador, String nombre, LocalDate fechaNacimiento, double estatura, String documento) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estatura = estatura;
        this.documento = documento;
    }

    public static Jugador instancia(Integer id, String lionel_messi, LocalDate of, double v, String s) throws JugadorIncompletoException {
        if(id == null || lionel_messi == null || of == null || v == -1 || s == null){
            throw new JugadorIncompletoException();
        }
        else{
            return new Jugador(id,lionel_messi,of,v,s);
        }
    }

    public Integer getEdad(){
        LocalDate fechaActual = LocalDate.now();
        Integer edad = Period.between(fechaActual, this.fechaNacimiento).getYears();
        return edad;
    }

    public double getEstatura() {
        return estatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(documento, jugador.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
