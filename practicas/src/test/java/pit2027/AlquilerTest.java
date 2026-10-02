package pit2027;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class AlquilerTest {

    private static final long DIA_EN_MILIS = 24L * 60L * 60L * 1000L;

    @Test
    public void deberiaDevolverLosDatosDelAlquiler() {
        Vehiculo vehiculo = new Turismo("ALQ123", Categoria.NORMAL, 2023, 4, 300.0);
        Cliente cliente = new Cliente("Luis Garcia", "87654321B");
        Date inicio = new Date(0L);
        Date fin = new Date(3L * DIA_EN_MILIS);
        Alquiler alquiler = new Alquiler(vehiculo, cliente, inicio, fin);

        assertSame(vehiculo, alquiler.getVehiculo());
        assertSame(cliente, alquiler.getCliente());
        assertEquals(inicio, alquiler.getFechaInicio());
        assertEquals(fin, alquiler.getFechaFin());
    }

    @Test
    public void deberiaCalcularElPrecioSegunLosDias() {
        Alquiler alquiler = crearAlquiler();

        assertEquals(150, alquiler.calcularPrecioAlquiler(new Date(0L), new Date(3L * DIA_EN_MILIS)));
    }

    @Test
    public void deberiaRegistrarElAlquilerEnElArrayEstatico() {
        Alquiler alquiler = crearAlquiler();

        Alquiler.agregarAlquiler(alquiler);

        assertTrue(contieneAlquiler(alquiler));
    }

    @Test
    public void obtenerAlquileresDeberiaDevolverElArrayDeAlquileres() {
        assertEquals(1000, Alquiler.obtenerAlquileres().length);
    }

    @Test
    public void toStringDeberiaContenerLosDatosDelAlquiler() {
        Alquiler alquiler = crearAlquiler();

        String resultado = alquiler.toString();

        assertTrue(resultado.contains("ALQ123"));
        assertTrue(resultado.contains("Luis Garcia"));
    }

    private Alquiler crearAlquiler() {
        Vehiculo vehiculo = new Turismo("ALQ123", Categoria.NORMAL, 2023, 4, 300.0);
        Cliente cliente = new Cliente("Luis Garcia", "87654321B");
        return new Alquiler(vehiculo, cliente, new Date(0L), new Date(3L * DIA_EN_MILIS));
    }

    private boolean contieneAlquiler(Alquiler esperado) {
        for (Alquiler alquiler : Alquiler.obtenerAlquileres()) {
            if (alquiler == esperado) {
                return true;
            }
        }
        return false;
    }
}
