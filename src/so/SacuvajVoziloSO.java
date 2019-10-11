/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Vozilo;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class SacuvajVoziloSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Vozilo vozilo = (Vozilo) db.insert((IDomenskiObjekat) obj);
        Odgovor o = new Odgovor();
        o.setPodaci(vozilo);
        o.setOperacija(Operacija.SACUVAJ_VOZILO);
        o.setPoruka("Vozilo je uspešno sačuvano");
        o.setStatus(Status.OK);
        return o;
    }
    
}
