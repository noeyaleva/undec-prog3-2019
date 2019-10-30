package InteractorUnitTest;

import Mockito.MockitoExtension;
import Model.Equipo;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerPromedioEstaturaEquipoUseCaseUnitTest {

    @Mock
    private IRepositorioObtenerEquipo iRepositorioObtenerEquipo;

    @Test
    public void obtenerPromedioEstatura_EquipoConJugadores_ObtienePromedio() throws EquipoIncompletoException, JugadorIncompletoException {
        Equipo elEquipo = factoryEquipo();
        when(iRepositorioObtenerEquipo.obtenerEquipoPorNombre("Barcelona")).thenReturn(elEquipo);

        ObtenerPromedioEstaturaEquipoUseCase obtenerPromedioEstaturaEquipo = new ObtenerPromedioEstaturaEquipoUseCase(iRepositorioObtenerEquipo);

        double promedio = obtenerPromedioEstaturaEquipo.obtenerPromedioEstatura(elEquipo);
        Assertions.assertEquals(1.75, promedio, 0.1);
    }

    private Equipo factoryEquipo() throws EquipoIncompletoException, JugadorIncompletoException {
        Equipo elEquipo = Equipo.instancia(1, "Barcelona", new ArrayList<>());
        Jugador messi = Jugador.instancia(1, "Lionel Messi", LocalDate.of(1987, 6, 24), 1.7, "12345678");
        Jugador suarez = Jugador.instancia(2, "Luis Suarez", LocalDate.of(1987, 1, 24), 1.82, "87654321");
        Jugador neymar = Jugador.instancia(3, "Neymar", LocalDate.of(1992, 2, 5), 1.75, "18273645");
        elEquipo.asignarJugador(messi);
        elEquipo.asignarJugador(suarez);
        elEquipo.asignarJugador(neymar);
        return elEquipo;
    }
}
