/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Rezultat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Srdjan
 */
public class TabelaTabelaKonstruktoraModel extends AbstractTableModel {

    ArrayList<Rezultat> rezultati = new ArrayList<>();
    String[] kolone = {"Tim", "Broj poena"};

    @Override
    public int getRowCount() {
        return rezultati.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezultat r = rezultati.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getVozac().getTim();
            case 1:
                return r.getBrojPoena();
            default:
                return "nil";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

}
