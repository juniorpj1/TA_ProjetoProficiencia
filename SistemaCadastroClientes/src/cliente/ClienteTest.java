package cliente;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente cliente;

    @Before
    public void setUp() throws Exception {
        cliente = new Cliente("João da Silva", "111.111.111-11", "joao@gmail.com", "Rua A, 123", 100.0);
    }

    @Test
    public void testDebitarCredito() {
        cliente.debitarCredito(50.0);
        assertEquals(50.0, cliente.getSaldo(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDebitarCreditoComValorNegativo() {
        cliente.debitarCredito(-50.0);
    }

    @Test(expected = RuntimeException.class)
    public void testDebitarCreditoComSaldoInsuficiente() {
        cliente.debitarCredito(150.0);
    }

    @Test
    public void testListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        assertEquals(clientes, cliente.listarClientes(clientes));
    }
}

