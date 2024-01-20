/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Partija;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milena Kutch
 */
public class TabelaPartije extends AbstractTableModel {
String [] kolone = {"Tabla", "Beli", "Crni", "Rezb","Rezc"};
LinkedList<Partija> lista = new LinkedList<>();
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
         Partija p = lista.get(rowIndex);
        switch(columnIndex){
            case 0 : return p.getTabla();
            case 1: return p.getBeli();
            case 2: return p.getCrni();
            case 3: return p.getBodovibeli();
            case 4: return p.getBodovicrni();
            default : return "heh";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public LinkedList<Partija> getLista() {
        return lista;
    }

    public void postaviListu(LinkedList<Partija> partije) {
        lista= partije;
        fireTableDataChanged();
    }

    public void izmeni(Partija izmenjena) {
        fireTableDataChanged();
    }
    public void ocistiListu(){
        for (int i = 0; i <lista.size();i++){
           lista.remove(i);
           
    }fireTableDataChanged();
}
}