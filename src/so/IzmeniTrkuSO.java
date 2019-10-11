/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IDomenskiObjekat;
import domen.Trka;
import java.util.ArrayList;
import konstante.Operacija;
import konstante.Status;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class IzmeniTrkuSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        Trka trka = (Trka) obj;
        ArrayList<IDomenskiObjekat> idoList = db.selectAll((IDomenskiObjekat) obj);
        ArrayList<Trka> trke = new ArrayList<>();

        for (IDomenskiObjekat ido1 : idoList) {
            trke.add((Trka) ido1);
        }

        for (Trka trka1 : trke) {
            if (trka.getDatumOdrzavanja().equals(trka1.getDatumOdrzavanja())) {
                throw new Exception("Traženi datum već je zauzet");
            }
        }
    }

    @Override
    protected Odgovor izvrsiOperaciju(Object obj) throws Exception {
        Trka trka = (Trka) db.update((IDomenskiObjekat) obj);
        Odgovor o = new VratiTrkeSO().izvrsiOperaciju(trka);
        o.setPoruka("Trka je uspešno ažurirana");
        o.setOperacija(Operacija.IZMENI_TRKU);
        o.setStatus(Status.OK);
        return o;
    }

}
