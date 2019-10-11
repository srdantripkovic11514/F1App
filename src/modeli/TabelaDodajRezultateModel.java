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
public class TabelaDodajRezultateModel extends AbstractTableModel {

    private final String[] kolone = {"Mesto", "Vozac", "Tim", "Poeni"};
    private ArrayList<Rezultat> lista = new ArrayList<>();

    public TabelaDodajRezultateModel() {
    }

    public TabelaDodajRezultateModel(ArrayList<Rezultat> lista) {
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
        Rezultat r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getKonacnaPozicija();
            case 1:
                return r.getVozac().getIme() + " " + r.getVozac().getPrezime();
            case 2:
                return r.getVozac().getTim();
            case 3:
                return r.getBrojPoena();
            default:
                return "nil";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Rezultat> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Rezultat> lista) {
        this.lista = lista;
    }

}
