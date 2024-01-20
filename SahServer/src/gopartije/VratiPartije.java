/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gopartije;

import domen.OpstiDomenskiObjekat;
import domen.Partija;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class VratiPartije extends GenerickaOperacija{
LinkedList<Partija> lista= new LinkedList<>();
    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
       if (!(odo instanceof Partija)){
           throw new Exception ("nisu dobri parametri za partiju");
       }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati((Partija)odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Partija k = (Partija) opstiDomenskiObjekat;
            lista.add(k);
            
    }
    
}

    public LinkedList<Partija> getLista() {
        return lista;
    }
}
