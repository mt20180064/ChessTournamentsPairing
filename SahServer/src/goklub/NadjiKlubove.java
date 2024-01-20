/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goklub;

import domen.Klub;
import domen.OpstiDomenskiObjekat;

import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class NadjiKlubove extends GenerickaOperacija{
    LinkedList<Klub> lista ;
String krit;
    public NadjiKlubove(String kriterijum) {
        krit= kriterijum;
        lista = new LinkedList<>();
    }

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Klub)){
            System.out.println("nisu odgovarjauci parametri za klub");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
          LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.pretrazi(odo, krit);
       
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Klub c = (Klub) opstiDomenskiObjekat;
            lista.add(c);
            
        }
    }

    public LinkedList<Klub> getLista() {
        return lista;
    }
}
