/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Staza;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class VratiStazeSO extends OpstaSO{

    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> lista = db.selectAll((Staza) obj);
        ArrayList<Staza> staze = new ArrayList<>();
        for (IDomenskiObjekat iDomenskiObjekat : lista) {
            staze.add((Staza) iDomenskiObjekat);
        }
        Odgovor o  = new Odgovor();
        o.setOperacija(Operacija.VRATI_STAZE);
        o.setPodaci(staze);
        o.setPoruka("Lista staza uspesno vracena");
        o.setStatus(Status.OK);
        return o;
    }
    
}
