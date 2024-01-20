/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
public class Klub implements OpstiDomenskiObjekat {
    private int id;
    private String naziv;
    private String grad;
    private ArrayList<Igrac> igraci;

    public Klub() {
    }

    public Klub(int id, String naziv, String grad, ArrayList<Igrac> igraci) {
        this.id = id;
        this.naziv = naziv;
        this.igraci = igraci;
        this.grad = grad;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Klub other = (Klub) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        return Objects.equals(this.igraci, other.igraci);
    }

    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  naziv ;
    }
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

   

    @Override
    public String vratiNazivTabele() {
        return "club";
    }

    @Override
    public String vratiNaziveAtributa() {
       return "KlubID, Naziv, Grad";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return  ("'" + id + "', '" + naziv + "', '" + grad);
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
                Klub k = new Klub(rs.getInt("KlubID"), rs.getString("Naziv"), rs.getString("Grad"), null);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Turnir.class.getName()).log(Level.SEVERE, null, ex);
        } return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiJedanObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPraviloSortiranja() {
        return "Naziv";
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String vratiZaApdejt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
