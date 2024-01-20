/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generickaoperacija;

import baza.InterfaceDBBroker;
import baza.KlasaDBBroker;
import baza.KonekcijaSaBazom;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
public abstract class GenerickaOperacija {
    protected InterfaceDBBroker dbb;

    public GenerickaOperacija() {
        dbb = new KlasaDBBroker();
    }
    
    public final void Kosturizvrsi(OpstiDomenskiObjekat odo) throws SQLException{
        try {
            pokreniTransakciju();
            validacija(odo);
            izvrsi(odo);
            komitujTransakciju();
        } catch (SQLException ex) {
            rolbekujTransakciju();
            System.out.println("ne valja upit ili nesto sa bazom");
            Logger.getLogger(GenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            rolbekujTransakciju();
            System.out.println("ne valja validacija");
            Logger.getLogger(GenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected abstract void validacija(OpstiDomenskiObjekat odo) throws Exception ;
    protected abstract void izvrsi(OpstiDomenskiObjekat odo) throws Exception ;

    private void pokreniTransakciju() throws SQLException {
        KonekcijaSaBazom.getInstance().getConnection().setAutoCommit(false);
    }

    private void komitujTransakciju() throws SQLException {
        KonekcijaSaBazom.getInstance().commit();
    }

    private void rolbekujTransakciju() throws SQLException {
        KonekcijaSaBazom.getInstance().rollback();
    }
    
}
