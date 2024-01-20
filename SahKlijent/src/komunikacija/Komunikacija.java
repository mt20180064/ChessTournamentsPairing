/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milena Kutch
 */
public class Komunikacija {
    private static Komunikacija instance;
    Socket s;
    OSZ osz;
    

   
    public static Komunikacija getInstance() {
        if (instance==null){
            instance = new Komunikacija();
        }
        return instance;
    }


    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
            oos.flush();
        } catch (IOException ex) {
            System.out.println("greska u slanju zahteva");
            osz.prekiniObradu();
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor primiOdgovor(){ 
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("nesto ne valja u primi odgovor");
            osz.prekiniObradu();
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    public void konektujSe(){
          try {
            s = new Socket("localhost", 8909);
            System.out.println("klijent povezan (komunikacija)");
            osz = new OSZ();
            osz.start();
              System.out.println("pokrenuta obrada serverskih zahteva");
        } catch (IOException ex) {
               System.out.println("greska pri povezivanju klijenta na server");
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
         
        }
    }
    
   
 
}
