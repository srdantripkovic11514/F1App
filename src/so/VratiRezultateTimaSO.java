/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Rezultat;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class VratiRezultateTimaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        ArrayList<IDomenskiObjekat> lista = db.selectAllCondition((Rezultat) obj);
        ArrayList<Rezultat> rezultati = new ArrayList<>();

        for (IDomenskiObjekat iDomenskiObjekat : lista) {
            rezultati.add((Rezultat) iDomenskiObjekat);
        }

        Odgovor o = new Odgovor();
        o.setOperacija(Operacija.VRATI_REZULTATE_TIMA);
        o.setPodaci(rezultati);
        o.setPoruka("Lista rezultata uspesno vracena");
        o.setStatus(Status.OK);
        return o;
    }

}
