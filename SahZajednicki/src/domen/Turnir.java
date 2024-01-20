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
public class Turnir implements OpstiDomenskiObjekat {
    private int ID;
    private String naziv;
    private String mesto;
    private String tip;
  private String tempo;
  private LinkedList<Kolo> kola;
  private LinkedList<Igrac> igraci;
  private Sudija sudija;
  private String status;
  private Igrac prvi;
  private Igrac drugi;
  private Igrac treci;
  private int brojOdigranih;
  private String region;

    public Turnir() {
    }
    

    public Turnir(int ID, String naziv, String mesto, String tip, String tempo, LinkedList<Kolo> kola, LinkedList<Igrac> igraci, Sudija sudija, String status, String region) {
        this.ID = ID;
        this.naziv = naziv;
        this.mesto = mesto;
        this.tip = tip;
        this.tempo = tempo;
        this.kola = kola;
        this.igraci=igraci;
        this.sudija=sudija;
        this.status=status;
        this.region=region;
    }
    

    public LinkedList<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(LinkedList<Igrac> igraci) {
        this.igraci = igraci;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
   

    

  

    public int getID() {
        return ID;
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
        final Turnir other = (Turnir) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.mesto, other.mesto)) {
            return false;
        }
        if (!Objects.equals(this.tip, other.tip)) {
            return false;
        }
        if (!Objects.equals(this.tempo, other.tempo)) {
            return false;
        }
        if (!Objects.equals(this.kola, other.kola)) {
            return false;
        }
        if (!Objects.equals(this.igraci, other.igraci)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return Objects.equals(this.sudija, other.sudija);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return naziv;
    }



    
  

    @Override
    public String vratiNazivTabele() {
        return "turnir";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "Naziv, Mesto, Tip, Tempo, SudijaID, Status, Region";
    }

    @Override
    public String vratiVrednostiAtributa() {
       return ("'" + naziv + "', '" + mesto
                + "', '" + tip + "', '" + tempo+"', '"+sudija.getID()+"', '"+ status+"', '"+region+"'");
    }

    @Override
    public String vratiJoinUpit() {
        return " t join sudija s on t.sudijaid=s.sudijaid";
    }

    @Override
    public String vratiID() {
       return " turnirid='" + ID + "'";
    }

    @Override
    public LinkedList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
              LinkedList<OpstiDomenskiObjekat> lista= new LinkedList<>();
        try {
            while (rs.next()){
                Sudija s = new Sudija (rs.getInt("SudijaID"), rs.getString("Ime"),rs.getString("Prezime"),rs.getString("Titula"),rs.getString("Korisnicko"),rs.getString("Lozinka"));
                Turnir k = new Turnir(rs.getInt("TurnirID"), rs.getString("Naziv"), rs.getString("Mesto"), rs.getString("Tip"),rs.getString("Tempo"), new LinkedList<Kolo>(), new LinkedList<Igrac>(), s, rs.getString("Status"),rs.getString ("Region"));
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
        return "Naziv ";
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public LinkedList<Kolo> getKola() {
        return kola;
    }

    public void setKola(LinkedList<Kolo> kola) {
        this.kola = kola;
    }

    @Override
    public String vratiZaApdejt() {
         return "mesto = '" + mesto + "',"
            + " tip = '" + tip + "',"
                 + " status = '" + status + "',"
            + " region = '" + region + "',"
            + " tempo = '" + tempo + "'";
    }

    public Sudija getSudija() {
        return sudija;
    }

    public void setSudija(Sudija sudija) {
        this.sudija = sudija;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Igrac getPrvi() {
        return prvi;
    }

    public void setPrvi(Igrac prvi) {
        this.prvi = prvi;
    }

    public Igrac getDrugi() {
        return drugi;
    }

    public void setDrugi(Igrac drugi) {
        this.drugi = drugi;
    }

    public Igrac getTreci() {
        return treci;
    }

    public void setTreci(Igrac treci) {
        this.treci = treci;
    }

    public int getBrojOdigranih() {
        return brojOdigranih;
    }

    public void setBrojOdigranih(int brojOdigranih) {
        this.brojOdigranih = brojOdigranih;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
}
