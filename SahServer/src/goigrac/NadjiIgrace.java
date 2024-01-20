/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goigrac;

import domen.Igrac;
import domen.OpstiDomenskiObjekat;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class NadjiIgrace extends GenerickaOperacija {
        LinkedList<Igrac> lista ;
String krit;
    public NadjiIgrace(String kriterijum) {
        krit= kriterijum;
        lista = new LinkedList<>();
    }

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Igrac)){
            System.out.println("nisu odgovarjauci parametri za igraca");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
          LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.pretrazi(odo, krit);
       
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Igrac c = (Igrac) opstiDomenskiObjekat;
            lista.add(c);
            
        }
    }

    public LinkedList<Igrac> getLista() {
        return lista;
    }
}
