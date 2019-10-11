/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Korisnik;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class LoginSO extends OpstaSO{

    
    @Override
    protected void proveriPreduslov(Object obj)throws Exception {
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Korisnik k = (Korisnik) db.select((Korisnik) obj);
        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.LOGIN);
        o.setPodaci(k);
        o.setPoruka("Uspesno ste prijavljeni");
        o.setStatus(Status.OK);
        return o;
    }
    
}
