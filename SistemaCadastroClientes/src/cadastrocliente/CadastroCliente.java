package cadastrocliente;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;

public class CadastroCliente {
    private List<Cliente> clientes;

    public CadastroCliente() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        this.clientes.remove(cliente);
    }

    public void atualizarCliente(Cliente clienteAntigo, Cliente clienteNovo) {
        if (clienteAntigo == null || clienteNovo == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        int index = clientes.indexOf(clienteAntigo);
        if (index >= 0) {
            clientes.set(index, clienteNovo);
        }
    }

    public Cliente buscarClientePorCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        for (Cliente cliente : clientes) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> buscarClientesPorNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }
        List<Cliente> clientesEncontrados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (nome.equals(cliente.getNome())) {
                clientesEncontrados.add(cliente);
            }
        }
        return clientesEncontrados;
    }
    
    public List<Cliente> listarClientes(List<Cliente> clientes) {
        List<Cliente> clientesListados = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesListados.add(cliente);
        }

        return clientesListados;
    }
    
}

