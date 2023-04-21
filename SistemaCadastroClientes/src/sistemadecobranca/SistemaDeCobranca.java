package sistemadecobranca;

import java.util.HashMap;
import java.util.Map;

import cliente.Cliente;

public class SistemaDeCobranca {
	
    private Map<Cliente, Double> saldoClientes = new HashMap<>();
    
    private double saldo;
    
    public SistemaDeCobranca() {
        this.saldo = 0.0;
    }
    
    public void receberPagamento(double valor) {
        if (valor < 0.0) {
            throw new IllegalArgumentException("O valor do pagamento não pode ser negativo");
        }
        this.saldo += valor;
    }
        
    public Map<Cliente, Double> getSaldoClientes() {
		return saldoClientes;
	}

	public void setSaldoClientes(Map<Cliente, Double> saldoClientes) {
		this.saldoClientes = saldoClientes;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
        return this.saldo;
    }
    

    public void criarCobranca(Cliente cliente, double valor) {
        if (!saldoClientes.containsKey(cliente)) {
            saldoClientes.put(cliente, 0.0);
        }
        double saldoAtual = saldoClientes.get(cliente);
        saldoClientes.put(cliente, saldoAtual + valor);
    }
    
    public void receberPagamento(Cliente cliente, double valor) {
        if (!saldoClientes.containsKey(cliente)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        double saldoAtual = saldoClientes.get(cliente);
        double novoSaldo = saldoAtual - valor;
        if (novoSaldo < 0) {
            throw new IllegalArgumentException("Valor do pagamento excede o saldo devedor!");
        }
        saldoClientes.put(cliente, novoSaldo);
    }
    
    public double consultarSaldo(Cliente cliente) {
        if (!saldoClientes.containsKey(cliente)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        return saldoClientes.get(cliente);
    }


}

