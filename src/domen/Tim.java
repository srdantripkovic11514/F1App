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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Srdjan
 */
public class Tim implements IDomenskiObjekat, Serializable {

    private int timId;
    private String naziv;
    private String izvrsniDirektor;
    private String glavniTehnicar;
    private Drzava drzava;

    public Tim() {
    }

    public Tim(int timId, String naziv, String izvrsniDirektor, String glavniTehnicar, Drzava drzava) {
        this.timId = timId;
        this.naziv = naziv;
        this.izvrsniDirektor = izvrsniDirektor;
        this.glavniTehnicar = glavniTehnicar;
        this.drzava = drzava;
    }

    public int getTimId() {
        return timId;
    }

    public void setTimId(int timId) {
        this.timId = timId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getIzvrsniDirektor() {
        return izvrsniDirektor;
    }

    public void setIzvrsniDirektor(String izvrsniDirektor) {
        this.izvrsniDirektor = izvrsniDirektor;
    }

    public String getGlavniTehnicar() {
        return glavniTehnicar;
    }

    public void setGlavniTehnicar(String glavniTehnicar) {
        this.glavniTehnicar = glavniTehnicar;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Tim other = (Tim) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
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
        return "tim";
    }


    @Override
    public String getSelectAllConditionQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, timId);
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setString(1, naziv);
        ps.setString(2, izvrsniDirektor);
        ps.setString(3, glavniTehnicar);
        ps.setInt(4, drzava.getDrzavaID());
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, izvrsniDirektor);
        preparedStatement.setString(2, glavniTehnicar);
        preparedStatement.setInt(3, timId);
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        ps.setInt(1, timId);
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        ps.setInt(1, timId);
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageSelect() {
        return "Nastala je greška prilikom vracanja podataka o timu";
    }

    @Override
    public String getErrorMessageInsert() {
        return "Nastala je greška prilikom dodavanja tima";
    }

    @Override
    public String getErrorMessageUpdate() {
        return "Nastala je greška prilikom ažuriranja tima";
    }

    @Override
    public String getErrorMessageSelectById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        setTimId(id);
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
        return "Select * from tim t join drzava d on t.drzavaID=d.drzavaID where t.timID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName() + " (naziv, izvrsniDirektor, glavniTehnicar, drzavaID) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "Update " + getTableName() + " set izvrsniDirektor=?, glavniTehnicar=? where timID=?";
    }

    @Override
    public String getDeleteQuery() {
        return "Delete from " + getTableName() + " where timID=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM tim t JOIN drzava d ON t.drzavaID = d.drzavaID";
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int timIDRet = rs.getInt("t.timID");
        String timNazivRet = rs.getString("t.naziv");
        String izvrsniDirektorRet = rs.getString("t.izvrsniDirektor");
        String glavniTehnicarRet = rs.getString("t.glavniTehnicar");

        int drzavaTIDRet = rs.getInt("d.drzavaID");
        String drzavaTNazivRet = rs.getString("d.naziv");
        Drzava drzavaTRet = new Drzava(drzavaTIDRet, drzavaTNazivRet);

        return new Tim(timIDRet, timNazivRet, izvrsniDirektorRet, glavniTehnicarRet, drzavaTRet);
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
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
