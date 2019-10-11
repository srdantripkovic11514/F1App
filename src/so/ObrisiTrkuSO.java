/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Trka;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class ObrisiTrkuSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Trka trka  = (Trka) db.delete((IDomenskiObjekat) obj);
        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.IZBRISI_TRKU);
        o.setPodaci(trka);
        o.setPoruka("Trka je uspešno izbrisana");
        o.setStatus(Status.OK);
        return o;
    }
    
}
