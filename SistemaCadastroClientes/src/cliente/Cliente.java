package cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Double saldo;
 
    public Cliente(String nome, String cpf, String email, String endereco, Double saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
    
	public void debitarCredito(double valor) {
	    if (valor <= 0) {
	        throw new IllegalArgumentException("O valor deve ser positivo.");
	    }
	    if (this.saldo < valor) {
	        throw new RuntimeException("Saldo insuficiente.");
	    }
	    this.saldo -= valor;
	}
	
	public List<Cliente> listarClientes(List<Cliente> clientes) {
	    List<Cliente> clientesListados = new ArrayList<>();

	    for (Cliente cliente : clientes) {
	        clientesListados.add(cliente);
	    }

	    return clientesListados;
	}
}
