package venda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import cadastrocliente.CadastroCliente;
import cliente.Cliente;
import item.Item;
import pedido.Pedido;

@DisplayName("Teste da classe Venda")
class VendaTest {

    private Venda venda;
    private CadastroCliente cadastroCliente;
    private Cliente cliente;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        cadastroCliente = new CadastroCliente();
       Cliente cliente = new Cliente("João da Silva", "111.111.111-11", "joao@gmail.com", "Rua A, 123", 100.0);
        cadastroCliente.adicionarCliente(cliente);
        venda = new Venda(cadastroCliente);
        pedido = new Pedido(cliente);
        pedido.adicionarItem(new Item("Produto 1", 10.0));
        pedido.adicionarItem(new Item("Produto 2", 20.0));
        venda.adicionarPedido(pedido);
    }

    @Test
    @DisplayName("Teste de adicionar pedido")
    void testAdicionarPedido() {
        Pedido novoPedido = new Pedido(cliente);
        novoPedido.adicionarItem(new Item("Produto 3", 15.0));
        venda.adicionarPedido(novoPedido);
        assertEquals(2, venda.getPedidos().size());
        assertEquals(85.0, venda.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Teste de realizar pagamento com valor maior que o total da venda")
    void testRealizarPagamentoValorMaiorQueTotal() {
        assertThrows(IllegalArgumentException.class, () -> venda.realizarPagamento(1000.0));
    }

    @Test
    @DisplayName("Teste de realizar pagamento com valor negativo")
    void testRealizarPagamentoValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> venda.realizarPagamento(-100.0));
    }

    @Test
    @DisplayName("Teste de realizar pagamento com valor válido")
    void testRealizarPagamentoValorValido() {
        venda.realizarPagamento(40.0);
        assertEquals(50.0, venda.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Teste de finalizar venda com pedidos pendentes")
    void testFinalizarVendaComPedidosPendentes() {
        venda.finalizarVenda();
        assertFalse(pedido.isPago());
    }

    @Test
    @DisplayName("Teste de finalizar venda com todos os pedidos pagos")
    void testFinalizarVendaComTodosOsPedidosPagos() {
        venda.realizarPagamento(50.0);
        venda.finalizarVenda();
        assertTrue(pedido.isPago());
    }

}
