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
public class Vozilo implements IDomenskiObjekat, Serializable {

    private int voziloID;
    private String oznakaMotora;
    private String oznakaSasije;
    private Tim tim;

    public Vozilo() {
    }

    public Vozilo(int voziloId, String oznakaMotora, String oznakaSasije, Tim tim) {
        this.voziloID = voziloId;
        this.oznakaMotora = oznakaMotora;
        this.oznakaSasije = oznakaSasije;
        this.tim = tim;
    }

    public int getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(int voziloID) {
        this.voziloID = voziloID;
    }

    public String getOznakaMotora() {
        return oznakaMotora;
    }

    public void setOznakaMotora(String oznakaMotora) {
        this.oznakaMotora = oznakaMotora;
    }

    public String getOznakaSasije() {
        return oznakaSasije;
    }

    public void setOznakaSasije(String oznakaSasije) {
        this.oznakaSasije = oznakaSasije;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
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
        final Vozilo other = (Vozilo) obj;
        if (!Objects.equals(this.oznakaMotora, other.oznakaMotora)) {
            return false;
        }
        if (!Objects.equals(this.oznakaSasije, other.oznakaSasije)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "vozilo";
    }




    @Override
    public String getSelectAllConditionQuery() {
        return "Select * from vozilo v join tim t on v.timID=t.timID"
                + " join drzava d on t.drzavaID=d.drzavaID"
                + " where v.timID=?";
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, voziloID);
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setString(1, oznakaMotora);
        ps.setString(2, oznakaSasije);
        ps.setInt(3, tim.getTimId());
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        ps.setInt(1, voziloID);
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        ps.setInt(1, voziloID);
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement ps) throws SQLException {
        ps.setInt(1, tim.getTimId());
    }

    @Override
    public String getErrorMessageSelect() {
        return "Ne postoji vozilo sa traženim id brojem: " + getVoziloID();
    }

    @Override
    public String getErrorMessageInsert() {
        return "Greška pri unosu novog vozila u bazu!";
    }

    @Override
    public String getErrorMessageUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        setVoziloID(id);
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
        return "Select * from vozilo v join tim t on v.timID=t.timID"
                + " join drzava d on t.drzavaID=d.drzavaID"
                + " where v.voziloID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName() + " (oznakaMotora, oznakaSasije, timID) values (?, ?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteQuery() {
        return "Delete from " + getTableName() + " where voziloID=?"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectAllQuery() {
        return "Select * from ((vozilo v join tim t on v.timID=t.timID)"
                + " join drzava d on t.drzavaID=d.drzavaID)";
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int voziloIDRet = rs.getInt("v.voziloID");
        String oznakaMotoraRet = rs.getString("v.oznakaMotora");
        String oznakaSasijeRet = rs.getString("v.oznakaSasije");

        int timIDRet = rs.getInt("t.timID");
        String timNazivRet = rs.getString("t.naziv");
        String izvrsniDirektorRet = rs.getString("t.izvrsniDirektor");
        String glavniTehnicarRet = rs.getString("t.glavniTehnicar");

        int drzavaTIDRet = rs.getInt("d.drzavaID");
        String drzavaTNazivRet = rs.getString("d.naziv");
        Drzava drzavaTRet = new Drzava(drzavaTIDRet, drzavaTNazivRet);

        Tim timRet = new Tim(timIDRet, timNazivRet, izvrsniDirektorRet, glavniTehnicarRet, drzavaTRet);

        return new Vozilo(voziloIDRet, oznakaMotoraRet, oznakaSasijeRet, timRet);
    }

    @Override
    public String getErrorMessageDelete() {
        return "Nastala je greška pri brisanju vozila sa oznakom šasije: " + oznakaSasije + "\nTim: " + tim.getNaziv();
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
