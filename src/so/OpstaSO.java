/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.IDomenskiObjekat;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public abstract class OpstaSO {
    protected DBBroker db;

    public OpstaSO() {
        this.db = new DBBroker();
    }
    

    public synchronized final Odgovor izvrsenjeSO(Object obj) throws Exception {
        
        try {
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            Odgovor o = izvrsiOperaciju(obj);
            commitTransakcije();
            return o;
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }  
        
    }

    private void ucitajDriver() throws Exception {
        db.ucitajDriver();
    }

    private void otvoriKonekciju() throws Exception {
        db.otvoriKonekciju();
    }

    protected abstract void proveriPreduslov(Object obj) throws Exception;

    protected abstract Odgovor izvrsiOperaciju(Object obj) throws Exception;

    private void commitTransakcije() throws Exception {
        db.commitTransakcije();
    }

    private void rollbackTransakcije() throws Exception {
        db.rollbackTransakcije();
    }

    private void zatvoriKonekciju() throws Exception {
        db.zatvoriKonekciju();
    }
}
