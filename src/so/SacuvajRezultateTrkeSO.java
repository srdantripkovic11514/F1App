/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class SacuvajRezultateTrkeSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> rezultati = db.insertMany((ArrayList<IDomenskiObjekat>) obj);
        Odgovor o = new Odgovor();
        o.setPodaci(rezultati);
        o.setPoruka("Rezultati su uspešno sačuvani");
        o.setOperacija(Operacija.SACUVAJ_REZULTATE_TRKE);
        o.setStatus(Status.OK);
        return o;
    }
    
}
