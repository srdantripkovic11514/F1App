/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Trka;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Srdjan
 */
public class TabelaTrkaIzmenaModel extends AbstractTableModel {

    private ArrayList<Trka> trke = new ArrayList<>();
    private final String[] kolone = {"Naziv", "Datum odrzavanja", "Staza"};

    public TabelaTrkaIzmenaModel(ArrayList<Trka> trke) {
        this.trke = trke;
    }

    @Override
    public int getRowCount() {
        return trke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trka trka = trke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return trka.getNaziv();
            case 1:
                return trka.getDatumOdrzavanja();
            case 2:
                return trka.getStaza();
            default:
                return "nil";

        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

    public ArrayList<Trka> getTrke() {
        return trke;
    }

    public void setTrke(ArrayList<Trka> trke) {
        this.trke = trke;
    }

}
