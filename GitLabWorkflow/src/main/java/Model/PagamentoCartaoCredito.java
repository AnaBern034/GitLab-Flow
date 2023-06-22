package Model;

public class PagamentoCartaoCredito implements Pagamento{

    private String numeroCartao;
    private int cvv;
    private double valorCartao;


    public PagamentoCartaoCredito(String numeroCartao,int cvv) {
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    @Override
    public void efetuarPagamento(double valor) {
        valorCartao = valor * 0.10;
    }
}
