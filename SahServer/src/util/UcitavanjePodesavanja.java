/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
public class UcitavanjePodesavanja {
    private Properties prop;
    private static UcitavanjePodesavanja instance;

    public static UcitavanjePodesavanja getInstance() {
        if (instance==null){
            instance = new UcitavanjePodesavanja();
        }
        return instance;
    }

    private UcitavanjePodesavanja() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("podesavanja.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UcitavanjePodesavanja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UcitavanjePodesavanja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

       public String getProperty(String key) {
        return prop.getProperty(key, "n/a");
    }

    public String getProperties() {
        String s = "";
        for (HashMap.Entry<Object, Object> entry : prop.entrySet()) {
            s += entry.getKey().toString()+ "=" + entry.getValue().toString() + "\n";
        }
        return s;
    }
    
    public void updateProperties(String newProperties) throws Exception{
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("settings.properties");
            String[] npSplitted = newProperties.split("\n");
            for (int i = 0; i < npSplitted.length; i++) {
                //System.out.println("before splitting: " + npSplitted[i]);
                int index = npSplitted[i].indexOf("=");
                if (index == -1) {
                    throw new Exception("Neispravan format! Nedostaje znak \'=\' !");
                }
                String key = npSplitted[i].substring(0, index);
                String value = npSplitted[i].substring(index+1);
                System.out.println("[key: " + npSplitted[i].substring(0, index) + "]"
                        + " = [value: " + npSplitted[i].substring(index+1) + "]");
                prop.setProperty(key, value);
            }
            System.out.println("");
            prop.store(out, null);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UcitavanjePodesavanja.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("File not found!");
        } catch (IOException ex) {
            Logger.getLogger(UcitavanjePodesavanja.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("IO greska!");
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(UcitavanjePodesavanja.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("IO greska kod zatvaranja izlaznog stream-a!");
            }
        }
    }
    
     
    
    
    
    
}
