package Model;

public class PagamentoCartaoCredito implements Pagamento{

    private String numeroCartao;
    private String cvv;
    private double preco;


    public PagamentoCartaoCredito(String numeroCartao,String cvv) {
        if (!validaNumeroCartao(numeroCartao)) throw new IllegalArgumentException("Numero de cartão invalido");
        if (!validarCVV(cvv)) throw new IllegalArgumentException("Numero Cvv inválido");
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
    public boolean validaNumeroCartao(String numeroCartao){
        // Verificar se o número do cartão possui 16 dígitos
        if (numeroCartao.length() != 16) {
            return false;
        }

        // Verificar se o número do cartão contém apenas dígitos
        if (!numeroCartao.matches("\\d+")) {
            return false;
        }

        // Verificar usando o algoritmo de Luhn
        int sum = 0;
        boolean doubleDigit = false;
        for (int i = numeroCartao.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(numeroCartao.charAt(i));

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
    public static boolean validarCVV(String cvv) {
        // Verificar se o CVV possui 3 dígitos
        if (cvv.length() != 3) {
            return false;
        }

        // Verificar se o CVV contém apenas dígitos
        if (!cvv.matches("\\d+")) {
            return false;
        }

        return true;
    }
}
