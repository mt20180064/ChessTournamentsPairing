/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokretanje;

import domen.Sudija;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.OKZ;

/**
 *
 * @author Milena Kutch
 */
public class PokreniServer extends Thread {
    private ServerSocket ss;
    private boolean aktivan;
    private ArrayList<OKZ> klijenti;
    private ArrayList<Sudija> ulogovaneSudije;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(8909);
            System.out.println("pokrenut server");
            aktivan = true;
            while (aktivan){
                Socket klijent = ss.accept();
                System.out.println("klijent povezan");
                OKZ nit = new OKZ (klijent);
                klijenti.add(nit);
                nit.start();
            }
        } catch (IOException ex) {
            System.out.println("server ne moze da se pokrene");
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zaustaviServer(){
        aktivan = false;
        try {
            ss.close();
            if (klijenti!=null) klijenti.clear();
        } catch (IOException ex) {
            System.out.println("server ne moze da se zaustavi");
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public ArrayList<OKZ> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(ArrayList<OKZ> klijenti) {
        this.klijenti = klijenti;
    }

    public ArrayList<Sudija> getUlogovaneSudije() {
        return ulogovaneSudije;
    }

    public void setUlogovaneSudije(ArrayList<Sudija> ulogovaneSudije) {
        this.ulogovaneSudije = ulogovaneSudije;
    }

    public PokreniServer() {
        klijenti = new ArrayList<>();
        ulogovaneSudije= new ArrayList<>();
    }
    
     
    
    
}
