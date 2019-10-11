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
public class IzbrisiVoziloSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Vozilo v = (Vozilo) db.delete((IDomenskiObjekat) obj);
        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.IZBRISI_VOZILO);
        o.setPodaci(v);
        o.setPoruka("Vozilo je uspesno obrisano");
        o.setStatus(Status.OK);
        return o;
    }
    
}
