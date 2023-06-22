package Model;

import java.time.LocalDate;

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
        return nome +
                " - Data:" + data +
                " - Localizacao:'" + localizacao + '\'' +
                " - Valor:" + valor;
    }

    public double getValor() {
        return valor;
    }
}
