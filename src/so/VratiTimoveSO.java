/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Tim;
import java.sql.Array;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class VratiTimoveSO extends OpstaSO{


    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> lista = db.selectAll((Tim) obj);
        ArrayList<Tim> timovi = new ArrayList<>();
        for (IDomenskiObjekat iDomenskiObjekat : lista) {
            timovi.add((Tim) iDomenskiObjekat);
        }
        
        Odgovor o  = new Odgovor();
        o.setOperacija(Operacija.VRATI_TIMOVE);
        o.setPodaci(timovi);
        o.setPoruka("Lista timova uspesno vracena");
        o.setStatus(Status.OK);
        return o;
    }
    
}
