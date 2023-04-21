package item;

public class Item {
    private String nome;
    private double preco;
    private boolean pago;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public boolean isPago() {
		return pago;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

	public void setPago(boolean pago) {
		this.pago = pago;
		
	}
}

