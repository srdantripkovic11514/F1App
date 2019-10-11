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
public interface IDomenskiObjekat extends Serializable {

    String getTableName();

    public String getSelectQuery();

    public String getInsertQuery();

    public String getUpdateQuery();

    public String getDeleteQuery();

    public String getSelectAllQuery();

    public String getSelectManyQuery();

    public void prepareStatementSelect(PreparedStatement ps) throws SQLException;

    public void prepareStatementInsert(PreparedStatement ps) throws SQLException;

    public void prepareStatementUpdate(PreparedStatement ps) throws SQLException;

    public void prepareStatementDelete(PreparedStatement ps) throws SQLException;

    public IDomenskiObjekat vratiPodatkeIzBaze(ResultSet rs) throws SQLException;

    public String getErrorMessageSelect();

    public String getErrorMessageInsert();

    public String getErrorMessageUpdate();

    public String getErrorMessageDelete();

    public String getSelectByIdQuery();

    public String getSelectAllConditionQuery();

    public String getErrorMessageFindAllByCondition();

    public void prepareStatementSelectAllByCondition(PreparedStatement ps) throws SQLException;

    public void prepareStatementSelectById(PreparedStatement ps) throws SQLException;

    public String getErrorMessageSelectById();

    public void prepareStatementSelectMany(PreparedStatement ps) throws SQLException;

    public boolean isComplexType();

    public ArrayList<IDomenskiObjekat> getSubArray();

    public boolean isIdAutoincrement();

    public void setAutoincrementId(int id);
}
