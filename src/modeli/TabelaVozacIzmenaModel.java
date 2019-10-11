/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Vozac;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Srdjan
 */
public class TabelaVozacIzmenaModel extends AbstractTableModel {

    private ArrayList<Vozac> lista = new ArrayList<>();
    private final String[] kolone = {"Ime", "Prezime", "Takmicarski broj", "Tim"};

    public TabelaVozacIzmenaModel() {
    }
    
    public TabelaVozacIzmenaModel(ArrayList<Vozac> lista) {
        this.lista=lista;
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
        Vozac v = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getIme();
            case 1:
                return v.getPrezime();
            case 2:
                return v.getTakmicarskiBroj();
            case 3:
                return v.getTim();
            default:
                return "nil";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Vozac> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Vozac> lista) {
        this.lista = lista;
    }

    
    
}
