/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Klub;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milena Kutch
 */
public class TabelaKlubova extends AbstractTableModel {
LinkedList<Klub> lista= new LinkedList<>();
String [] kolone = {"Registarski broj", "Naziv", "Grad"};
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
        Klub k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getId();
            case 1: return k.getNaziv();
            case 2: return k.getGrad();
            default: return "heh";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void postaviListu(LinkedList<Klub> klubovi) {
       lista=klubovi;
       fireTableDataChanged();
    }

    public LinkedList<Klub> getLista() {
        return lista;
    }
    
    
    
}
