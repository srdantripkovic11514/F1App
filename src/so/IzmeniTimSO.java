/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Tim;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class IzmeniTimSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Tim v = (Tim) db.update((IDomenskiObjekat) obj);
        Odgovor o = new VratiTimoveSO().izvrsiOperaciju(v);
        o.setPoruka("Tim je uspešno ažuriran");
        o.setOperacija(Operacija.IZMENI_TIM);
        o.setStatus(Status.OK);
        return o;
    }
    
}
