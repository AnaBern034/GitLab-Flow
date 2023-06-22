package Data.Repository;

import Model.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    List<Evento> eventos = new ArrayList<>();

    public EventoRepository(){
        eventos.add(new Evento("Show do Luan Santana", LocalDate.parse("2023-06-20"), "Rua das Flores", 50));
    }
    public void listarEventos(){
        System.out.println("Eventos\n");
        for(int i = 0; i < eventos.size(); i++){
            System.out.println((i +1) + " - " + eventos.get(i).toString());
        }
    }

    public Evento retornarEvento(int escolha) {
        return eventos.get(escolha-1);
    }

}
