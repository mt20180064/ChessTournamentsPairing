/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.UcitavanjePodesavanja;

/**
 *
 * @author Milena Kutch
 */
public class KonekcijaSaBazom {
    private static KonekcijaSaBazom instance;
    Connection connection;

    private KonekcijaSaBazom() throws SQLException {
        String url = UcitavanjePodesavanja.getInstance().getProperty("url");
        String user = UcitavanjePodesavanja.getInstance().getProperty("user");
        String password = UcitavanjePodesavanja.getInstance().getProperty("password");
        
       connection= DriverManager.getConnection(url, user, password);
       connection.setAutoCommit(false);
    }

    public Connection getConnection() {
        return connection;
    }

    public static KonekcijaSaBazom getInstance() throws SQLException {
        if (instance==null){
            instance = new KonekcijaSaBazom();
        }
        return instance;
    }
    
    public void commit() throws SQLException{
        connection.commit();
    }
     public void rollback() throws SQLException{
         connection.rollback();
     }
}
