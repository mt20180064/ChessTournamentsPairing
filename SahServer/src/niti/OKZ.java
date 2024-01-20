/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import konstante.Operacije;
import domen.Igrac;
import domen.Klub;
import domen.Kolo;
import domen.Partija;
import domen.Prijava;
import domen.Sudija;
import domen.Turnir;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
//import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.KontrolerServer;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milena Kutch
 */
public class OKZ extends Thread{
    Socket s;
    boolean aktivan;

    public OKZ(Socket klijent) {
        s = klijent;
        aktivan = true;
    }

    @Override
    public void run() {
       while (aktivan){
           KlijentskiZahtev kz = primiZahtev();
           ServerskiOdgovor so = new ServerskiOdgovor();
           so.setOperacija(kz.getOperacija());
           switch(kz.getOperacija()){
               case Operacije.ULOGUJ:
               Sudija sud = (Sudija) kz.getParametar();
               
                   Sudija ulogovan= KontrolerServer.getInstance().ulogujSudiju(sud);
                   System.out.println("poslato u kontroler.");
                   System.out.println("poslati sudija:"+ulogovan);
                   
                   if (ulogovan!=null){
                   so.setOdgovor(ulogovan);
                       
                   so.setUspesno(true);
                   } else{
                       so.setGreska(so.getGreska());
                       so.setUspesno(false);
                   }
                   break;
               case Operacije.IZLOGUJ_SE:
                   Sudija aktivni = (Sudija) kz.getParametar();
                   System.out.println("za odjavljivanje:"+aktivni);
                   KontrolerServer.getInstance().odjaviSe(aktivni);
                   so.setUspesno(true);
                   break;
               case Operacije.UCITAJ_KLUBOVE:
                   LinkedList<Klub> klubovi;
               try {
                   klubovi = KontrolerServer.getInstance().ucitajKlubove();
                   so.setOdgovor(klubovi);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
               case Operacije.UCITAJ_IGRACE:
                   LinkedList<Igrac> igraci;
               try {
                   igraci = KontrolerServer.getInstance().ucitajIgrace();
                   so.setOdgovor(igraci);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
                   
                   
               case Operacije.UCITAJ_TURNIRE:
                   LinkedList<Turnir> turniri;
               try {
                   turniri = KontrolerServer.getInstance().ucitajTurnire();
                   so.setOdgovor(turniri);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
               case Operacije.KREIRAJ_IGRACA:
                   Igrac igrac = (Igrac) kz.getParametar();
               {
                   try {
                       KontrolerServer.getInstance().dodajIgraca(igrac);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break;
               case Operacije.SACUVAJ_KOLO:
                   Kolo kolo = (Kolo) kz.getParametar();
               {
                   try {
                       KontrolerServer.getInstance().sacuvajKolo(kolo);
                       so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break;
               case Operacije.UCITAJ_PARTIJE:
                      LinkedList<Partija> partijeizbaze;
                     
               try {
                   partijeizbaze = KontrolerServer.getInstance().ucitajPartije();
                   so.setOdgovor(partijeizbaze);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
           
             
               case Operacije.IZMENI_IGRACA:
                    LinkedList<Igrac> igraciL1  = (LinkedList<Igrac>) kz.getParametar();
                    try {
                        KontrolerServer.getInstance().izmeniigrace1(igraciL1);
                       so.setUspesno(true);
                    } catch (SQLException ex) {
                        so.setUspesno(false);
                        Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   break;
               case Operacije.PRONADJI_TURNIR:
                   String kriterijum = (String) kz.getParametar();
               {
                   try {
                       LinkedList<Turnir> litu = KontrolerServer.getInstance().pronadjiTurnire(kriterijum);
                       so.setOdgovor(litu);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break; 
                     case Operacije.PRONADJI_KLUB:
                   String kriter = (String) kz.getParametar();
               {
                   try {
                       LinkedList<Klub> likl = KontrolerServer.getInstance().pronadjiKlubove(kriter);
                       so.setOdgovor(likl);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break; 
                     case Operacije.OBRISI_TURNIR:
                          Turnir p = (Turnir) kz.getParametar();
                    try {
                        KontrolerServer.getInstance().obrisiTurnir(p);
                        so.setUspesno(true);
                    } catch (Exception ex) {
                      
                        so.setUspesno(false);
                    }
                         break;
                     case Operacije.UCITAJ_REZULTATE:
                            LinkedList<Igrac> rez;
               try {
                   rez = KontrolerServer.getInstance().ucitajRezultate();
                   so.setOdgovor(rez);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                         break;
          case Operacije.ZATRAZI_KLUBOVE:
                   LinkedList<Klub> kluli;
               try {
                   kluli = KontrolerServer.getInstance().zatraziKlubove();
                   so.setOdgovor(kluli);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
                     case Operacije.UZMI_KLUBOVE:
                   LinkedList<Klub> klulil;
               try {
                   klulil = KontrolerServer.getInstance().zatraziKlubove();
                   so.setOdgovor(klulil);
                   so.setUspesno(true);
               } catch (SQLException ex) {
                   so.setUspesno(false);
                   Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
               }
                   break;
                        case Operacije.PRONADJI_IGRACE:
                   String kriteri = (String) kz.getParametar();
               
                   try {
                       LinkedList<Igrac> igs = KontrolerServer.getInstance().pronadjiIgrace(kriteri);
                       so.setOdgovor(igs);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
                   break; 
                   case Operacije.ZAPAMTI_PODATKE_O_TURNIRU:
                    Turnir  t = (Turnir) kz.getParametar();
                    {
                    try {
                        KontrolerServer.getInstance().izmeniTurnir(t);
                       so.setUspesno(true);
                    } catch (SQLException ex) {
                        so.setUspesno(false);
                        Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                   break;
                   case Operacije.UCITAJ_PRIJAVE:
                         String tu = (String) kz.getParametar();
                         {
                   try {
                       LinkedList<Prijava> prijave = KontrolerServer.getInstance().ucitajPrijave(tu);
                       so.setOdgovor(prijave);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
                         }
                       break;
                       case Operacije.DODAJ_TURNIR:
                   Turnir tf = (Turnir) kz.getParametar();
               {
                   try {
                       KontrolerServer.getInstance().dodajTurnir(tf);
                        so.setUspesno(true);
                   } catch (SQLException ex) {
                       so.setUspesno(false);
                       Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break;
           }
           posaljiOdgovor(so);
       }
    }


    
     
      public void posaljiOdgovor(ServerskiOdgovor so){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            System.out.println("greska u slanju zahteva");
            Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public KlijentskiZahtev primiZahtev(){
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return  (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(OKZ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

