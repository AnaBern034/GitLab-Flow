package Controller;

import Data.Repository.EventoRepository;
import Model.Evento;

import java.time.LocalDate;

public class EventoController {
    private EventoRepository eventoRepository =new EventoRepository();

    public Evento buscarEvento(int indice){
        return eventoRepository.eventoExiste(indice);
    }
    public void exibirEventosDisponiveis(){
        LocalDate dataHoje = LocalDate.now();
        eventoRepository.listarEventos(dataHoje);
    }
}
