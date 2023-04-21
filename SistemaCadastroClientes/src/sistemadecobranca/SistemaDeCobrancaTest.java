package sistemadecobranca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cliente.Cliente;

public class SistemaDeCobrancaTest {
    
    private SistemaDeCobranca sistemaDeCobranca;
    
    @BeforeEach
    public void setUp() {
        sistemaDeCobranca = new SistemaDeCobranca();
    }
    
    @Test
    @DisplayName("Teste de unidade: receber pagamento com valor positivo")
    public void testReceberPagamentoComValorPositivo() {
        double valor = 100.0;
        sistemaDeCobranca.receberPagamento(valor);
        Assertions.assertEquals(valor, sistemaDeCobranca.getSaldo());
    }
    
    @Test
    @DisplayName("Teste de unidade: receber pagamento com valor negativo")
    public void testReceberPagamentoComValorNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sistemaDeCobranca.receberPagamento(-100.0));
        Assertions.assertEquals(0.0, sistemaDeCobranca.getSaldo());
    }
    
    @Test
    @DisplayName("Teste de integração: receber pagamento e verificar saldo")
    public void testReceberPagamentoEVerificarSaldo() {
        double valor1 = 100.0;
        double valor2 = 50.0;
        sistemaDeCobranca.receberPagamento(valor1);
        sistemaDeCobranca.receberPagamento(valor2);
        Assertions.assertEquals(valor1 + valor2, sistemaDeCobranca.getSaldo());
    }
    
    @Test
    @DisplayName("Teste funcional: receber pagamento e verificar saldo atualizado")
    public void testReceberPagamentoEVerificarSaldoAtualizado() {
        double valor1 = 100.0;
        double valor2 = 50.0;
        sistemaDeCobranca.receberPagamento(valor1);
        Assertions.assertEquals(valor1, sistemaDeCobranca.getSaldo());
        sistemaDeCobranca.receberPagamento(valor2);
        Assertions.assertEquals(valor1 + valor2, sistemaDeCobranca.getSaldo());
    }
    
    @Test
    @DisplayName("Teste de aceitação: receber pagamento e verificar saldo atualizado")
    public void testReceberPagamentoVerificarSaldo() {
    SistemaDeCobranca sistemaDeCobranca = new SistemaDeCobranca();
    double valorCobranca = 50.0;
    double valorPagamento = 30.0;
    Cliente cliente = new Cliente("João da Silva", "111.111.111-11", "joao@gmail.com", "Rua A, 123", 100.0);
    sistemaDeCobranca.criarCobranca(cliente, valorCobranca);
    sistemaDeCobranca.receberPagamento(cliente, valorPagamento);
    double saldoEsperado = valorCobranca - valorPagamento;
    double saldoAtualizado = sistemaDeCobranca.consultarSaldo(cliente);
    Assertions.assertEquals(saldoEsperado, saldoAtualizado);

    }
    
}
