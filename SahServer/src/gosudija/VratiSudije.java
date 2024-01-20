/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gosudija;

import domen.OpstiDomenskiObjekat;
import domen.Sudija;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  generickaoperacija.GenerickaOperacija;

/**
 *
 * @author Milena Kutch
 */
public class VratiSudije extends GenerickaOperacija{
private LinkedList<Sudija> lista;

    public VratiSudije() {
        lista = new LinkedList<>();
    }

    @Override
    protected void validacija(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Sudija)){
            throw new Exception("nisu odgovarajuci parametri za sudiju");
        }
    }

    @Override
    protected void izvrsi(OpstiDomenskiObjekat odo) {
    try {
        LinkedList<OpstiDomenskiObjekat> listaOpstih = dbb.vrati((Sudija)odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOpstih) {
            Sudija s = (Sudija) opstiDomenskiObjekat;
            lista.add(s);
              
        }
    } catch (Exception ex) {
        Logger.getLogger(VratiSudije.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public LinkedList<Sudija> getLista() {
        return lista;
    }
    
}
