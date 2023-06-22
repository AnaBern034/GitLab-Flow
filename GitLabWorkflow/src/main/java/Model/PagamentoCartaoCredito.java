package Model;

public class PagamentoCartaoCredito implements Pagamento{

    private String numeroCartao;
    private String cvv;
    private String nome;
    private double valorCartao;

    @Override
    public void efetuarPagamento(double valor) {

    }
}
