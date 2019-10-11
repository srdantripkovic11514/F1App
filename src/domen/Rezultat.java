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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Srdjan
 */
public class Rezultat implements IDomenskiObjekat, Serializable {

    private Trka trka;
    private Vozac vozac;
    private int startnaPozicija;
    private int konacnaPozicija;
    private int brojPoena;


    public Rezultat() {
    }

    public Rezultat(Trka trka, Vozac vozac, int startnaPozicija, int konacnaPozicija, int brojPoena) {
        this.trka = trka;
        this.vozac = vozac;
        this.startnaPozicija = startnaPozicija;
        this.konacnaPozicija = konacnaPozicija;
        this.brojPoena = brojPoena;
    }

    public Trka getTrka() {
        return trka;
    }

    public void setTrka(Trka trka) {
        this.trka = trka;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public int getStartnaPozicija() {
        return startnaPozicija;
    }

    public void setStartnaPozicija(int startnaPozicija) {
        this.startnaPozicija = startnaPozicija;
    }

    public int getKonacnaPozicija() {
        return konacnaPozicija;
    }

    public void setKonacnaPozicija(int konacnaPozicija) {
        this.konacnaPozicija = konacnaPozicija;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
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
        final Rezultat other = (Rezultat) obj;
        if (!Objects.equals(this.trka, other.trka)) {
            return false;
        }
        if (!Objects.equals(this.vozac, other.vozac)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return trka + ", " + vozac + ", " + brojPoena;
    }

    @Override
    public String getTableName() {
        return "rezultat";
    }




    @Override
    public String getSelectAllConditionQuery() {
        return "Select * from rezultat r join trka t on r.trkaID=t.trkaID"
                + " join staza s on t.stazaID=s.stazaID"
                + " join drzava ds on ds.drzavaID=s.drzavaID"
                + " join vozac v on r.vozacID=v.vozacID"
                + " join drzava dv on v.drzavaID=dv.drzavaID"
                + " join tim ti on v.timID=ti.timID"
                + " join drzava dt on ti.drzavaID=dt.drzavaID"
                + " where v.timID=?";
    }

    @Override
    public void prepareStatementSelect(PreparedStatement ps) throws SQLException {
        ps.setInt(1, trka.getTrkaID());
        ps.setInt(2, vozac.getVozacId());
    }

    @Override
    public void prepareStatementInsert(PreparedStatement ps) throws SQLException {
        ps.setInt(1, trka.getTrkaID());
        ps.setInt(2, vozac.getVozacId());
        ps.setInt(3, startnaPozicija);
        ps.setInt(4, konacnaPozicija);
        ps.setInt(5, brojPoena);
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
    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException {
        ps.setInt(1, trka.getTrkaID());
    }

    @Override
    public void prepareStatementSelectAllByCondition(PreparedStatement ps) throws SQLException {
        ps.setInt(1, vozac.getTim().getTimId());
    }

    @Override
    public String getErrorMessageSelect() {
        return "Nastala je greška pri vraćanju traženog rezultata";
    }

    @Override
    public String getErrorMessageInsert() {
        return "Nastala je greška pri dodavanju novog rezultata";
    }

    @Override
    public String getErrorMessageUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getErrorMessageSelectById() {
        return "Nastala je greška pri vraćanju traženih rezultata";
    }

    @Override
    public String getErrorMessageFindAllByCondition() {
        return "Nastala je greška pri vraćanju traženih rezultata";
    }

    @Override
    public boolean isIdAutoincrement() {
        return false;
    }

    @Override
    public void setAutoincrementId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Select * from rezultat r join trka t on r.trkaID=t.trkaID"
                + " join staza s on t.stazaID=s.stazaID"
                + " join drzava ds on ds.drzavaID=s.drzavaID"
                + " join vozac v on r.vozacID=v.vozacID"
                + " join drzava dv on v.drzavaID=dv.drzavaID"
                + " join tim ti on v.timID=ti.timID"
                + " join drzava dt on ti.drzavaID=dt.drzavaID"
                + " where r.trkaID=? and r.vozacID=?";
    }

    @Override
    public String getInsertQuery() {
        return "Insert into " + getTableName() + " values(?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteQuery() {
        return "Delete from " + getTableName() + " where trkaID = ? and vozacID = ?";
    }

    @Override
    public String getSelectAllQuery() {
        return "Select * from rezultat r join trka t on r.trkaID=t.trkaID"
                + " join staza s on t.stazaID=s.stazaID"
                + " join drzava ds on ds.drzavaID=s.drzavaID"
                + " join vozac v on r.vozacID=v.vozacID"
                + " join drzava dv on v.drzavaID=dv.drzavaID"
                + " join tim ti on v.timID=ti.timID"
                + " join drzava dt on ti.drzavaID=dt.drzavaID";
    }

    @Override
    public String getSelectManyQuery() {
        return "Select * from rezultat r join trka t on r.trkaID=t.trkaID"
                + " join staza s on t.stazaID=s.stazaID"
                + " join drzava ds on ds.drzavaID=s.drzavaID"
                + " join vozac v on r.vozacID=v.vozacID"
                + " join drzava dv on v.drzavaID=dv.drzavaID"
                + " join tim ti on v.timID=ti.timID"
                + " join drzava dt on ti.drzavaID=dt.drzavaID"
                + " where r.vozacID=?";
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

        int drzavaSIDRet = rs.getInt("ds.drzavaID");
        String drzavaSNazivRet = rs.getString("ds.naziv");

        Drzava drzavaSRet = new Drzava(drzavaSIDRet, drzavaSNazivRet);
        Staza stazaRet = new Staza(stazaIDRet, nazivSRet, duzinaKrugaRet, najbrziKrugSRet, drzavaSRet);
        Trka trkaRet = new Trka(trkaIDRet, nazivRet, brojKrugovaRet, duzinaTrkeRet,
                datumOdrzavanjaRet, najbrziKrugRet, sezonaRet, stazaRet);

        int vozacIDRet = rs.getInt("v.vozacID");
        String imeRet = rs.getString("v.ime");
        String prezimeRet = rs.getString("v.prezime");
        LocalDate datumRodjenjaRet = rs.getDate("v.datumRodjenja").toLocalDate();
        int takmicarskiBrojRet = rs.getInt("v.takmicarskiBroj");
        int brojPobedaRet = rs.getInt("v.brojPobeda");

        int drzavaVIDRet = rs.getInt("dv.drzavaID");
        String drzavaVNazivRet = rs.getString("dv.naziv");
        Drzava drzavaVRet = new Drzava(drzavaVIDRet, drzavaVNazivRet);

        int timIDRet = rs.getInt("ti.timID");
        String timNazivRet = rs.getString("ti.naziv");
        String izvrsniDirektorRet = rs.getString("ti.izvrsniDirektor");
        String glavniTehnicarRet = rs.getString("ti.glavniTehnicar");

        int drzavaTIDRet = rs.getInt("dt.drzavaID");
        String drzavaTNazivRet = rs.getString("dt.naziv");
        Drzava drzavaTRet = new Drzava(drzavaTIDRet, drzavaTNazivRet);

        Tim timRet = new Tim(timIDRet, timNazivRet, izvrsniDirektorRet, glavniTehnicarRet, drzavaTRet);
        Vozac vozacRet = new Vozac(vozacIDRet, imeRet, prezimeRet, datumRodjenjaRet,
                takmicarskiBrojRet, brojPobedaRet, timRet, drzavaVRet);

        int startnaRet = rs.getInt("r.startnaPozicija");
        int konacnaRet = rs.getInt("r.konacnaPozicija");
        int brojPoenaRet = rs.getInt("r.brojPoena");

        return new Rezultat(trkaRet, vozacRet, startnaRet, konacnaRet, brojPoenaRet);
    }

    @Override
    public String getErrorMessageDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public String getSelectByIdQuery() {
        return "Select * from rezultat r join trka t on r.trkaID=t.trkaID"
                + " join staza s on t.stazaID=s.stazaID"
                + " join drzava ds on ds.drzavaID=s.drzavaID"
                + " join vozac v on r.vozacID=v.vozacID"
                + " join drzava dv on v.drzavaID=dv.drzavaID"
                + " join tim ti on v.timID=ti.timID"
                + " join drzava dt on ti.drzavaID=dt.drzavaID"
                + " where r.trkaID=?";
    }

    @Override
    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException {
        ps.setInt(1, vozac.getVozacId());
    }

}
