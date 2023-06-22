package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String nome;
    private LocalDate data;
    private String localizacao;
    private double valor;

    public Evento(String nome, LocalDate data, String localizacao, double valor) {
        this.nome = nome;
        this.data = data;
        this.localizacao = localizacao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\nNome do Evento: "+nome+
                "\nData: "+ data.format(formatarData)+
                "\nLocalização: "+localizacao+
                "\nValor Do Ingresso: "+valor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
