package pit2027;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VehiculoTest {

    @Test
    public void deberiaDevolverLosDatosBasicosDelVehiculo() {
        Vehiculo vehiculo = new Turismo("AAA111", Categoria.SUPERIOR, 2024, 5, 450.5);

        assertEquals("AAA111", vehiculo.getMatricula());
        assertEquals(Categoria.SUPERIOR, vehiculo.getCategoria());
        assertEquals(2024, vehiculo.getAnnio());
    }

    @Test
    public void deberiaCambiarLaDisponibilidad() {
        Vehiculo vehiculo = new Turismo("AAA111", Categoria.NORMAL, 2024, 5, 450.5);

        assertFalse(vehiculo.isDisponible());
        vehiculo.setDisponible(true);
        assertTrue(vehiculo.isDisponible());
        vehiculo.setDisponible(false);
        assertFalse(vehiculo.isDisponible());
    }

    @Test
    public void toStringDeberiaContenerLosDatosDelVehiculo() {
        Vehiculo vehiculo = new Turismo("AAA111", Categoria.NORMAL, 2024, 5, 450.5);

        String resultado = vehiculo.toString();

        assertTrue(resultado.contains("AAA111"));
        assertTrue(resultado.contains("NORMAL"));
    }
}
