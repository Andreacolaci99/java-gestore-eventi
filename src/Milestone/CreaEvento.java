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
            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): \n");
            String dataInput = scan.nextLine();
            try {
                dataEvento = LocalDate.parse(dataInput, dataFormattata);
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova.");
            }
        }
        System.out.print("Inserisci il numero totale di posti: \n");
        int postiTotali = scan.nextInt();
        scan.nextLine();

        System.out.println("L'evento è stato creato con successo : " + titolo + " in data : " + dataEvento.format(dataFormattata) + " con posti disponibili :" + postiTotali);

        Evento nuovoEvento = new Evento(titolo, dataEvento, postiTotali);

        System.out.println("Vuoi effettuare una prenotazione ? Digitare y per un solo posto, la + per più posti.(y/+)");
        String prenotazione = scan.nextLine();

        if(prenotazione.equalsIgnoreCase("y")){
        try {
        nuovoEvento.prenota();
        System.out.println("Prenotazione effettuata con successo! Posti prenotati: " + nuovoEvento.getPostiPrenotati());
        } catch (Exception e) {
        System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
        }else if(prenotazione.equals("+")){
            System.out.println("Quanti posti vuoi prenotare ?");
            int postiDaPrenotare = scan.nextInt();
            scan.nextLine();
            try {
                nuovoEvento.prenotaPiuPosti(postiDaPrenotare);
                System.out.println("Prenotazione effettuata con successo! Posti prenotati: " + nuovoEvento.getPostiPrenotati());
                } catch (Exception e) {
                System.err.println("Errore durante la prenotazione: " + e.getMessage());
                return;
           }
          }
        int postiPrenotati = nuovoEvento.getPostiPrenotati();
        int postiLiberiDopoPrenotazione = postiTotali - postiPrenotati;
        System.out.println("I posti rimanenti sono : " + postiLiberiDopoPrenotazione);
        System.out.println("Non puoi più venire ? Effettua comodamente una o più disdette digitando la lettera y per un solo posto o il simbolo - per disdirne più di uno. (y/-)");
        String disdetta = scan.nextLine();

    if(disdetta.equalsIgnoreCase("y")){
        try {
        nuovoEvento.disdici();
        System.out.println("Disdetta effettuata con successo! Posti liberi: " + (postiLiberiDopoPrenotazione + 1));
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }else if(disdetta.equals("-")){
        System.out.println("Quanti posti vuoi disdire ?");
        int postiDaDisdire = scan.nextInt();
        scan.nextLine();  
        int postiDopoDisdetta = postiLiberiDopoPrenotazione + postiDaDisdire;   
        try {
        nuovoEvento.disdiciPiuPosti(postiDaDisdire); 
        System.out.println("Disdetta effettuata con successo !! I posti rimanenti ora sono : " + postiDopoDisdetta); 
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
     }
    }
   }