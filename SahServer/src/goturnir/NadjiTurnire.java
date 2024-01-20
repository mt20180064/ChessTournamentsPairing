/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goturnir;

import domen.OpstiDomenskiObjekat;
import domen.Turnir;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class NadjiTurnire extends GenerickaOperacija {
LinkedList<Turnir> lista ;
String krit;
    public NadjiTurnire(String kriterijum) {
        krit= kriterijum;
        lista = new LinkedList<>();
    }

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Turnir)){
            System.out.println("nisu odgovarjauci parametri za turnir");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
          LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.pretrazi(odo, krit);
        System.out.println("listaturnira: " + listaOpstih);
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Turnir c = (Turnir) opstiDomenskiObjekat;
            lista.add(c);
            
        } 
    }

    public LinkedList<Turnir> getLista() {
        return lista;
    }
    
}
