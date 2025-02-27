package Milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    
    private String titolo;

    LocalDate dataEvento;

    private int postiTotali;

    private int postiPrenotati;

    private int postiDisdetti;

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

    public int getPostiDisdetti() {
        return postiDisdetti;
    }

    public int prenota()throws Exception{
        if(LocalDate.now().isAfter(dataEvento)){
            throw new Exception ("L'evento è già passato, non puoi procedere con la prenotazione");
        }else if(postiPrenotati>=postiTotali){
            throw new Exception("Siamo spiacenti, ma l'evento è sold out !! Non puoi effettuare la prenotazione");
        }else{
           postiPrenotati++;
        }
        return postiPrenotati;
    }
    public int prenotaPiuPosti(int postiDaPrenotare) throws Exception {
        if (LocalDate.now().isAfter(dataEvento)) {
            throw new Exception("L'evento è già passato, non puoi procedere con la prenotazione.");
        } 
        if (postiDaPrenotare <= 0) {
            throw new Exception("Devi prenotare almeno un posto.");
        }
        if (postiPrenotati + postiDaPrenotare > postiTotali) {
            throw new Exception("Non ci sono abbastanza posti disponibili.");
        }
        postiPrenotati += postiDaPrenotare;
        return postiPrenotati;
    }

    public int disdici()throws Exception{
      if(LocalDate.now().isAfter(dataEvento)){
      throw new Exception ("L'evento è già passato, non puoi procedere con la disdetta");
    }else if(postiPrenotati<=0){
        throw new Exception("Non ci sono prenotazioni!! Pertanto non potremo procedere con la disdetta");
    }else{
         postiDisdetti = postiPrenotati--;
    }
    return postiDisdetti;
    }

    public int disdiciPiuPosti(int postiDaDisdire) throws Exception {
        if (LocalDate.now().isAfter(dataEvento)) {
            throw new Exception("L'evento è già passato, non puoi procedere con la disdetta.");
        } 
        if (postiDaDisdire <= 0) {
            throw new Exception("Devi disdire almeno un posto.");
        }
        if (postiDaDisdire > postiPrenotati) {
            throw new Exception("Non puoi disdire più posti di quelli prenotati.");
        }
        postiPrenotati -= postiDaDisdire;
        return postiPrenotati;
    }


    @Override
    public String toString() {
        return dataEvento.format(dataFormattata) + " - " + titolo;
    }
}
