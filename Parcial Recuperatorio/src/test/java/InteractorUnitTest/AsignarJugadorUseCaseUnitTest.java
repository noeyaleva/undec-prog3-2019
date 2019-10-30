package InteractorUnitTest;

import Interactor.AsignarJugadorUseCase;
import Mockito.MockitoExtension;
import Model.Equipo;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class AsignarJugadorUseCaseUnitTest {

    @Mock
    private IRepositorioAsignarJugador iRepositorioAsignarJugador;

    @Test
    public void asignarjugador_JugadorNoAsignado_AsignaCorrectamente() throws EquipoIncompletoException, JugadorIncompletoException, JugadorAsignadoException {
        Equipo elEquipo = Equipo.instancia(1,"Barcelona", new ArrayList<>());
        Jugador messi= Jugador.instancia(1,"Lionel Messi", LocalDate.of(1987,6,24), 1.7, "12345678");
        Jugador ronaldo=Jugador.instancia(2,"Luis Suarez", LocalDate.of(1987,1,24), 1.82, "87654321");
        elEquipo.asignarJugador(messi);
        AsignarJugadorUseCase asignarJugadorUseCase=new AsignarJugadorUseCase(iRepositorioAsignarJugador);
        Assertions.assertTrue(asignarJugadorUseCase.asignarJugador(ronaldo, elEquipo));
    }

    @Test
    public void asignarjugador_JugadorYaAsignado_JugadorAsignadoException() throws EquipoIncompletoException, JugadorIncompletoException {
        Equipo elEquipo = Equipo.instancia(1,"Barcelona", new ArrayList<>());
        Jugador messi= Jugador.instancia(1,"Lionel Messi", LocalDate.of(1987,6,24), 1.7, "12345678");
        elEquipo.asignarJugador(messi);
        AsignarJugadorUseCase asignarJugadorUseCase=new AsignarJugadorUseCase(iRepositorioAsignarJugador);
        Assertions.assertThrows(JugadorAsignadoException.class, ()-> asignarJugadorUseCase.asignarJugador(messi, elEquipo));
    }
}
