/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;



import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
public class Prijava implements OpstiDomenskiObjekat{
    private int id;
    
    
    private int TurnirID;
    private int IgracID;

    public Prijava() {
    }

    public Prijava(int id, int TurnirID, int IgracID) {
        this.id = id;
       
        this.TurnirID = TurnirID;
         this.IgracID = IgracID;
    }

   
    @Override
    public String vratiNazivTabele() {
        return " prijava";
    }

    @Override
    public String vratiNaziveAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                
                Prijava k = new Prijava(rs.getInt("PrijavaID"), rs.getInt("TurnirID"), rs.getInt("IgracID"));
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
        return " PrijavaID";
    }

    @Override
    public String vratiZaApdejt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIgracID() {
        return IgracID;
    }

    public void setIgracID(int IgracID) {
        this.IgracID = IgracID;
    }

    public int getTurnirID() {
        return TurnirID;
    }

    public void setTurnirID(int TurnirID) {
        this.TurnirID = TurnirID;
    }

    
    
    
}
