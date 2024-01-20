/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  goigrac;


import domen.Igrac;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class VratiIgrace extends GenerickaOperacija {
private LinkedList<Igrac> lista = new LinkedList<>();
    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
       if (!(odo instanceof Igrac)){
           throw new Exception ("nisu dobri parametri za igraca");
       }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati((Igrac)odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Igrac k = (Igrac) opstiDomenskiObjekat;
            lista.add(k);
           
    }
    
}

    public LinkedList<Igrac> getLista() {
        return lista;
    }
}