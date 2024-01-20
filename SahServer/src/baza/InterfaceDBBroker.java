/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public interface InterfaceDBBroker {
    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception;
    public void izmeni (OpstiDomenskiObjekat odo) throws Exception;
    public void obrisi(OpstiDomenskiObjekat odo) throws Exception;
    public LinkedList<OpstiDomenskiObjekat> vrati(OpstiDomenskiObjekat odo)throws Exception;
    public LinkedList<OpstiDomenskiObjekat> pretrazi(OpstiDomenskiObjekat odo, String kriterijum)throws Exception;
}
