/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;


import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class KlasaDBBroker implements InterfaceDBBroker {

    @Override
    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
         Connection connection = KonekcijaSaBazom.getInstance().getConnection();
       // System.out.println("preuzeta konekcija na bazu");

        String upit = "INSERT INTO " + odo.vratiNazivTabele()
                + "(" + odo.vratiNaziveAtributa()+ ")"
                + " VALUES (" + odo.vratiVrednostiAtributa()+ ")";
        System.out.println(upit);

        PreparedStatement ps = connection.prepareStatement(upit);
      //  System.out.println(ps);

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
         Connection connection = KonekcijaSaBazom.getInstance().getConnection();
        //System.out.println("preuzeta konekcija na bazu");

        String upit = "UPDATE " + odo.vratiNazivTabele()
                + " SET " + odo.vratiZaApdejt()
                + " WHERE " + odo.vratiID();
       // System.out.println(upit);

        PreparedStatement ps = connection.prepareStatement(upit);
       // System.out.println(ps);

        ps.executeUpdate();
        ps.close();
        //System.out.println("Uspešno ste izmenili objekat u bazi!");
    }

    @Override
    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
         Connection connection = KonekcijaSaBazom.getInstance().getConnection();
        //System.out.println("preuzeta konekcija na bazu");

        String upit = "DELETE FROM " + odo.vratiNazivTabele()
                + " WHERE " + odo.vratiID();
        //System.out.println(upit);

        PreparedStatement ps = connection.prepareStatement(upit);
       // System.out.println(ps);

        ps.executeUpdate();
        ps.close();
        System.out.println("Uspesno ste obrisali objekat iz baze!");
    }

    public LinkedList<OpstiDomenskiObjekat> vrati(OpstiDomenskiObjekat odo) throws SQLException {
         Connection konekcija = KonekcijaSaBazom.getInstance().getConnection();
       // System.out.println("konektovano sa bazom da se uzmu sudije");
        
        String upit = "SELECT * FROM " +odo.vratiNazivTabele()
                +odo.vratiJoinUpit()
                + " ORDER BY " +odo.vratiPraviloSortiranja();
       // System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        LinkedList<OpstiDomenskiObjekat> lista = odo.vratiListuObjekata(rs);
        
        rs.close();
        s.close();
        
        return lista;
    }

    public LinkedList<OpstiDomenskiObjekat> pretrazi(OpstiDomenskiObjekat odo, String kriterijum) throws SQLException {
         Connection connection = KonekcijaSaBazom.getInstance().getConnection();
        //System.out.println("preuzeta konekcija na bazu");

        String upit = "SELECT * FROM " + odo.vratiNazivTabele()
                + odo.vratiJoinUpit()
                + " WHERE " + kriterijum
                + " ORDER BY " + odo.vratiPraviloSortiranja();
        System.out.println(upit);

        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        LinkedList<OpstiDomenskiObjekat> list = odo.vratiListuObjekata(rs);
System.out.println(upit);
        rs.close();
        s.close();
        return list;
    }


    
}
