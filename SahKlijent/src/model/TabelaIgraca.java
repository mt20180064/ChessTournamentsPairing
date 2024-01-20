/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Igrac;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milena Kutch
 */
public class TabelaIgraca extends AbstractTableModel{
LinkedList<Igrac> lista = new LinkedList<>();
String [] kolone = { "klub", "ime", "prezime", "kategorija", "rejting"};
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
        Igrac i = lista.get(rowIndex);
        switch(columnIndex){
           
            case 0: return i.getKlub();
            case 1: return i.getIme();
            case 2: return i.getPrezime();
            case 3: return i.getKategorija();
            case 4: return i.getRejting();
            default : return "heh";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void postaviListu(LinkedList<Igrac> igraci) {
        lista = igraci;
        fireTableDataChanged();
    }
    
    
    
}
