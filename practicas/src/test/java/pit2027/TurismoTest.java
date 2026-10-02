package pit2027;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurismoTest {

    @Test
    public void deberiaDevolverLasCaracteristicasDelTurismo() {
        Turismo turismo = new Turismo("TUR123", Categoria.NORMAL, 2022, 5, 400.0);

        assertEquals(5, turismo.getPlazas());
        assertEquals(400.0, turismo.getCapacidadMaletero(), 0.0);
    }
}
