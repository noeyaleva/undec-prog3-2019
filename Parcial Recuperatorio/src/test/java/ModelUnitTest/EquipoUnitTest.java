package ModelUnitTest;

import Model.Equipo;
import Model.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EquipoUnitTest {

    @Test
    public void factoryEquipo_EquipoCompleto_instanciaCorrecta() throws EquipoIncompletoException {

        Equipo elEquipo= Equipo.instancia(1,"Barcelona", new ArrayList<Jugador>());
        Assertions.assertNotNull(elEquipo);

    }

    @Test
    public void factoryEquipo_EquipoIncompleto_EquipoIncompletoException(){
        Assertions.assertThrows(EquipoIncompletoException.class, () -> Equipo.instancia(null,null,null));

    }
}
