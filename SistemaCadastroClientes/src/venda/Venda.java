/*
A classe Venda é responsável por realizar as operações de vendas do sistema, como adicionar pedidos, calcular o valor total da venda e realizar pagamentos. Ela possui uma referência ao CadastroCliente, que é utilizado para verificar se o cliente existe no sistema e obter seus dados. Além disso, a classe mantém uma lista de pedidos que foram adicionados à venda e um valor total que é atualizado conforme novos pedidos são adicionados. A classe também é responsável por realizar o pagamento da venda, verificando se o valor do pagamento é suficiente para cobrir o valor total da venda.
 */

package venda;

import java.util.ArrayList;
import java.util.List;
import cadastrocliente.CadastroCliente;
import cliente.Cliente;
import pedido.Pedido;

public class Venda {
	private CadastroCliente cadastroCliente;
	private ArrayList<Pedido> pedidos;
	private double valorTotal;


	public Venda(CadastroCliente cadastroCliente) {
	    if (cadastroCliente == null) {
	        throw new IllegalArgumentException("Cadastro de cliente não pode ser nulo.");
	    }
	    this.cadastroCliente = cadastroCliente;
	    this.valorTotal = 0.0;
	    this.pedidos = new ArrayList<>();
	}



	public void adicionarPedido(Pedido pedido) {
		if (pedido == null) {
			throw new IllegalArgumentException("Pedido não pode ser nulo.");
		}
		this.pedidos.add(pedido);
		this.valorTotal += pedido.getValorTotal();
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void realizarPagamento(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
		}
		if (valor > this.valorTotal) {
			throw new IllegalArgumentException("Valor do pagamento deve ser menor ou igual ao valor total da venda.");
		}
		this.valorTotal -= valor;
	}

	public void finalizarVenda() {
	    boolean todosPedidosPagos = true;
	    for (Pedido pedido : pedidos) {
	        if (!pedido.isPago()) {
	            todosPedidosPagos = false;
	            break;
	        }
	        Cliente cliente = pedido.getCliente();
	        if (cliente != null) {
	            cadastroCliente.atualizarCliente(cliente, cliente);
	        }
	    }
	    if (todosPedidosPagos) {
	        System.out.println("Venda finalizada.");
	    } else {
	        System.out.println("Não é possível finalizar a venda, há pedidos pendentes de pagamento.");
	    }
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
}
