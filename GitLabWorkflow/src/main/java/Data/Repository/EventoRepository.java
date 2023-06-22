package Data.Repository;

import Model.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    List<Evento> eventos = new ArrayList<>();

    public EventoRepository(){
        iniciarRepository();
    }
    public void listarEventos(LocalDate dataHoje){
        for(int i = 0; i < eventos.size(); i++){
            if (eventos.get(i).getData().isAfter(dataHoje)) System.out.println((i +1) + "- " + eventos.get(i).toString());
            System.out.println();
        }
    }
    public Evento eventoExiste(int indice){
        if (indice>eventos.size()) throw new IllegalArgumentException("Evento não disponível");
        return eventos.get(indice-1);
    }

    private void iniciarRepository(){
        eventos.add(new Evento("Conferência de Tecnologia", LocalDate.parse("2024-07-15"), "Centro de Convenções XYZ", 50.00));
        eventos.add(new Evento("Show de Música ao Vivo", LocalDate.parse("2023-08-05"), "Teatro ABC", 30.00));
        eventos.add(new Evento("Exposição de Arte Moderna", LocalDate.parse("2023-09-10"), "Galeria de Arte 123", 20.00));
        eventos.add(new Evento("Seminário de Negócios", LocalDate.parse("2023-10-20"), "Hotel DEF", 100.00));
        eventos.add(new Evento("Festival Gastronômico", LocalDate.parse("2023-11-30"), "Praça do Mercado", 15.00));
    }



}
