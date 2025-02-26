package Milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreaEvento {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Inserisci il titolo dell'evento: \n");
        String titolo = scan.nextLine();

        LocalDate dataEvento = null;
        while (dataEvento == null) {
            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): ");
            String dataInput = scan.nextLine();
            try {
                dataEvento = LocalDate.parse(dataInput, dataFormattata);
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova.");
            }
        }
        System.out.print("Inserisci il numero totale di posti: ");
        int postiTotali = scan.nextInt();

        System.out.println("L'evento è stato creato con successo : " + titolo + " in data : " + dataEvento.format(dataFormattata) + " con posti disponibili :" + postiTotali);

        Evento schiaccianoci = new Evento(titolo, dataEvento, postiTotali);

        System.out.println("Vuoi effettuare una prenotazione ? (y/n)");
        String prenotazione = scan.nextLine();

        if(prenotazione == "y"){
            
        }
    }
}
