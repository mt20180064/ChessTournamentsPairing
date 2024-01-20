/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
public class Igrac implements OpstiDomenskiObjekat{
    private int id;
    private String ime;
    private String prezime;
    private String kategorija;
    private int rejting;
    private Klub klub;
   private double dod;
    private LinkedList<Igrac> protivnici = new LinkedList<>();
    private double poeni;
    private Igrac sledeci;
  
    

    public Igrac() {
    }

    public Igrac(int id, String ime, String prezime, String kategorija, int rejting, Klub klub){
       this.id=id;
        this.ime = ime;
        this.prezime = prezime;
        this.kategorija = kategorija;
        this.rejting = rejting;
        this.klub = klub;
       
        
    }
public Igrac(double poeni) {
            this.poeni = poeni;
            this.sledeci=null;
        }
     

    public int getRejting() {
        return rejting;
    }

    public void setRejting(int rejting) {
        this.rejting = rejting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return  ime + prezime;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

   

    @Override
    public String vratiNazivTabele() {
       return " igrac";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "KlubID, Ime, Prezime, Kategorija, Rejting";
    }
     

    @Override
    public String vratiVrednostiAtributa() {
        return ("'" +klub.getId() + "', '" + ime
                + "', '" + prezime + "', '" + kategorija
               + "', '" + rejting +"'");
    }

    @Override
    public String vratiJoinUpit() {
        return " i join club k on i.klubid=k.klubid ";
    }

    @Override
    public String vratiID() {
        return " igracid='" + id + "'";
    }

    @Override
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
        LinkedList<OpstiDomenskiObjekat> lista = new LinkedList<>();
        try {
            while (rs.next()){
                Klub k = new Klub(rs.getInt("k.KlubID"), rs.getString("k.Naziv"), rs.getString("k.Grad"), null);
                Igrac i = new Igrac(rs.getInt("i.IgracID"), rs.getString("i.ime"), rs.getString("i.prezime"), rs.getString("i.kategorija"), rs.getInt("i.rejting"),k);
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Igrac.class.getName()).log(Level.SEVERE, null, ex);
        } return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiJedanObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPraviloSortiranja() {
        return " Ime";
    }

    public LinkedList<Igrac> getProtivnici() {
        return protivnici;
    }

    public void setProtivnici(LinkedList<Igrac> protivnici) {
        this.protivnici = protivnici;
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
        final Igrac other = (Igrac) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.rejting != other.rejting) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.kategorija, other.kategorija)) {
            return false;
        }
       
        return Objects.equals(this.klub, other.klub);
    }

   

    public double getDod() {
        return dod;
    }

    public void setDod(double dod) {
        this.dod = dod;
    }

    @Override
    public String vratiZaApdejt() {
        return "";
    }

    public double getPoeni() {
        return poeni;
    }

    public void setPoeni(double poeni) {
        this.poeni = poeni;
    }

    public Igrac getSledeci() {
        return sledeci;
    }

    public void setSledeci(Igrac sledeci) {
        this.sledeci = sledeci;
    }

  
    
    
}
