package Milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    
    private String titolo;

    LocalDate dataEvento;

    LocalDate dataAttuale = LocalDate.now();

    private int postiTotali;

    private int postiPrenotati;

    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");

    public Evento(String titolo, LocalDate dataEvento, int postiTotali){
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.postiTotali = postiTotali;
    }
    public LocalDate getData() {
        return dataEvento;
    }
    public void setData(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public int prenota()throws Exception{
        if(dataAttuale.isAfter(dataEvento)){
            throw new Exception ("L'evento è già passato, non puoi procedere con la prenotazione");
        }else if(postiPrenotati>=postiTotali){
            throw new Exception("Siamo spiacenti, ma l'evento è sold out !! Non puoi effettuare la prenotazione");
        }else{
            postiPrenotati++;
        }
        return postiPrenotati;
    }
    public int prenotaPiuPosti(int postiDaPrenotare){
        postiPrenotati += postiDaPrenotare;
        return postiPrenotati;
    }

    public int disdici()throws Exception{
      if(dataAttuale.isAfter(dataEvento)){
      throw new Exception ("L'evento è già passato, non puoi procedere con la disdetta");
    }else if(postiPrenotati<=0){
        throw new Exception("Non ci sono prenotazioni!! Pertanto non potremo procedere con la disdetta");
    }else{
        postiPrenotati--;
    }
    return postiPrenotati;
    }

    public int disdiciPiuPosti(int postiDaDisdire){
        postiPrenotati -= postiDaDisdire;
        return postiPrenotati;
    }

    @Override
    public String toString() {
        return dataEvento.format(dataFormattata) + " - " + titolo;
    }
}
