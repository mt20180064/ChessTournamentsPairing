/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goklub;

import domen.Klub;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import  generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class VratiKlubove extends GenerickaOperacija {
LinkedList<Klub> lista;

    public VratiKlubove() {
     lista = new LinkedList<>();
    }


    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
       if (!(odo instanceof Klub)){
           throw new Exception("nije odgovarajuci objekat za klub");
       }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
       LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati((Klub)odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Klub k = (Klub) opstiDomenskiObjekat;
            lista.add(k);
            
            
        }
    }

    public LinkedList<Klub> getLista() {
        return lista;
    }
    
}
