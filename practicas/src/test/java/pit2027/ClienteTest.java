package pit2027;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ClienteTest {

    @Test
    public void deberiaDevolverLosDatosDelCliente() {
        Cliente cliente = new Cliente("Ana Lopez", "12345678A");

        assertEquals("Ana Lopez", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());
    }

    @Test
    public void toStringDeberiaContenerLosDatosDelCliente() {
        Cliente cliente = new Cliente("Ana Lopez", "12345678A");

        String resultado = cliente.toString();

        assertTrue(resultado.contains("Ana Lopez"));
        assertTrue(resultado.contains("12345678A"));
    }
}
