/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Srdjan
 */
public class Staza implements IDomenskiObjekat, Serializable{

    private int stazaID;
    private String naziv;
    private int duzinaKruga;
    private int najbrziKrug;
    private Drzava drzava;

    public Staza() {
    }

    public Staza(int stazaID, String naziv, int duzinaKruga, int najbrziKrug, Drzava drzava) {
        this.stazaID = stazaID;
        this.naziv = naziv;
        this.duzinaKruga = duzinaKruga;
        this.najbrziKrug = najbrziKrug;
        this.drzava = drzava;
    }
    
    @Override
    public String getTableName() {
        return "staza";
    }




    @Override
    public String getSelectQuery() {
        return " Select * from (staza s join drzava d on s.drzavaID=d.drzavaID)"
                + " where stazaID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName()
                + " (naziv, duzinaKruga, najbrziKrug, drzavaID)"
                + " values (?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM staza s JOIN drzava d ON s.drzavaID = d.drzavaID";
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, stazaID);
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setString(1, naziv);
        ps.setInt(2, duzinaKruga);
        ps.setInt(3, najbrziKrug);
        ps.setInt(4, drzava.getDrzavaID());
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int stazaIDRet = rs.getInt("s.stazaID");
        String nazivRet = rs.getString("s.naziv");
        int duzinaKrugaRet = rs.getInt("s.duzinaKruga");
        int najbrziKrugRet = rs.getInt("s.najbrziKrug");
        
        int drzavaSIDRet = rs.getInt("d.drzavaID");
        String drzavaSNazivRet = rs.getString("d.naziv");
        Drzava drzavaSRet = new Drzava(drzavaSIDRet, drzavaSNazivRet);
        
        return new Staza(stazaIDRet, nazivRet, duzinaKrugaRet, najbrziKrugRet, drzavaSRet);
    }

    @Override
    public String getErrorMessageSelect() {
        return "Nastala je greška, tražena staza nije pronađena";
    }

    @Override
    public String getErrorMessageInsert() {
        return "Nastala je greška prilikom dodavanja nove staze";
    }

    @Override
    public String getErrorMessageUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public String getSelectByIdQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectAllConditionQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageFindAllByCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageSelectById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isComplexType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IDomenskiObjekat> getSubArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIdAutoincrement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAutoincrementId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStazaID() {
        return stazaID;
    }

    public void setStazaID(int stazaID) {
        this.stazaID = stazaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getDuzinaKruga() {
        return duzinaKruga;
    }

    public void setDuzinaKruga(int duzinaKruga) {
        this.duzinaKruga = duzinaKruga;
    }

    public int getNajbrziKrug() {
        return najbrziKrug;
    }

    public void setNajbrziKrug(int najbrziKrug) {
        this.najbrziKrug = najbrziKrug;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return naziv + ", " + drzava.getNaziv();
    }
    
    
}
