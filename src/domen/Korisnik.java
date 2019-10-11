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
import java.util.Objects;

/**
 *
 * @author Srdjan
 */
public class Korisnik implements Serializable, IDomenskiObjekat {

    private int korisnikID;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }




    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public String getErrorMessageSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public String getErrorMessageInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageSelectById() {
        return "Uneti id ne pripada nijednom korisniku";
    }

    @Override
    public String getErrorMessageFindAllByCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIdAutoincrement() {
        return true;
    }

    @Override
    public void setAutoincrementId(int id) {
        setKorisnikID(id);
    }

    @Override
    public boolean isComplexType() {
        return false;
    }

    @Override
    public ArrayList<IDomenskiObjekat> getSubArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectQuery() {
        return "SELECT korisnickoIme FROM " + getTableName() + " WHERE korisnickoIme=? AND lozinka=?";
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setString(1, username);
        ps.setString(2, password);
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
        return "Select * from " + getTableName();
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        String username1 = rs.getString(1);

        return new Korisnik(username1, "");
    }

    @Override
    public String getErrorMessageSelect() {
        return "Unesite ispravno korisnicko ime i lozinku";
    }

    @Override
    public String getErrorMessageDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public String getSelectByIdQuery() {
        return "Select * from " + getTableName() + "where korisnikID=?";
    }

    @Override
    public String getSelectAllConditionQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        ps.setInt(1, korisnikID);
    }

    @Override
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
