/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;


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
public class Sudija implements OpstiDomenskiObjekat{
    
    
    private int ID;
    private String ime;
    private String prezime;
    private String titula;
     private String korisnicko;
    private String lozinka;
   

    public Sudija() {
    }

    public Sudija(int ID, String ime, String prezime, String titula, String korisnicko, String lozinka) {
        this.ID = ID;
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.korisnicko = korisnicko;
        this.lozinka = lozinka;
        
    }

   
    

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public int getID() {
        return ID;
    }
    

    public void setID(int ID) {
        this.ID = ID;
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



    @Override
    public String toString() {
        return ime + prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.ID;
        hash = 83 * hash + Objects.hashCode(this.ime);
        hash = 83 * hash + Objects.hashCode(this.prezime);
        hash = 83 * hash + Objects.hashCode(this.titula);
        hash = 83 * hash + Objects.hashCode(this.korisnicko);
        hash = 83 * hash + Objects.hashCode(this.lozinka);
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
        final Sudija other = (Sudija) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.titula, other.titula)) {
            return false;
        }
        if (!Objects.equals(this.korisnicko, other.korisnicko)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "sudija";
    }

    @Override
    public String vratiNaziveAtributa() {
       return "SudijaID, Ime, Prezime, Titula, Lozinka, Korisnicko";
    }

    @Override
    public String vratiVrednostiAtributa() {
       return ("'" + ID + "', '" + ime + "', '" + prezime
                + "', " + titula + ", " + lozinka
               + "', " + korisnicko 
                + ", '" +  "'");
    }

    @Override
    public String vratiJoinUpit() {
        return "";
    }

    @Override
    public String vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
         LinkedList<OpstiDomenskiObjekat> lista= new LinkedList<>();
        try {
            while (rs.next()){
                
                Sudija sud = new Sudija(rs.getInt("SudijaID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Titula"), rs.getString("Korisnicko"), rs.getString("Lozinka"));
                lista.add(sud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sudija.class.getName()).log(Level.SEVERE, null, ex);
        } return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiJedanObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPraviloSortiranja() {
       return "ime";
    }

 

    @Override
    public String vratiZaApdejt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
