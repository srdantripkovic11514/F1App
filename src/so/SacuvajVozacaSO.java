/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Vozac;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class SacuvajVozacaSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        Vozac v = (Vozac) obj;
        
        ArrayList<IDomenskiObjekat> vozaci = db.selectAll(v);
        for (IDomenskiObjekat ido : vozaci) {
            Vozac v1 = (Vozac) ido;
            if (v.equals(v1)) {
                throw new Exception("Ovaj vozač već postoji u bazi");
            }

        }
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Vozac vozac = (Vozac) db.insert((IDomenskiObjekat) obj);
        Odgovor o = new Odgovor();
        o.setPodaci(vozac);
        o.setOperacija(Operacija.SACUVAJ_VOZACA);
        o.setPoruka("Vozač je uspešno sačuvan");
        o.setStatus(Status.OK);
        return o;
    }
    
}
