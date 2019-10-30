package ModelUnitTest;

import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class JugadorUnitTest {

    @Test
    public void factoryJugador_JugadorCompleto_instanciaCorrecta() throws JugadorIncompletoException {

        Jugador elJugador= Jugador.instancia(1,"Lionel Messi", LocalDate.of(1987,6,24), 1.7, "12345678");
        Assertions.assertNotNull(elJugador);

    }

    @Test
    public void factoryJugador_JugadorIncompleto_JugadorIncompletoException(){
        Assertions.assertThrows(JugadorIncompletoException.class, () -> Jugador.instancia(null,null,null, 0.0, null));

    }
}
