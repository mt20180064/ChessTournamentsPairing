/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import konstante.Operacije;
import domen.Igrac;
import domen.Klub;
import domen.Partija;
import domen.Prijava;
import domen.Sudija;
import domen.Turnir;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.KontrolerKlijent;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milena Kutch
 */
public class OSZ extends Thread{
    boolean aktivan= true;

    @Override
    public void run() {
        while(aktivan){
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            switch(so.getOperacija()){
                case Operacije.ULOGUJ:
                
                    if (so.isUspesno()){
                        KontrolerKlijent.getInstance().ulogujSudiju((Sudija) so.getOdgovor());
                        System.out.println("dobili smo odgovor");
                    } else{
                        KontrolerKlijent.getInstance().greskaPriLogovanju(so.getGreska());
                        System.out.println("stigla greska");
                    }
                    break;
               
                case Operacije.UCITAJ_KLUBOVE:
                    if (so.isUspesno()) {
                        LinkedList<Klub> klubovi = (LinkedList<Klub>) so.getOdgovor();
                        KontrolerKlijent.getInstance().ucitajKlubove(klubovi);
                        KontrolerKlijent.getInstance().getFrmsudijina().setKlu(klubovi);
                    }else{
                        KontrolerKlijent.getInstance().greskaKodKlubova(so.getGreska());
                    }
                    break;
                case Operacije.UCITAJ_IGRACE:
                {
                    if (so.isUspesno()){
                        LinkedList<Igrac> igraci = (LinkedList<Igrac>) so.getOdgovor();
                        KontrolerKlijent.getInstance().ucitajIgrace(igraci);
                        // KontrolerKlijent.getInstance().staviPlasman(igraci);
                    } else {
                        KontrolerKlijent.getInstance().greskaKodIgraca(so.getGreska());
                    }
                }
                    break;
                case Operacije.UCITAJ_TURNIRE:
                {
                    if (so.isUspesno()){
                        LinkedList<Turnir> turniri = (LinkedList<Turnir>) so.getOdgovor();
                        KontrolerKlijent.getInstance().ucitajTurnire(turniri);
                    } else {
                        KontrolerKlijent.getInstance().greskaKodTurnira(so.getGreska());
                    }}
                    break;
                case Operacije.KREIRAJ_IGRACA:{
                    if (so.isUspesno()){
                        KontrolerKlijent.getInstance().dodajIgraca("igrac je uspesno dodat!");
                    } else{
                        KontrolerKlijent.getInstance().dodavanjeIgracaGreska(so.getGreska());
                    }}
                    break;
                case Operacije.IZLOGUJ_SE:
                    KontrolerKlijent.getInstance().izlogujSudiju(so.isUspesno());
                    aktivan=false;
                    break;
                case Operacije.UCITAJ_IGRACE2:{
                    if (so.isUspesno()){
                        LinkedList<Igrac> igraci2 = (LinkedList<Igrac>) so.getOdgovor();
                        
                        KontrolerKlijent.getInstance().srediPanel(igraci2);
                        KontrolerKlijent.getInstance().getFrmglavna().setIGRACI(igraci2);
                        KontrolerKlijent.getInstance().ucitajIgrace2(igraci2);
                    } else {
                        KontrolerKlijent.getInstance().greskaKodIgraca(so.getGreska());
                    }}
                    break;
                case Operacije.SACUVAJ_KOLO:{
                    if (so.isUspesno()){
                        KontrolerKlijent.getInstance().sacuvajKolo("Kolo je uspesno sacuvano.");
                    } else{
                        KontrolerKlijent.getInstance().cuvanjeKolaGreska(so.getGreska());
                        
                    }}
                    break;
                case Operacije.UCITAJ_PARTIJE:{
                    if (so.isUspesno()){
                        LinkedList<Partija> partije = (LinkedList<Partija>) so.getOdgovor();
                        KontrolerKlijent.getInstance().ucitajPartije(partije);
                    } else {
                        KontrolerKlijent.getInstance().greskaKodPartija(so.getGreska());
                    }}
                    break;
                    //case Operacije.IZMENI_IGRACA:
                    
                    //    break;
                case Operacije.PRONADJI_TURNIR:{
                    if (so.isUspesno()) {
                        LinkedList<Turnir> tu = (LinkedList<Turnir>) so.getOdgovor();
                        KontrolerKlijent.getInstance().osveziTabeluTurnira(tu);
                        
                    } else KontrolerKlijent.getInstance().greskaKodTurnira("Greska");}
                    break;
                case Operacije.PRONADJI_KLUB:{
                    if(so.isUspesno()){
                        LinkedList<Klub> kl = (LinkedList<Klub>) so.getOdgovor();
                        KontrolerKlijent.getInstance().osveziTabeluKlubova(kl);
                    } else System.out.println("greskica kod klubova");}
                    break;
                case Operacije.OBRISI_TURNIR:{
                    String status;
                    if (so.isUspesno()) {
                        status = "Turnir je uspešno obrisan!";
                    }else{
                        status = so.getGreska();
                    }
                    KontrolerKlijent.getInstance().igracObrisan(status);}
                    break;
                case Operacije.UCITAJ_REZULTATE:{
                    if (so.isUspesno()){
                        LinkedList<Igrac> rez = (LinkedList<Igrac>) so.getOdgovor();
                        // KontrolerKlijent.getInstance().ucitajIgrace(igraci);
                 //       KontrolerKlijent.getInstance().staviPlasman(rez);
                    } else {
                        KontrolerKlijent.getInstance().greskaKodIgraca(so.getGreska());
                    }}
                    break;
                case Operacije.ZATRAZI_KLUBOVE:{
                    if (so.isUspesno()) {
                        LinkedList<Klub> kluli = (LinkedList<Klub>) so.getOdgovor();
                        KontrolerKlijent.getInstance().zatraziKlubove(kluli);
                        
                    }else{
                        KontrolerKlijent.getInstance().greskaKodKlubova(so.getGreska());
                    }}
                    break;
                case Operacije.UZMI_KLUBOVE:{
                    if (so.isUspesno()) {
                        LinkedList<Klub> klulil = (LinkedList<Klub>) so.getOdgovor();
                        KontrolerKlijent.getInstance().uzmiKlubove(klulil);
                        
                    }else{
                        KontrolerKlijent.getInstance().greskaKodKlubova(so.getGreska());
                    }}
                    break;
                case Operacije.PRONADJI_IGRACE:{
                    if (so.isUspesno()) {
                        LinkedList<Igrac> tu = (LinkedList<Igrac>) so.getOdgovor();
                        KontrolerKlijent.getInstance().osveziTabeluIgraca(tu);
                    } else System.out.println("hreska u oszzzzz");}
                    break;
                    
                case Operacije.ZAPAMTI_PODATKE_O_TURNIRU:{
                    String status1;
                    if (so.isUspesno()) {
                        status1 = "Podaci o turniru su izmenjeni";
                    }else{
                        status1 = so.getGreska();
                    }
                    KontrolerKlijent.getInstance().izmeniTurnir(status1);}
                    break;
                    case Operacije.UCITAJ_PRIJAVE:{
                    if (so.isUspesno()) {
                        LinkedList<Prijava> tuu = (LinkedList<Prijava>) so.getOdgovor();
                        System.out.println("prijave:"+tuu);
                        System.out.println("prijaveBROJ:"+tuu.size());
                        KontrolerKlijent.getInstance().stiglePrijave(tuu);
                        
                        
                    } else KontrolerKlijent.getInstance().greskaKodTurnira("Greska");}
                    break;
                    case Operacije.DODAJ_TURNIR:{
                    if (so.isUspesno()){
                        KontrolerKlijent.getInstance().dodajTurnir("TURNIR je uspesno dodat!");
                    } else{
                        KontrolerKlijent.getInstance().dodavanjeIgracaGreska(so.getGreska());
                    }}
                    break;
                    
                    
            }
        }
    }

    void prekiniObradu() {
    aktivan = false;
    }
    
    
}
