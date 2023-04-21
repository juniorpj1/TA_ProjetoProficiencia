package pagamento;

public class Pagamento {
    private double valorPago;
    private boolean realizado;

    public Pagamento() {
        this.valorPago = 0.0;
        this.realizado = false;
    }

    public void realizarPagamento(double valor) {
        if (valor <= 0.0) {
            throw new IllegalArgumentException("O valor pago deve ser maior que zero");
        }
        this.valorPago = valor;
        this.realizado = true;
    }

    public double getValorPago() {
        return valorPago;
    }

    public boolean isRealizado() {
        return realizado;
    }
}

