/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Milena Kutch
 */
public class Kolo implements OpstiDomenskiObjekat{
    private int id;
    private int redni;
    private int turnir;
    private LinkedList<Partija> partije;

    public Kolo() {
    }

    public Kolo(int id, int turnir, int redni, LinkedList<Partija> partije) {
        this.id = id;
        this.turnir = turnir;
        this.redni=redni;
        this.partije = partije;
    } 

  
    

    

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    

    @Override
    public String vratiNazivTabele() {
        return "kolo";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "id, turnirid, redni";
    }

    @Override
    public String vratiVrednostiAtributa() {
      return ( "'" + id + "', '" + turnir + "', '"+ redni + "'");
               
    }

    @Override
    public String vratiJoinUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiID() {
        return " turnirid='" + turnir + "'";
    }

    @Override
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat vratiJedanObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPraviloSortiranja() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public LinkedList<Partija> getPartije() {
        return partije;
    }

    public void setPartije(LinkedList<Partija> partije) {
        this.partije = partije;
    }

    public int getTurnir() {
        return turnir;
    }

    public void setTurnir(int turnir) {
        this.turnir = turnir;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kolo other = (Kolo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.turnir != other.turnir) {
            return false;
        }
        return Objects.equals(this.partije, other.partije);
    }

    @Override
    public String vratiZaApdejt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getRedni() {
        return redni;
    }

    public void setRedni(int redni) {
        this.redni = redni;
    }
    
    
    
}
