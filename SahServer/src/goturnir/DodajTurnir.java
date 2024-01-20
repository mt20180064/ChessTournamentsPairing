/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goturnir;

import domen.OpstiDomenskiObjekat;
import domen.Turnir;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;
import logika.KontrolerServer;

/**
 *
 * @author Milena Kutch
 */
public class DodajTurnir extends GenerickaOperacija{
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Turnir)) {
            throw new Exception("Neispravan parametar za igraca!");
        }
        LinkedList<Turnir> li = KontrolerServer.getInstance().ucitajTurnire();
        for (Turnir turnir : li) {
           Turnir IGO= (Turnir)odo;
            if ((IGO.getNaziv().equals(turnir.getNaziv()))) {
                throw new Exception("Turnir vec postoji u bazi!"); 
            }
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        dbb.sacuvaj((Turnir) odo);
    }
    
    
}
