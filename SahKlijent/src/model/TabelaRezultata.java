/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Igrac;
import forme.FormaGlavna;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import sesija.Sesija;

/**
 *
 * @author Milena Kutch
 */
public class TabelaRezultata extends AbstractTableModel {
    
    LinkedList<Igrac> lista= new LinkedList<>();
String [] kolone = {"Ime", "Prezime", "Poeni"};


        



  
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Igrac k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getIme();
            case 1: return k.getPrezime();
            case 2: return k.getPoeni();
            default: return "heh";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void postaviListu(LinkedList<Igrac> igracii) {
      
        
       lista=igracii;
       
        Collections.sort(lista, new Comparator<Igrac>(){
            public int compare (Igrac igr1, Igrac igr2){
                if (igr1.getPoeni()<igr2.getPoeni()){
                    return 1;
                }
                return -1;
            }
        });
        
         
       fireTableDataChanged();
    }

    public LinkedList<Igrac> getLista() {
        return lista;
    }

    public void postaviMesta() {
        Igrac prvi = lista.get(0);
        Igrac drugi = lista.get(1);
        Igrac treci = lista.get(2);
        Sesija.getInstance().getTurnir().setPrvi(prvi);
        Sesija.getInstance().getTurnir().setDrugi(drugi);
        Sesija.getInstance().getTurnir().setTreci(treci);
    }

    

    
}
