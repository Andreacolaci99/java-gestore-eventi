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

        Evento schiaccianoci = new Evento(titolo, dataEvento, postiTotali);

        System.out.println("Vuoi effettuare una prenotazione o una disdetta ? Digitare la lettera p per prenotazione o la lettera d per disdetta (p/d)");
        String sceltaUtente = scan.nextLine();

        if(sceltaUtente.equalsIgnoreCase("p")){
        System.out.println("Vuoi effettuare una prenotazione ? Digitare y per un solo posto, la + per più posti.(y/+)");
        String prenotazione = scan.nextLine();

        if(prenotazione.equalsIgnoreCase("y")){
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
    System.out.println("I posti rimanenti sono : " + (postiTotali - schiaccianoci.getPostiPrenotati()));
    }else if(sceltaUtente.equalsIgnoreCase("d")){
    System.out.println("Non puoi più venire ? Effettua comodamente una o più disdette digitando la lettera y per un solo posto o il simbolo - per disdirne più di uno. (y/-)");
    scan.nextLine();
    String disdetta = scan.nextLine();

    if(disdetta.equalsIgnoreCase("y")){
        try {
        schiaccianoci.disdici();
        System.out.println("Disdetta effettuata con successo! Posti liberi: " + schiaccianoci.getPostiPrenotati());
        } catch (Exception e) {
            System.out.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }else if(disdetta.equals("-")){
        System.out.println("Quanti posti vuoi disdire ?");
        int postiDaDisdire = scan.nextInt();
        scan.nextLine();     
        try {
        schiaccianoci.disdiciPiuPosti(postiDaDisdire);
        if(postiDaDisdire>schiaccianoci.getPostiPrenotati()){
        throw new Exception("Siamo spiacenti, ma il numero di posti che si vuole disdire supera il numero di posti prenotati, la invitiamo ad inserire un numero corretto");
        }   
        System.out.println("Disdetta effettuata con successo !! I posti rimanenti ora sono : " + schiaccianoci.getPostiPrenotati()); 
        } catch (Exception e) {
            System.out.println("Errore durante la prenotazione: " + e.getMessage());
        }
     }
    }
   }
  }