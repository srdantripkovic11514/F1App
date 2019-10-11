/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Vozilo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Srdjan
 */
public class TabelaVozilaModel extends AbstractTableModel {

    private ArrayList<Vozilo> lista;
    private final String[] kolone;

    public TabelaVozilaModel() {
        this.kolone = new String[]{"Oznaka motora", "Oznaka Sasije"};
        lista = new ArrayList<>();
    }
    

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
        Vozilo v = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getOznakaMotora();
            case 1:
                return v.getOznakaSasije();
            default:
                return "nil";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Vozilo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Vozilo> lista) {
        this.lista = lista;
    }

    
}
