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
public class Drzava implements IDomenskiObjekat, Serializable {
    private int drzavaID;
    private String naziv;

    public Drzava() {
    }

    public Drzava(int drzavaID, String naziv) {
        this.drzavaID = drzavaID;
        this.naziv = naziv;
    }
    
    public int getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(int drzavaID) {
        this.drzavaID = drzavaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drzava other = (Drzava) obj;
        if (this.drzavaID != other.drzavaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "drzava";
    }




    /*@Override
    public String getQuery(int i) {
        
        switch(i){
            case Upit.SELECT_ALL:
                return "Select * from "+getTableName();
            case Upit.SELECT_BY_ID:
                return "Select * from "+getTableName()+" where id=?";
        }
        throw new UnsupportedOperationException("Operacija nije dostupna za domenski objekat " + getTableName());
    }*/

    @Override
    public String getSelectAllConditionQuery() {
    throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
    ps.setInt(1, drzavaID);
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement preparedStatement) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
    }

    /*@Override
    public String getErrorMessageSelect() {
    throw new UnsupportedOperationException("Not supported yet.");
    }*/

    @Override
    public String getErrorMessageInsert() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getErrorMessageUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getErrorMessageSelectById() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getErrorMessageFindAllByCondition() {
    throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isIdAutoincrement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setAutoincrementId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isComplexType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<IDomenskiObjekat> getSubArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, drzavaID);
    }

    @Override
    public String getErrorMessageSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM drzava WHERE drzavaID=?";
    }

    @Override
    public String getInsertQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Select * from "+getTableName();
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int idRS = rs.getInt(1);
        String nazivRS = rs.getString(2);
        
        return new Drzava(idRS, nazivRS);
    }

    @Override
    public String getErrorMessageDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public String getSelectByIdQuery() {
        return "Select * from "+getTableName()+" where drzavaID=?";
    }

    @Override
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
