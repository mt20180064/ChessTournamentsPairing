/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import domen.Igrac;
import domen.Sudija;
import domen.Turnir;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class Sesija {
    private static Sesija instance;
    private Sudija ulogovani;
    LinkedList<Igrac> igraciLista;
    private Turnir turnir;

    public static Sesija getInstance() {
        if (instance==null){
            instance = new Sesija();
        }
        return instance;
    }  
    

    public LinkedList<Igrac> getIgraciLista() {
        return igraciLista;
    }

    public void setIgraciLista(LinkedList<Igrac> igraciLista) {
        this.igraciLista = igraciLista;
    }
    
    

    public Sesija() {
    }

    public Sudija getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Sudija ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }
    
    
}
