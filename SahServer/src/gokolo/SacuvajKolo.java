/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gokolo;

import domen.Kolo;
import domen.OpstiDomenskiObjekat;
import domen.Partija;
import generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class SacuvajKolo extends GenerickaOperacija{

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Kolo)){
            System.out.println("nisu odgovarajuci parametri za kolo");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        Kolo k = (Kolo) odo;
        dbb.sacuvaj(k);
        for (Partija p : k.getPartije()) {
            dbb.sacuvaj(p);
        }
    }
    
}
