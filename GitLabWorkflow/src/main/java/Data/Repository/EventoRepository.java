package Data.Repository;

import Model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    List<Evento> eventos = new ArrayList<>();

    public void listarEventos(){
        System.out.println("Eventos\n");
        for (Evento evento:eventos) {
            System.out.println(evento.toString());
        }
    }

}
