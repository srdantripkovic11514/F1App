/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Vozilo;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class VratiVozilaSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> lista = db.selectAllCondition((Vozilo) obj);
        ArrayList<Vozilo> vozila = new ArrayList<>();
        for (IDomenskiObjekat iDomenskiObjekat : lista) {
            vozila.add((Vozilo) iDomenskiObjekat);
        }
        
        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.VRATI_VOZILA);
        o.setPodaci(vozila);
        o.setPoruka("Lista vozila uspesno vracena");
        o.setStatus(Status.OK);
        return o;
    }
    
}
