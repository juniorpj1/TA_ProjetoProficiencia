package pedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cliente.Cliente;
import item.Item;
import pagamento.Pagamento;

@DisplayName("Testes da classe Pedido")
class PedidoTest {
	
	private Pedido pedido;
	private Cliente cliente;
	private Item item1;
	private Item item2;
	
	@BeforeEach
	void inicializar() {
		cliente = new Cliente("João", "123.456.789-00", "cliente@gmail.com", "teste", 100.0);
		pedido = new Pedido(cliente);
		item1 = new Item("Caneta", 1.5);
		item2 = new Item("Borracha", 0.8);
		pedido.adicionarItem(item1);
		pedido.adicionarItem(item2);
	}
	
	@Test
	@DisplayName("Teste do construtor com cliente nulo")
	void testConstrutorComClienteNulo() {
		assertThrows(IllegalArgumentException.class, () -> new Pedido(null));
	}
	
	@Test
	@DisplayName("Teste do método adicionarItem com item nulo")
	void testAdicionarItemComItemNulo() {
		assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(null));
	}
	
	@Test
	@DisplayName("Teste do método removerItem")
	void testRemoverItem() {
		pedido.removerItem(item1);
		assertFalse(pedido.getItens().contains(item1));
		assertTrue(pedido.getItens().contains(item2));
	}
	
	@Test
	@DisplayName("Teste do método realizarPagamento com valor pago menor que valor total do pedido")
	void testRealizarPagamentoComValorPagoMenorQueValorTotal() {
		Pagamento pagamento = new Pagamento(pedido.getValorTotal() - 0.1, false);
		assertThrows(RuntimeException.class, () -> pedido.realizarPagamento(pagamento));
	}
	
	@Test
	@DisplayName("Teste do método realizarPagamento com valor pago igual ao valor total do pedido")
	void testRealizarPagamentoComValorPagoIgualAoValorTotal() {
		Pagamento pagamento = new Pagamento(pedido.getValorTotal(), true);
		pedido.realizarPagamento(pagamento);
		assertTrue(pedido.getPagamentos().contains(pagamento));
	}
	
	@Test
	@DisplayName("Teste do método realizarVenda sem itens no pedido")
	void testRealizarVendaSemItensNoPedido() {
		Pedido pedidoVazio = new Pedido(cliente);
		assertFalse(pedidoVazio.realizarVenda());
	}
	
	@Test
	@DisplayName("Teste do método realizarVenda com saldo insuficiente do cliente")
	void testRealizarVendaComSaldoInsuficiente() {
		cliente.setSaldo(0.0);
		assertFalse(pedido.realizarVenda());
	}
	
	@Test
	@DisplayName("Teste do método realizarVenda com sucesso")
	void testRealizarVendaComSucesso() {
		assertTrue(pedido.realizarVenda());
		assertTrue(pedido.isPago());
		assertTrue(item1.isPago());
		assertTrue(item2.isPago());
		assertEquals(97.7, cliente.getSaldo());
	}
}
