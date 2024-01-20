/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goprijava;

import domen.OpstiDomenskiObjekat;
import domen.Prijava;
import generickaoperacija.GenerickaOperacija;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class VratiPrijave extends GenerickaOperacija{
 LinkedList<Prijava> lista ;
String krit;
    public VratiPrijave(String kriterijum) {
        krit= kriterijum;
        lista = new LinkedList<>();
    }

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Prijava)){
            System.out.println("nisu odgovarjauci parametri za prijavu");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
          LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.pretrazi(odo, krit);
       
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Prijava c = (Prijava) opstiDomenskiObjekat;
            lista.add(c);
            
        }
    }

    public LinkedList<Prijava> getLista() {
        return lista;
    }
}
