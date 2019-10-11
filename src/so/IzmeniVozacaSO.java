/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Vozac;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class IzmeniVozacaSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Vozac v = (Vozac) db.update((IDomenskiObjekat) obj);
        Odgovor o = new VratiVozaceSO().izvrsiOperaciju(v);
        o.setPoruka("Vozač je uspešno ažurirana");
        o.setOperacija(Operacija.IZMENI_VOZACA);
        o.setStatus(Status.OK);
        return o;
    }
    
}
