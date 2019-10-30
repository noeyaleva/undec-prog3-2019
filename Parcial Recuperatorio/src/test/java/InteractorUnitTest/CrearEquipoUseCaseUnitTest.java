package InteractorUnitTest;

import Mockito.MockitoExtension;
import Model.Equipo;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearEquipoUseCaseUnitTest {

    @Mock
    IRepositorioCrearEquipo crearEquipoGateway;


    @Test
    public void crearEquipo_EquipoNoExiste_GuardaCorrectamente() throws EquipoIncompletoException, EquipoExisteException {
        Equipo EquipoNuevo=Equipo.instancia(null,"Barcelona", new ArrayList<Jugador>());
        when(crearEquipoGateway.findByNombre("Barcelona")).thenReturn(null);
        when(crearEquipoGateway.guardar(EquipoNuevo)).thenReturn(true);
        CrearEquipoUseCase crearEquipoUseCase = new CrearEquipoUseCase(crearEquipoGateway);
        boolean resultado = crearEquipoUseCase.crearEquipo(EquipoNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearEquipo_EquipoExiste_EquipoExisteException() throws EquipoIncompletoException {
        Equipo EquipoNuevo=Equipo.instancia(null,"Barcelona", new ArrayList<Jugador>());
        when(crearEquipoGateway.findByNombre("Barcelona")).thenReturn(Equipo.instancia(2,"Barcelona", new ArrayList<Jugador>()));
        CrearEquipoUseCase crearEquipoUseCase = new CrearEquipoUseCase(crearEquipoGateway);
        Assertions.assertThrows(EquipoExisteException.class, () -> crearEquipoUseCase.crearEquipo(EquipoNuevo));

    }
}
