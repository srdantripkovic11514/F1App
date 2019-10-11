/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Drzava;
import domen.IDomenskiObjekat;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class VratiDrzaveSO extends OpstaSO{


    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> lista = db.selectAll((Drzava) obj);
        ArrayList<Drzava> drzave = new ArrayList<>();
        for (IDomenskiObjekat iDomenskiObjekat : lista) {
            drzave.add((Drzava) iDomenskiObjekat);
        }
        
        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.VRATI_DRZAVE);
        o.setPodaci(drzave);
        o.setPoruka("Lista drzava uspesno vracena");
        o.setStatus(Status.OK);
        return o;
    }
    
}
