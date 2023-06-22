package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    private LocalDate data;
    private Evento ingresso;
    private int quantidade;
    private Cliente cliente;
    private Pagamento pagamento;
    private double valorTotal;

    public Venda(Evento ingresso, int quantidade, Cliente cliente, Pagamento pagamento, double valorTotal) {
        this.data = LocalDate.now();
        this.ingresso = ingresso;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
    }
    public Venda(){
        this.data = LocalDate.now();
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void setIngresso(Evento ingresso) {
        this.ingresso = ingresso;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String mostrarVenda(){
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\nCliente: "+cliente.getNome()+"\nData da compra: "+data.format(formatarData)
                +ingresso.toString()+ "\nQuantidade: "+quantidade+"\nValor total da compra: "+valorTotal;
    }
}

