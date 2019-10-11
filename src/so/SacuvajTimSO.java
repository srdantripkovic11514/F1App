/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Tim;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class SacuvajTimSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        Tim tim = (Tim) obj;

        ArrayList<IDomenskiObjekat> timovi = db.selectAll(tim);
        for (IDomenskiObjekat ido : timovi) {
            Tim tim1 = (Tim) ido;
            if (tim.equals(tim1)) {
                throw new Exception("Ovaj tim već postoji u bazi");
            }

        }
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Tim tim = (Tim) db.insert((IDomenskiObjekat) obj);
        Odgovor o = new Odgovor();
        o.setPodaci(tim);
        o.setOperacija(Operacija.SACUVAJ_TIM);
        o.setPoruka("Tim je uspešno sačuvan");
        o.setStatus(Status.OK);
        return o;
    }
    
}
