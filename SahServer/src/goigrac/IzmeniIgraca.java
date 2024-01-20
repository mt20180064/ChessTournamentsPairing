/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goigrac;

import domen.Igrac;
import domen.OpstiDomenskiObjekat;
import generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class IzmeniIgraca extends GenerickaOperacija {

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
         if(!(odo instanceof Igrac)) {
            throw new Exception("Neispravan parametar za igrača!");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        dbb.izmeni((Igrac)odo);
    }
    
}
