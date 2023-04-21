package pagamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PagamentoTest {

    private Pagamento pagamento;

    @BeforeEach
    public void setup() {
        pagamento = new Pagamento();
    }

    @Test
    @DisplayName("Realizar pagamento com sucesso")
    public void testRealizarPagamento() {
        double valor = 100.0;
        pagamento.realizarPagamento(valor);
        Assertions.assertEquals(valor, pagamento.getValorPago());
        Assertions.assertTrue(pagamento.isRealizado());
    }

    @Test
    @DisplayName("Realizar pagamento com valor negativo")
    public void testRealizarPagamentoComValorNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> pagamento.realizarPagamento(-100.0));
        Assertions.assertEquals(0.0, pagamento.getValorPago());
        Assertions.assertFalse(pagamento.isRealizado());
    }

}