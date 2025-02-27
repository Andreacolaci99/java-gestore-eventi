package Milestone;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;
    
    private static final DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    private static final DateTimeFormatter oraFormattata = DateTimeFormatter.ofPattern("HH:mm");
    private static final DecimalFormat prezzoFormattato = new DecimalFormat("##,##0.00€");

    public Concerto(String titolo, LocalDate dataEvento, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, dataEvento, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataFormattata() {
        return super.getData().format(dataFormattata);
    }

    public String getOraFormattata() {
        return ora.format(oraFormattata);
    }

    public String getPrezzoFormattato() {
        return prezzoFormattato.format(prezzo);
    }

    @Override
    public String toString() {
        return getDataFormattata() + " alle " + getOraFormattata() + " - " + super.getTitolo() + " - " + getPrezzoFormattato();
    }
}