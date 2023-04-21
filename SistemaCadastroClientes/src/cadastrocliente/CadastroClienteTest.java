package cadastrocliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;

public class CadastroClienteTest {

    private CadastroCliente cadastroCliente;
    private List<Cliente> clientes;

    @Before
    public void setUp() {
        cadastroCliente = new CadastroCliente();
        clientes = new ArrayList<>();
        clientes.add(new Cliente("111.111.111-11", "João da Silva", "joao@mail.com", "Rua A, 123", 1000.0));
        clientes.add(new Cliente("222.222.222-22", "Maria Souza", "maria@mail.com", "Rua B, 456", 2000.0));
        clientes.add(new Cliente("333.333.333-33", "José Almeida", "jose@mail.com", "Rua C, 789", 3000.0));
        clientes.add(new Cliente("444.444.444-44", "Ana Rodrigues", "ana@mail.com", "Rua D, 1011", 4000.0));
        clientes.add(new Cliente("555.555.555-55", "Pedro Oliveira", "pedro@mail.com", "Rua E, 1213", 5000.0));
    }


    @Test
    public void testAdicionarCliente() {
        Cliente novoCliente = new Cliente("555.555.555-55", "Pedro Oliveira", "pedro@mail.com", "Rua 1234, 1213", 5000.0);
        cadastroCliente.adicionarCliente(novoCliente);
        assertEquals(6, cadastroCliente.listarClientes(clientes).size());
    }

    @Test
    public void testRemoverCliente() {
        Cliente clienteParaRemover = clientes.get(0);
        cadastroCliente.removerCliente(clienteParaRemover);
        assertNull(cadastroCliente.buscarClientePorCpf("111.111.111-11"));
    }

    @Test
    public void testAtualizarCliente() {
        Cliente clienteAntigo = clientes.get(1);
        Cliente clienteNovo = new Cliente("444.444.444-44", "Ana Rodrigues", "ana@mail.com", "Rua D, 1011", 4000.0);
        cadastroCliente.atualizarCliente(clienteAntigo, clienteNovo);
        assertEquals("Maria Souza Silva", cadastroCliente.buscarClientePorCpf("222.222.222-22").getNome());
    }

    @Test
    public void testBuscarClientePorCpf() {
        Cliente clienteBuscado = cadastroCliente.buscarClientePorCpf("333.333.333-33");
        assertEquals("José Almeida", clienteBuscado.getNome());
    }

    @Test
    public void testBuscarClientesPorNome() {
        List<Cliente> clientesEncontrados = cadastroCliente.buscarClientesPorNome("Oliveira");
        assertEquals(1, clientesEncontrados.size());
    }

}
