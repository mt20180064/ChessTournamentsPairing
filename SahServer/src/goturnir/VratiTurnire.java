/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goturnir;

import domen.OpstiDomenskiObjekat;
import domen.Turnir;
import java.util.LinkedList;
import  generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class VratiTurnire extends GenerickaOperacija {
LinkedList<Turnir> lista = new LinkedList<>();
    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Turnir)){
           throw new Exception ("nisu dobri parametri za turnir");
       }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
          LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati((Turnir)odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Turnir k = (Turnir) opstiDomenskiObjekat;
            lista.add(k);
           
    }
    }

    public LinkedList<Turnir> getLista() {
        return lista;
    }

   
    
}
