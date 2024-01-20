/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import domen.Turnir;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milena Kutch
 */
public class TabelaTurnira extends AbstractTableModel {
    
    
    LinkedList<Turnir> lista = new LinkedList<>
            ();
String [] kolone = {"Registarski broj", "Naziv", "Mesto", "Tip", "Tempo", "Region"};

    public LinkedList<Turnir> getLista() {
        return lista;
    }



   

    @Override
    public int getRowCount() {
        if (lista==null){
            System.out.println("medo");
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turnir k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getID();
            case 1: return k.getNaziv();
            case 2: return k.getMesto();
            case 3: return k.getTip();
            case 4: return k.getTempo();
            case 5: return k.getRegion();
            default: return "heh";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void postaviListu(LinkedList<Turnir> turniri) {
       lista=turniri;
       fireTableDataChanged();
    }
    
}
