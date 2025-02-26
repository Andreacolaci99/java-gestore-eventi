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
        scan.nextLine();

        System.out.println("L'evento è stato creato con successo : " + titolo + " in data : " + dataEvento.format(dataFormattata) + " con posti disponibili :" + postiTotali);

        Evento schiaccianoci = new Evento(titolo, dataEvento, postiTotali);

        System.out.println("Vuoi effettuare una prenotazione ? Digitare y per un solo posto, la + per più posti e la n per non effettuare nulla (y/+/n)");
        String prenotazione = scan.nextLine();

        if(prenotazione.equals("y")){
        try {
        schiaccianoci.prenota();
        System.out.println("Prenotazione effettuata con successo! Posti prenotati: " + schiaccianoci.getPostiPrenotati());
        } catch (Exception e) {
        System.out.println("Errore durante la prenotazione: " + e.getMessage());
          }
        }else if(prenotazione.equals("+")){
            System.out.println("Quanti posti vuoi prenotare ?");
            int postiDaPrenotare = scan.nextInt();
            try {
                schiaccianoci.prenotaPiuPosti(postiDaPrenotare);
                if(postiDaPrenotare>postiTotali){
                    throw new Exception("Siamo spiacenti, ma l'evento è sold out !! Non puoi effettuare la prenotazione");
                }
                System.out.println("Prenotazione effettuata con successo! Posti prenotati: " + schiaccianoci.getPostiPrenotati());
                } catch (Exception e) {
                System.out.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }
}
}
