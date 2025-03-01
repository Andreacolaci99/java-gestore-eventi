package Milestone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    
    private String titolo;
    private List<Evento> listaEventi; 

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.listaEventi = new ArrayList<>();
    }

    public void addEvento(Evento evento) {
        listaEventi.add(evento);
    }

    public List<Evento> getEventiPerData(LocalDate data) { 
        List<Evento> eventiFiltrati = new ArrayList<>();
        for (Evento evento : listaEventi) {
            if (evento.getData().equals(data)) {
                eventiFiltrati.add(evento);
            }
        }
        return eventiFiltrati;
    }

    public int numeroEventiPresenti() {
        return listaEventi.size();
    }

    public void svuotaLista() {
        listaEventi.clear();
    }

    public String dataTitolo() {
        listaEventi.sort(Comparator.comparing(Evento::getData));

        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        for (Evento evento : listaEventi) {
            sb.append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }
        return sb.toString();
    }
}
