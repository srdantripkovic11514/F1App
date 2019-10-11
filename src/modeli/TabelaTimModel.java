/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Tim;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Srdjan
 */
public class TabelaTimModel extends AbstractTableModel {

    private final String[] kolone = {"Tim", "Drzava"};
    private ArrayList<Tim> lista = new ArrayList<>();

    public TabelaTimModel() {
    }

    public TabelaTimModel(ArrayList<Tim> lista) {
        this.lista = lista;
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
        Tim t = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getNaziv();
            case 1:
                return t.getDrzava().getNaziv();
            default:
                return "nil";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Tim> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tim> lista) {
        this.lista = lista;
    }

}
