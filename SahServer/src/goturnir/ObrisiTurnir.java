/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goturnir;

import domen.Kolo;
import domen.OpstiDomenskiObjekat;
import domen.Partija;
import domen.Turnir;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class ObrisiTurnir extends GenerickaOperacija{

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
         if (!(odo instanceof Turnir)){
            System.out.println("nisu odgovarjauci parametri za turnir");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
         LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati(odo);
        Turnir t = (Turnir) odo;
        if(!listaOpstih.contains(t)){
            throw new Exception("Turnir ne postoji u bazi ili je u međuvremenu obrisan!");
        }
       // LinkedList<Kolo> kola = t.getKola();
        //for (Kolo kolo : kola) {
         //   LinkedList<Partija> partijeKolo = kolo.getPartije();
           // for (Partija partija : partijeKolo) {
            //    dbb.obrisi((Partija)odo);
           // }
          //  dbb.obrisi((Kolo)odo);
        //}
        dbb.obrisi((Turnir) odo);
    }
    
}
