/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.SettingsLoader;

/**
 *
 * @author Srdjan
 */
public class DBBroker {

    private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(SettingsLoader.getInstance().getValue("driver"));
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neodgovarajuci driver!" + ex.getMessage());
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            String url = SettingsLoader.getInstance().getValue("url");
            String user = SettingsLoader.getInstance().getValue("user");
            String password = SettingsLoader.getInstance().getValue("password");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);

        } catch (SQLException ex) {
            throw new Exception("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije zatvorena! " + ex.getMessage());
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije! " + ex.getMessage());
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije! " + ex.getMessage());
        }
    }

    public ArrayList<IDomenskiObjekat> selectAll(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getSelectAllQuery();
        ArrayList<IDomenskiObjekat> lista = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(upit);
        while (rs.next()) {
            lista.add(ido.vratiPodatkeIzBaze(rs));
        }
        return lista;
    }

    public ArrayList<IDomenskiObjekat> selectAllCondition(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getSelectAllConditionQuery();
        ArrayList<IDomenskiObjekat> lista = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementSelectAllByCondition(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(ido.vratiPodatkeIzBaze(rs));
        }

        return lista;
    }

    public ArrayList<IDomenskiObjekat> selectByID(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getSelectByIdQuery();
        ArrayList<IDomenskiObjekat> lista = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementSelectById(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            lista.add(ido.vratiPodatkeIzBaze(rs));
        }
        return lista;
    }

    public IDomenskiObjekat select(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getSelectQuery();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementSelect(ps);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            ido = ido.vratiPodatkeIzBaze(rs);
            rs.close();
            ps.close();
            return ido;
        }
        throw new Exception(ido.getErrorMessageSelect());
    }

    public IDomenskiObjekat insert(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getInsertQuery();
        PreparedStatement ps;

        if (ido.isIdAutoincrement()) {
            ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        } else {
            ps = connection.prepareStatement(upit);
        }
        ido.prepareStatementInsert(ps);
        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
            throw new Exception(ido.getErrorMessageInsert());
        }

        if (ido.isIdAutoincrement()) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ido.setAutoincrementId(rs.getInt(1));
                rs.close();
                ps.close();
            }
        }

        if (ido.isComplexType()) {
            for (IDomenskiObjekat ido1 : ido.getSubArray()) {
                insert(ido1);
            }
        }
        return ido;
    }

    public IDomenskiObjekat update(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getUpdateQuery();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementUpdate(ps);
        try {
            ps.executeUpdate();
        } catch (Exception sQLException) {
            System.out.println(sQLException);
            throw new Exception(ido.getErrorMessageUpdate());
        }

        return ido;
    }

    public IDomenskiObjekat delete(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getDeleteQuery();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementDelete(ps);
        ps.executeUpdate();
        return ido;
    }

    public ArrayList<IDomenskiObjekat> insertMany(ArrayList<IDomenskiObjekat> idoLista) throws Exception {
        otvoriKonekciju();

        try {
            for (IDomenskiObjekat ido : idoLista) {
                String query = ido.getInsertQuery();
                PreparedStatement preparedStatement;

                preparedStatement = connection.prepareStatement(query);

                ido.prepareStatementInsert(preparedStatement);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception(idoLista.get(0).getErrorMessageInsert());
        }

        return idoLista;
    }

    public ArrayList<IDomenskiObjekat> selectMany(IDomenskiObjekat ido) throws Exception {
        otvoriKonekciju();
        String upit = ido.getSelectManyQuery();
        ArrayList<IDomenskiObjekat> lista = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(upit);
        ido.prepareStatementSelectMany(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(ido.vratiPodatkeIzBaze(rs));
        }

        return lista;
    }


    /*public List<Drzava> vratiDrzave() throws Exception {
    List<Drzava> drzaveList = new ArrayList<>();
    try {
    String sql = "SELECT * FROM Drzava";
    Statement sqlStatement = connection.createStatement();
    ResultSet rs = sqlStatement.executeQuery(sql);
    while (rs.next()) {
    int id = rs.getInt(1);
    String naziv = rs.getString(2);
    drzaveList.add(new Drzava(id, naziv));
    }
    return drzaveList;
    } catch (SQLException ex) {
    throw new Exception("Neuspesno ucitavanje liste drzava!" + ex.getMessage());
    }
    }
    
    public List<Tim> vratiTimove() throws Exception {
    List<Tim> timoviList = new ArrayList<>();
    try {
    String sql = "SELECT t.*,d.* FROM tim t INNER JOIN drzava d ON (t.drzavaID=d.drzavaID) ORDER BY t.naziv";
    Statement sqlStatement = connection.createStatement();
    ResultSet rs = sqlStatement.executeQuery(sql);
    while (rs.next()) {
    int id = rs.getInt(1);
    String nazivTim = rs.getString(2);
    String izvrsniDirektor = rs.getString(3);
    String glavniTehnicar = rs.getString(4);
    int drzavaID = rs.getInt(5);
    String nazivDrzava = rs.getString(6);
    Drzava drzava = new Drzava(drzavaID, nazivDrzava);
    
    timoviList.add(new Tim(id, nazivTim, izvrsniDirektor, glavniTehnicar, drzava));
    }
    return timoviList;
    } catch (SQLException ex) {
    throw new Exception("Neuspesno ucitavanje liste timova!" + ex.getMessage());
    }
    }
    
    public List<Vozac> vratiVozace() throws Exception {
    List<Vozac> vozaciList = new ArrayList<>();
    try {
    String sql = "SELECT * FROM vozac ORDER BY prezime";
    Statement sqlStatement = connection.createStatement();
    ResultSet rs = sqlStatement.executeQuery(sql);
    while (rs.next()) {
    int vozacID = rs.getInt(1);
    String ime = rs.getString(2);
    String prezime = rs.getString(3);
    LocalDate datumRodjenja = rs.getDate(4).toLocalDate();
    int takmicarskiBroj = rs.getInt(5);
    int brojPobeda = rs.getInt(6);
    Tim tim = nadjiTimPrekoID(rs.getInt(7));
    Drzava drzava = nadjiDrzavuPrekoID(rs.getInt(8));
    }
    return vozaciList;
    } catch (SQLException ex) {
    throw new Exception("Neuspesno ucitavanje liste vozaca!" + ex.getMessage());
    }
    }
    
    private Drzava nadjiDrzavuPrekoID(int id) throws Exception {
    Drzava d = new Drzava();
    
    String sql = "SELECT * FROM drzava WHERE drzavaID = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    d.setDrzavaID(rs.getInt(1));
    d.setNaziv(rs.getString(2));
    }
    return d;
    }
    
    private Tim nadjiTimPrekoID(int id) throws Exception {
    Tim t = new Tim();
    t.setTimId(id);
    String sql = "SELECT t.*,d.* FROM tim t INNER JOIN drzava d ON (t.drzavaID=d.drzavaID) WHERE t.timID = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    t.setTimId(rs.getInt(1));
    t.setNaziv(rs.getString(2));
    t.setIzvrsniDirektor(rs.getString(3));
    t.setGlavniTehnicar(rs.getString(4));
    t.setDrzava(new Drzava(rs.getInt(5), rs.getString(6)));
    }
    return t;
    }
    
    public void sacuvajTim(Tim tim) throws Exception {
    try {
    String sql = "INSERT INTO Tim(naziv, izvrsniDirektor, glavniTehnicar, drzavaID) VALUES(?,?,?,?)";
    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
    ps.setString(1, tim.getNaziv());
    ps.setString(2, tim.getIzvrsniDirektor());
    ps.setString(3, tim.getGlavniTehnicar());
    ps.setInt(4, tim.getDrzava().getDrzavaID());
    
    ps.executeUpdate();
    ResultSet rs = ps.getGeneratedKeys();
    
    if (rs.next()) {
    int timID = rs.getInt(1);
    tim.setTimId(timID);
    }
    } catch (SQLException ex) {
    throw new Exception("Sistem ne moze da zapamti novi tim");
    }
    }
    
    public void sacuvajVozaca(Vozac vozac) throws Exception {
    try {
    String sql = "INSERT INTO vozac VALUES(?,?,?,?,?,?,?)";
    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
    ps.setString(1, vozac.getIme());
    ps.setString(2, vozac.getPrezime());
    ps.setDate(3, Date.valueOf(vozac.getDatumRodjenja()));
    ps.setInt(4, vozac.getTakmicarskiBroj());
    ps.setInt(5, vozac.getBrojPobeda());
    ps.setInt(5, vozac.getTim().getTimId());
    ps.setInt(7, vozac.getDrzava().getDrzavaID());
    ps.executeUpdate();
    
    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
    int vozacID = rs.getInt(1);
    vozac.setVozacId(vozacID);
    }
    } catch (SQLException ex) {
    throw new Exception("Sistem ne moze da zapamti novog vozaca");
    }
    }
    
    public void sacuvajVozilo(Vozilo vozilo) throws Exception{
    try {
    String sql = "INSERT INTO vozilo VALUES(?,?,?)";
    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
    ps.setString(1, vozilo.getOznakaMotora());
    ps.setString(2, vozilo.getOznakaSasije());
    ps.setInt(3, vozilo.getTim().getTimId());
    ps.executeUpdate();
    
    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
    int voziloID = rs.getInt(1);
    vozilo.setVoziloId(voziloID);
    }
    
    } catch (SQLException ex) {
    throw new Exception("Sistem ne moze da zapamti novog vozaca");
    }
    }
    
    public void sacuvajRezultateTrke(List<Rezultat> rezultati){
    
    
    }*/
}
