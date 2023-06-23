package Controller;

import Data.Repository.EventoRepository;
import Model.Evento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventoControllerTest {

    @Mock
    EventoRepository eventoRepository;
    @InjectMocks
    EventoController eventoController = new EventoController();

    @Test
    void buscarEventosExistentes(){
        Evento evento = new Evento("Conferência de Tecnologia", LocalDate.parse("2024-07-15"), "Centro de Convenções XYZ", 50.00);
        when(eventoRepository.eventoExiste(anyInt())).thenReturn(evento);
        Assertions.assertEquals(evento,eventoController.buscarEvento(anyInt()));
    }
    @Test
    void buscarEventosInexistentes(){
        when(eventoRepository.eventoExiste(anyInt())).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class,()->eventoController.buscarEvento(anyInt()));
    }

    @Test
    void listarEventos(){

    }



}