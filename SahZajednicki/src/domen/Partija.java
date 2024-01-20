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
public class Partija implements OpstiDomenskiObjekat {
    private int id;
    private int tabla;
    private Sudija sudija;
    private Igrac beli;
    private Igrac crni;
    private Kolo kolo;
    private Turnir turnir;
    private double bodovibeli;
    private double bodovicrni;

    public Partija() {
    }

    public Partija(int id, int tabla, Sudija sudija, Igrac beli, Igrac crni, Kolo kolo, Turnir turnir, double bodovibeli, double bodovicrni) {
        this.id = id;
        this.tabla = tabla;
        this.sudija = sudija;
        this.beli = beli;
        this.crni = crni;
        this.kolo = kolo;
        this.turnir = turnir;
        this.bodovibeli = bodovibeli;
        this.bodovicrni = bodovicrni;
    }

    public double getBodovibeli() {
        return bodovibeli;
    }

    public void setBodovibeli(double bodovibeli) {
        this.bodovibeli = bodovibeli;
    }

    public double getBodovicrni() {
        return bodovicrni;
    }

    public void setBodovicrni(double bodovicrni) {
        this.bodovicrni = bodovicrni;
    }


    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTabla() {
        return tabla;
    }

    public void setTabla(int tabla) {
        this.tabla = tabla;
    }

    public Sudija getSudija() {
        return sudija;
    }

    public void setSudija(Sudija sudija) {
        this.sudija = sudija;
    }

    public Igrac getBeli() {
        return beli;
    }

    public void setBeli(Igrac beli) {
        this.beli = beli;
    }

    public Igrac getCrni() {
        return crni;
    }

    public void setCrni(Igrac crni) {
        this.crni = crni;
    }

    public Kolo getKolo() {
        return kolo;
    }

    public void setKolo(Kolo kolo) {
        this.kolo = kolo;
    }

    @Override
    public String vratiNazivTabele() {
        return "partija";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "id, tabla, sudija, beli, crni, kolo, turnir, bodovibeli, bodovicrni";
    }
 
    @Override
    public String toString() {
        return "Partija{" + "id=" + id + ", tabla=" + tabla + ", sudija=" + sudija + ", beli=" + beli + ", crni=" + crni + ", kolo=" + kolo + ", turnir=" + turnir + ", bodovibeli=" + bodovibeli + ", bodovicrni=" + bodovicrni + '}';
    }

    @Override
    public String vratiVrednostiAtributa() {
        return ("" + id + ", " + tabla
                + ", '" + sudija.getID()
                + "', '" + beli.getId()
                + "', '" + crni.getId() + "', '" + kolo.getId()
                + "', '" + turnir.getID() + "', '" + bodovibeli
                + "', '" + bodovicrni + "'");
    }

    @Override
    public String vratiJoinUpit() {
        return " p join sudija s on p.sudija=s.sudijaid join igrac i1 on i1.igracid=p.beli join igrac i2 on i2.igracid=p.crni join kolo k on p.kolo=k.id join turnir t on t.turnirid=p.turnir WHERE t.turnirid=p.turnir ";
    }

    @Override
    public String vratiID() {
       return " kolo='" + kolo + "'";
    }

    @Override
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
       LinkedList<OpstiDomenskiObjekat> lista = new LinkedList<>();
        try {
            while (rs.next()){
                
                 
                Sudija s = new Sudija(rs.getInt("s.sudijaid"), rs.getString("s.ime"), rs.getString("s.prezime"), rs.getString("s.titula"), rs.getString("s.korisnicko"), rs.getString("s.lozinka"));
                Turnir t = new Turnir(rs.getInt("t.turnirid"), rs.getString("t.naziv"), rs.getString("t.mesto"), rs.getString("t.tip"), rs.getString("t.tempo"), null, null,s,rs.getString("t.status"),rs.getString("t.region"));
                Kolo k = new Kolo(rs.getInt("k.id"), t.getID(), rs.getInt("k.redni"),null); //DO OVDE SAM STIGLA
                Igrac i1 = new Igrac(rs.getInt("i1.igracid"), rs.getString("i1.ime"), rs.getString("i1.prezime"), rs.getString("i1.kategorija"), rs.getInt("i1.rejting"), null);
                Igrac i2 = new Igrac(rs.getInt("i2.igracid"), rs.getString("i2.ime"), rs.getString("i2.prezime"), rs.getString("i2.kategorija"), rs.getInt("i2.rejting"), null);
                Partija p = new Partija(rs.getInt("p.id"), rs.getInt("p.tabla"), s, i1, i2, k, t, rs.getInt("p.bodovibeli"), rs.getInt("p.bodovicrni"));
        
                lista.add(p);
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
        return "p.id";
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
        final Partija other = (Partija) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tabla != other.tabla) {
            return false;
        }
        if (Double.doubleToLongBits(this.bodovibeli) != Double.doubleToLongBits(other.bodovibeli)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bodovicrni) != Double.doubleToLongBits(other.bodovicrni)) {
            return false;
        }
        if (!Objects.equals(this.sudija, other.sudija)) {
            return false;
        }
        if (!Objects.equals(this.beli, other.beli)) {
            return false;
        }
        if (!Objects.equals(this.crni, other.crni)) {
            return false;
        }
        if (!Objects.equals(this.kolo, other.kolo)) {
            return false;
        }
        return Objects.equals(this.turnir, other.turnir);
    }

    @Override
    public String vratiZaApdejt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 


    
    
}
