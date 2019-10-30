package InteractorUnitTest;

import Mockito.MockitoExtension;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ModificarJugadorUseCaseUnitTest {

    @Mock
    IRepositorioModificarJugador iRepositorioModificarJugador;

    @Test
    public void modificarJugador_NoHayConflicto_JugadorModificado() throws JugadorIncompletoException, JugadorExisteException {
        Jugador messiDatosNuevos = Jugador.instancia(1, "Lionel Andres Messi", LocalDate.of(1987, 6, 24), 1.7, "12345678");

        when(iRepositorioModificarJugador.findByDNI("12345678")).thenReturn(null);
        when(iRepositorioModificarJugador.actualizar(messiDatosNuevos)).thenReturn(true);

        ModificarJugadorUseCase modificarJugadorUseCase=new ModificarJugadorUseCase(iRepositorioModificarJugador);
        boolean resultado=modificarJugadorUseCase.modificarJugador(messiDatosNuevos);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void modificarJugador_ExisteConflicto_JugadorExisteException() throws JugadorIncompletoException {
        Jugador messiDatosNuevos = Jugador.instancia(1, "Lionel Andres Messi", LocalDate.of(1987, 6, 24), 1.7, "87654321");
        when(iRepositorioModificarJugador.findByDNI("87654321")).thenReturn(Jugador.instancia(2,"Cristiano Ronaldo", LocalDate.of(1985,2,5), 1.87, "87654321"));

        ModificarJugadorUseCase modificarJugadorUseCase=new ModificarJugadorUseCase(iRepositorioModificarJugador);

        Assertions.assertThrows(JugadorExisteException.class,()->modificarJugadorUseCase.modificarJugador(messiDatosNuevos));

    }
}
