package pedido;

import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;
import item.Item;
import pagamento.Pagamento;

public class Pedido {
	private Cliente cliente;
	private List<Item> itens;
	private List<Pagamento> pagamentos;
	private String cupomDesconto;
	private double valorTotal;
	private boolean pago;

	public Pedido(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente não pode ser nulo.");
		}
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.valorTotal = 0.0;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void adicionarItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item não pode ser nulo.");
		}
		this.itens.add(item);
	}

	
	public void removerCupom() {
		cupomDesconto = null;
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Item item : itens) {
			valorTotal += item.getPreco();
		}

		if (cupomDesconto != null && cupomDesconto.equals("DESCONTO10")) {
			this.valorTotal = this.valorTotal * 0.9;
		}

		return valorTotal;
	}

	public void removerItem(Item item) {
		itens.remove(item);
		this.valorTotal -= item.getPreco();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void realizarPagamento(Pagamento pagamento) {
		if (pagamento.getValorPago() < getValorTotal()) {
			throw new RuntimeException("Valor do pagamento é menor que o valor total do pedido.");
		}
		pagamentos.add(pagamento);
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
	
	public void setPago(boolean pago) {
	    for (Item item : itens) {
	        item.setPago(pago);
	    }
	}
	
	public boolean isPago() {
	    return pago;
	}

	public boolean realizarVenda() {
	    if (this.itens.isEmpty()) {
	        return false; // Não há itens no pedido para realizar a venda
	    }
	    
	    Cliente cliente = this.getCliente();
	    double valorTotal = this.getValorTotal();
	    
	    if (cliente.getSaldo() < valorTotal) {
	        return false; // Cliente não tem crédito suficiente para realizar a compra
	    }
	    
	    cliente.debitarCredito(valorTotal); // Deduz o valor total do crédito do cliente
	    this.setPago(true); // Marca o pedido como pago
	    
	    return true; // Venda realizada com sucesso
	}

	



}
