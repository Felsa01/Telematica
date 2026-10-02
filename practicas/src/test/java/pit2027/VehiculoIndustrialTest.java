package pit2027;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VehiculoIndustrialTest {

    @Test
    public void deberiaDevolverLasCaracteristicasDelVehiculoIndustrial() {
        VehiculoIndustrial vehiculo = new VehiculoIndustrial("IND123", Categoria.ESPECIAL, 2021, 1200, 4);

        assertEquals(1200, vehiculo.getCapacidadCarga());
        assertEquals(4, vehiculo.getNumeroEjes());
    }
}
