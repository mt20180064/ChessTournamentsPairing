/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;


import domen.Igrac;
import domen.Klub;
import domen.Kolo;
import domen.Partija;
import domen.Prijava;
import domen.Sudija;
import domen.Turnir;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  generickaoperacija.GenerickaOperacija;
import goklub.VratiKlubove;
import gosudija.VratiSudije;
import goigrac.DodajIgraca;
import goigrac.IzmeniIgraca;
import goigrac.NadjiIgrace;
import goigrac.VratiIgrace;
import goklub.NadjiKlubove;
import gokolo.SacuvajKolo;
import gopartije.VratiPartije;
import goprijava.VratiPrijave;
import goturnir.DodajTurnir;
import goturnir.IzmeniTurnir;
import goturnir.NadjiTurnire;
import goturnir.ObrisiTurnir;
import goturnir.VratiTurnire;
import pokretanje.PokreniServer; 

/**
 *
 * @author Milena Kutch
 */
public class KontrolerServer {
    private static KontrolerServer instance;
    private PokreniServer ps;

    public KontrolerServer() {
    }

    public static KontrolerServer getInstance() {
        if (instance==null){
            instance = new KontrolerServer();
        }
        return instance;
    }

    public void zaustaviServer() {
       ps.zaustaviServer();
    }

    public PokreniServer getPs() {
        return ps;
    }

    public void setPs(PokreniServer ps) {
        this.ps = ps;
    }

    public Sudija ulogujSudiju(Sudija sud){
       
        GenerickaOperacija go = new VratiSudije();
        try {
            go.Kosturizvrsi(sud);
        } catch (SQLException ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        LinkedList<Sudija> sudije = ((VratiSudije)go).getLista();
        System.out.println("lista sudija"+sudije);
        for (Sudija sudija : sudije) {
            if (sudija.getKorisnicko().equals(sud.getKorisnicko()) && sudija.getLozinka().equals(sud.getLozinka())){
                
            ps.getUlogovaneSudije().add(sudija);
               // System.out.println("dodat na listu ulogovanih sudija");
               // System.out.println("dodati sudija:"+sudija);
                return sudija;
        } 
            
        }
       
    return null;
    }

    public void odjaviSe(Sudija aktivni) {
        ps.getUlogovaneSudije().remove(aktivni);
        
        
    }

    public LinkedList<Klub> ucitajKlubove() throws SQLException {
        GenerickaOperacija go = new VratiKlubove();
        go.Kosturizvrsi(new Klub());
        return ((VratiKlubove)go).getLista();    }

    public LinkedList<Igrac> ucitajIgrace() throws SQLException {
        GenerickaOperacija go = new VratiIgrace();
        go.Kosturizvrsi(new Igrac());
        return ((VratiIgrace)go).getLista();

    }

    public LinkedList<Turnir> ucitajTurnire() throws SQLException {
        GenerickaOperacija go = new VratiTurnire();
        go.Kosturizvrsi(new Turnir());
        return ((VratiTurnire)go).getLista();
    }

    public void dodajIgraca(Igrac igrac) throws SQLException {
        GenerickaOperacija go = new DodajIgraca();
        go.Kosturizvrsi(igrac);
    }

   

    public void sacuvajKolo(Kolo kolo) throws SQLException {
        GenerickaOperacija go = new SacuvajKolo();
        go.Kosturizvrsi(kolo);
    }

    public LinkedList<Partija> ucitajPartije() throws SQLException {
        GenerickaOperacija go = new VratiPartije();
        go.Kosturizvrsi(new Partija());
        return ((VratiPartije)go).getLista();
    }





    public void izmeniigrace1(LinkedList<Igrac> igraciL1) throws SQLException {
        GenerickaOperacija go = new IzmeniIgraca();
        for (Igrac igrac : igraciL1) {
            go.Kosturizvrsi(igrac);
        }
    }

    public LinkedList<Turnir> pronadjiTurnire(String kriterijum) throws SQLException {
        GenerickaOperacija go = new NadjiTurnire(kriterijum);
        go.Kosturizvrsi(new Turnir());
        return ((NadjiTurnire)go).getLista();
    }

    public LinkedList<Klub> pronadjiKlubove(String kriter) throws SQLException {
        GenerickaOperacija go = new NadjiKlubove(kriter);
        go.Kosturizvrsi(new Klub());
        return ((NadjiKlubove)go).getLista();
    }

    public void obrisiTurnir(Turnir p) throws SQLException {
        GenerickaOperacija go = new ObrisiTurnir();
        go.Kosturizvrsi(p);
    }

    public LinkedList<Igrac> ucitajRezultate() throws SQLException {
       GenerickaOperacija go = new VratiIgrace();
        go.Kosturizvrsi(new Igrac());
        return ((VratiIgrace)go).getLista();
    }

    public LinkedList<Klub> zatraziKlubove() throws SQLException {
       GenerickaOperacija go = new VratiKlubove();
        go.Kosturizvrsi(new Klub());
        return ((VratiKlubove)go).getLista();
    }

    public LinkedList<Igrac> pronadjiIgrace(String kriteri) throws SQLException {
        GenerickaOperacija go = new NadjiIgrace(kriteri);
        go.Kosturizvrsi(new Igrac());
        return ((NadjiIgrace)go).getLista();
    }

    public void izmeniTurnir(Turnir t) throws SQLException {
        GenerickaOperacija go = new IzmeniTurnir();
        go.Kosturizvrsi(t);
    }

    public LinkedList<Prijava> ucitajPrijave(String tu) throws SQLException {
        GenerickaOperacija go = new VratiPrijave(tu);
        go.Kosturizvrsi(new Prijava());
        return ((VratiPrijave)go).getLista();
        
    }

    public void dodajTurnir(Turnir tf) throws SQLException {
         GenerickaOperacija go = new DodajTurnir();
        go.Kosturizvrsi(tf);
    }
}
    
    

