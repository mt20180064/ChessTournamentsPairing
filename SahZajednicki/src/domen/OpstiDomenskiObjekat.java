/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    
    String vratiNazivTabele();
    String vratiNaziveAtributa();
    String vratiVrednostiAtributa();    
    String vratiJoinUpit();        
    String vratiID();
    public String vratiPraviloSortiranja();
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs);
    public OpstiDomenskiObjekat vratiJedanObjekat(ResultSet rs);
    public String vratiZaApdejt();

    
}
//  String vratiSetZaIzmenu();