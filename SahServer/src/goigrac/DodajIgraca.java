/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goigrac;

import domen.Igrac;
import domen.OpstiDomenskiObjekat;
import  generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import logika.KontrolerServer;

/**
 *
 * @author Milena Kutch
 */
public class DodajIgraca extends GenerickaOperacija {

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Igrac)) {
            throw new Exception("Neispravan parametar za igraca!");
        }
        LinkedList<Igrac> li = KontrolerServer.getInstance().ucitajIgrace();
        for (Igrac igrac : li) {
           Igrac IGO= (Igrac)odo;
            if ((IGO.getIme().equals(igrac.getIme())) && (IGO.getPrezime().equals(igrac.getPrezime()))) {
                throw new Exception("Igrac vec postoji u bazi!"); 
            }
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        dbb.sacuvaj((Igrac) odo);
    }
    
    
}
