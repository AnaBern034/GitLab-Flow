package Model;

public class PagamentoCartaoCredito implements Pagamento{

    private String numeroCartao;
    private int cvv;
    private double preco;


    public PagamentoCartaoCredito(String numeroCartao,int cvv) {
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    @Override
    public void efetuarPagamento(double valor) {
        preco = valor * 0.10;
    }

    public double getPreco() {
        return preco;

    }
}
