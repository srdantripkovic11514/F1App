/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Srdjan
 */
public class Vozac implements IDomenskiObjekat, Serializable {

    private int vozacId;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private int takmicarskiBroj;
    private int brojPobeda;
    private Tim tim;
    private Drzava drzava;

    public Vozac() {
    }

    public Vozac(int vozacId, String ime, String prezime, LocalDate datumRodjenja, int takmicarskiBroj, int brojPobeda, Tim tim, Drzava drzava) {
        this.vozacId = vozacId;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.takmicarskiBroj = takmicarskiBroj;
        this.brojPobeda = brojPobeda;
        this.tim = tim;
        this.drzava = drzava;
    }

    public int getVozacId() {
        return vozacId;
    }

    public void setVozacId(int vozacId) {
        this.vozacId = vozacId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getTakmicarskiBroj() {
        return takmicarskiBroj;
    }

    public void setTakmicarskiBroj(int takmicarskiBroj) {
        this.takmicarskiBroj = takmicarskiBroj;
    }

    public int getBrojPobeda() {
        return brojPobeda;
    }

    public void setBrojPobeda(int brojPobeda) {
        this.brojPobeda = brojPobeda;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
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
        final Vozac other = (Vozac) obj;
        if (this.ime.equalsIgnoreCase(other.ime) && this.prezime.equalsIgnoreCase(other.prezime)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + ", " + tim;
    }

    @Override
    public String getTableName() {
        return "vozac";
    }


    @Override
    public String getSelectAllConditionQuery() {
        return "Select * from (((vozac v join tim t on v.timID=t.timID)"
                + " join drzava dv on v.drzavaID=dv.drzavaID)"
                + " join drzava dt on t.drzavaID=dt.drzavaID)"
                + " where v.timID=?";
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, vozacId);
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setDate(3, Date.valueOf(datumRodjenja));
        ps.setInt(4, takmicarskiBroj);
        ps.setInt(5, brojPobeda);
        ps.setInt(6, tim.getTimId());
        ps.setInt(7, drzava.getDrzavaID());
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, takmicarskiBroj);
        preparedStatement.setInt(2, brojPobeda);
        preparedStatement.setInt(3, tim.getTimId());
        preparedStatement.setInt(4, vozacId);
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        ps.setInt(1, vozacId);
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        ps.setInt(1, vozacId);
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement ps) throws SQLException {
        ps.setInt(1, tim.getTimId());
    }

    @Override
    public String getErrorMessageSelect() {
        return "Uneti id ne pripada nijednom vozacu";
    }

    @Override
    public String getErrorMessageInsert() {
        return "Nastala je greška prilikom dodavanja vozaca";
    }

    @Override
    public String getErrorMessageUpdate() {
        return "Nastala je greška prilikom ažuriranja vozaca";
    }

    @Override
    public String getErrorMessageSelectById() {
        return "Uneti id ne pripada nijednom vozacu";
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
        setVozacId(id);
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
        return "Select * from (((vozac v join tim t on v.timID=t.timID)"
                + " join drzava dv on v.drzavaID=dv.drzavaID)"
                + " join drzava dt on t.drzavaID=dt.drzavaID)"
                + " where v.vozacID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName()
                + " (ime, prezime, datumRodjenja, takmicarskiBroj, brojPobeda, timID, drzavaID)"
                + " values (?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "Update " + getTableName() + " set takmicarskiBroj=?, brojPobeda=?, timID=?  where vozacID=?";
    }

    @Override
    public String getDeleteQuery() {
        return "Delete from " + getTableName() + " where vozacID=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "Select * from (((vozac v join tim t on v.timID=t.timID)"
                + " join drzava dv on v.drzavaID=dv.drzavaID)"
                + " join drzava dt on t.drzavaID=dt.drzavaID)";
    }

    @Override
    public String getSelectManyQuery() {
        return "";
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int vozacIDRet = rs.getInt("v.vozacID");
        String imeRet = rs.getString("v.ime");
        String prezimeRet = rs.getString("v.prezime");
        LocalDate datumRodjenjaRet = rs.getDate("v.datumRodjenja").toLocalDate();
        int takmicarskiBrojRet = rs.getInt("v.takmicarskiBroj");
        int brojPobedaRet = rs.getInt("v.brojPobeda");

        int drzavaVIDRet = rs.getInt("dv.drzavaID");
        String drzavaVNazivRet = rs.getString("dv.naziv");
        Drzava drzavaVRet = new Drzava(drzavaVIDRet, drzavaVNazivRet);

        int timIDRet = rs.getInt("t.timID");
        String timNazivRet = rs.getString("t.naziv");
        String izvrsniDirektorRet = rs.getString("t.izvrsniDirektor");
        String glavniTehnicarRet = rs.getString("t.glavniTehnicar");

        int drzavaTIDRet = rs.getInt("dt.drzavaID");
        String drzavaTNazivRet = rs.getString("dt.naziv");
        Drzava drzavaTRet = new Drzava(drzavaTIDRet, drzavaTNazivRet);
        Tim timRet = new Tim(timIDRet, timNazivRet, izvrsniDirektorRet, glavniTehnicarRet, drzavaTRet);

        return new Vozac(vozacIDRet, imeRet, prezimeRet, datumRodjenjaRet, takmicarskiBrojRet, brojPobedaRet, timRet, drzavaVRet);
    }

    @Override
    public String getErrorMessageDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectByIdQuery() {
        return "Select * from (((vozac v join tim t on v.timID=t.timID)"
                + " join drzava dv on v.drzavaID=dv.drzavaID)"
                + " join drzava dt on t.drzavaID=dt.drzavaID)"
                + " where vozacID=?";
    }

    @Override
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
    }

}
