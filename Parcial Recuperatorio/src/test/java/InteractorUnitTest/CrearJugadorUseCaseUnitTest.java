package InteractorUnitTest;

import Mockito.MockitoExtension;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearJugadorUseCaseUnitTest {

    @Mock
    IRepositorioCrearJugador crearJugadorGateway;


    @Test
    public void crearJugador_JugadorNoExiste_GuardaCorrectamente() throws JugadorIncompletoException, JugadorExisteException {
        Jugador elJugador= Jugador.instancia(null,"Lionel Messi", LocalDate.of(1987,6,24), 1.7, "12345678");
        when(crearJugadorGateway.findByDocumento("12345678")).thenReturn(null);
        when(crearJugadorGateway.guardar(elJugador)).thenReturn(true);
        CrearJugadorUseCase crearJugadorUseCase = new CrearJugadorUseCase(crearJugadorGateway);
        boolean resultado = crearJugadorUseCase.crearJugador(elJugador);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearJugador_JugadorExiste_JugadorExisteException() throws JugadorIncompletoException {
        Jugador elJugador= Jugador.instancia(null,"Lionel Messi", LocalDate.of(1987,6,24), 1.7, "12345678");
        when(crearJugadorGateway.findByDocumento("12345678")).thenReturn(Jugador.instancia(2,"Cristiano Ronaldo", LocalDate.of(1985,2,5), 1.87, "12345678"));
        CrearJugadorUseCase crearJugadorUseCase = new CrearJugadorUseCase(crearJugadorGateway);
        Assertions.assertThrows(JugadorExisteException.class, () -> crearJugadorUseCase.crearJugador(elJugador));

    }
}
