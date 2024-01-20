/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goturnir;

import domen.OpstiDomenskiObjekat;
import domen.Turnir;
import generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class IzmeniTurnir extends GenerickaOperacija{

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
         if (!(odo instanceof Turnir)){
            System.out.println("nisu odgovarjauci parametri za turnir");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
       dbb.izmeni((Turnir)odo);
    }
    
}
