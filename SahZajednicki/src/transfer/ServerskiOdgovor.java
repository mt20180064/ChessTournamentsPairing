/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;


import java.io.Serializable;

/**
 *
 * @author Milena Kutch
 */
public class ServerskiOdgovor implements Serializable{
    private Object odgovor;
    private int operacija;
    private boolean uspesno;
    private String greska;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, int operacija, boolean uspesno, String greska) {
        this.odgovor = odgovor;
        this.operacija = operacija;
        this.uspesno = uspesno;
        this.greska = greska;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getGreska() {
        return greska;
    }

    public void setGreska(String greska) {
        this.greska = greska;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
    
     
}
