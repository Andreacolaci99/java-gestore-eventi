package Milestone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    LocalTime orario;
    double prezzo;
    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");


    public Concerto(String titolo, LocalDate dataEvento, int postiTotali, LocalTime orario, double prezzo){
        super(titolo, dataEvento, postiTotali);
    }


    public LocalTime getOrario() {
        return orario;
    }


    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }


    public double getPrezzo() {
        return prezzo;
    }


    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
}
