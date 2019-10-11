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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Srdjan
 */
public class Trka implements IDomenskiObjekat, Serializable {

    private int trkaID;
    private String naziv;
    private int brojkrugova;
    private int duzinaTrke;
    private LocalDateTime datumOdrzavanja;
    private int najbrziKrug;
    private int sezona;

    private Staza staza;

    public Trka() {
    }

    public Trka(int trkaID, String naziv, int brojkrugova, int duzinaTrke, LocalDateTime datumOdrzavanja, int najbrziKrug, int sezona, Staza staza) {
        this.trkaID = trkaID;
        this.naziv = naziv;
        this.brojkrugova = brojkrugova;
        this.duzinaTrke = duzinaTrke;
        this.datumOdrzavanja = datumOdrzavanja;
        this.najbrziKrug = najbrziKrug;
        this.sezona = sezona;
        this.staza = staza;
    }

    public int getTrkaID() {
        return trkaID;
    }

    public void setTrkaID(int trkaID) {
        this.trkaID = trkaID;
    }
    
    public int getSezona() {
        return sezona;
    }

    public void setSezona(int sezona) {
        this.sezona = sezona;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojkrugova() {
        return brojkrugova;
    }

    public void setBrojkrugova(int brojkrugova) {
        this.brojkrugova = brojkrugova;
    }

    public int getDuzinaTrke() {
        return duzinaTrke;
    }

    public void setDuzinaTrke(int duzinaTrke) {
        this.duzinaTrke = duzinaTrke;
    }

    public LocalDateTime getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDateTime datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public int getNajbrziKrug() {
        return najbrziKrug;
    }

    public void setNajbrziKrug(int najbrziKrug) {
        this.najbrziKrug = najbrziKrug;
    }

    public Staza getStaza() {
        return staza;
    }

    public void setStaza(Staza staza) {
        this.staza = staza;
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
        final Trka other = (Trka) obj;
        if (Objects.equals(this.naziv, other.naziv) && this.sezona==other.sezona) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "trka";
    }




    @Override
    public String getSelectAllConditionQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, trkaID);
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setString(1, naziv);
        ps.setInt(2, brojkrugova);
        ps.setInt(3, duzinaTrke);
        ps.setTimestamp(4, Timestamp.valueOf(datumOdrzavanja));
        ps.setInt(5, najbrziKrug);
        ps.setInt(6, staza.getStazaID());
        ps.setInt(7, sezona);
    }

    @Override
    public void prepareStatementUpdate(PreparedStatement ps) throws SQLException {
        if (!datumOdrzavanja.isBefore(LocalDateTime.now())) {
            ps.setTimestamp(1, Timestamp.valueOf(datumOdrzavanja));
            ps.setInt(2, trkaID);
        }
    }

    @Override
    public void prepareStatementDelete(PreparedStatement ps) throws SQLException {
        ps.setInt(1, trkaID);
    }

    @Override
    public void prepareStatementSelectById(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageSelect() {
        return "Nastala je greška prilikom vraćanja podataka o trci iz baze";
    }

    @Override
    public String getErrorMessageInsert() {
        return "Nastala je greška prilikom dodavanja nove trke";
    }

    @Override
    public String getErrorMessageUpdate() {
        return "Nastala je greška prilikom ažuriranja trke";
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
        setTrkaID(id);
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
        return " Select * from ((trka t join staza s on t.stazaID=s.stazaID)"
                + " join drzava d on s.drzavaID=d.drzavaID)"
                + " where t.trkaID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName()
                + " (naziv, brojKrugova, duzinaTrke, datumOdrzavanja, najbrziKrug, stazaID, sezona)"
                + " values (?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        if (!datumOdrzavanja.isBefore(LocalDateTime.now())) {
            return "UPDATE " + getTableName() + " SET datumOdrzavanja = ? WHERE trkaID = ?";
        }
        return "";
    }

    @Override
    public String getDeleteQuery() {
        return "Delete from " + getTableName() + " where trkaID=?";
    }

    @Override
    public String getSelectAllQuery() {
        return " Select * from ((trka t join staza s on t.stazaID=s.stazaID)"
                + " join drzava d on s.drzavaID=d.drzavaID)";
    }

    @Override
    public String getSelectManyQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException {
        int trkaIDRet = rs.getInt("t.trkaID");
        String nazivRet = rs.getString("t.naziv");
        int brojKrugovaRet = rs.getInt("t.brojKrugova");
        int duzinaTrkeRet = rs.getInt("t.duzinaTrke");
        LocalDateTime datumOdrzavanjaRet = rs.getTimestamp("t.datumOdrzavanja").toLocalDateTime();
        int najbrziKrugRet = rs.getInt("t.najbrziKrug");
        int sezonaRet = rs.getInt("t.sezona");
        
        int stazaIDRet = rs.getInt("s.stazaID");
        String nazivSRet = rs.getString("s.naziv");
        int duzinaKrugaRet = rs.getInt("s.duzinaKruga");
        int najbrziKrugSRet = rs.getInt("s.najbrziKrug");
        
        int drzavaSIDRet = rs.getInt("d.drzavaID");
        String drzavaSNazivRet = rs.getString("d.naziv");
        Drzava drzavaSRet = new Drzava(drzavaSIDRet, drzavaSNazivRet);
        
        Staza stazaRet = new Staza(stazaIDRet, nazivSRet, duzinaKrugaRet, najbrziKrugSRet, drzavaSRet);

        return new Trka(trkaIDRet, nazivRet, brojKrugovaRet, duzinaTrkeRet, datumOdrzavanjaRet, najbrziKrugRet, sezonaRet, stazaRet);
    }

    @Override
    public String getErrorMessageDelete() {
        return "Nastala je greška pri brisanju trke: " + naziv;
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
