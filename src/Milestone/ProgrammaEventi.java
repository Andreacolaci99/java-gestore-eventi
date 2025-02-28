package Milestone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {
    
    private String titolo;

    List<Evento> listaEventi;

    LocalDate dataEvento;
    
    public ProgrammaEventi(String titolo){
        this.titolo = titolo;
        this.listaEventi = new ArrayList<>();
    }
 
    public void addEvento(Evento evento){
         listaEventi.add(evento);
    }

    public List<Evento> returnEventoDate(LocalDate data) {
        List<Evento> eventiFiltrati = new ArrayList<>();
        for (Evento evento : listaEventi) {
            if (evento.getData().equals(data)) {
                eventiFiltrati.add(evento);
            }
        }
        return eventiFiltrati;
    }

    public int numeroEventiPresenti(){
        int eventiPresenti = listaEventi.size();
        return eventiPresenti;
    }

    public void svuotaLista(){
        listaEventi.clear();
    }

   
}
