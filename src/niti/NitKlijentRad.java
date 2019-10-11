/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Drzava;
import domen.IDomenskiObjekat;
import domen.Rezultat;
import domen.Staza;
import domen.Tim;
import domen.Trka;
import domen.Vozac;
import domen.Vozilo;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import konstante.Operacija;
import konstante.Status;
import kontroler.Kontroler;
import so.IzbrisiVoziloSO;
import so.IzmeniTimSO;
import so.IzmeniTrkuSO;
import so.IzmeniVozacaSO;
import so.ObrisiTrkuSO;
import so.SacuvajRezultateTrkeSO;
import so.SacuvajTimSO;
import so.SacuvajTrkuSo;
import so.SacuvajVozacaSO;
import so.SacuvajVoziloSO;
import so.VratiDrzaveSO;
import so.VratiRezultateTimaSO;
import so.VratiRezultateTrkeSO;
import so.VratiRezultateVozacaSO;
import so.VratiStazeSO;
import so.VratiSveRezultateSO;
import so.VratiSveVozaceTimaSo;
import so.VratiTimoveSO;
import so.VratiTrkeSO;
import so.VratiVozaceSO;
import so.VratiVozilaSO;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Srdjan
 */
public class NitKlijentRad extends Thread {

    private final Socket soket;
    private String username;

    public NitKlijentRad(Socket s, String username) {
        this.soket = s;
        this.username = username;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Zahtev z = Komunikacija.primiZahtev(soket);
                Odgovor o = new Odgovor();

                switch (z.getOperacija()) {

                    /*case Operacija.LOGIN:
                    Korisnik k = (Korisnik) z.getPodaci();
                    o = new LoginSO(k).izvrsenjeSO();
                    Kontroler.getInstance().dodajKlijenta(k.getUsername(), s);
                    Kontroler.getInstance().povezanKlijent(k.getUsername());
                    o.setPoruka("true");
                    break;*/
                    case Operacija.LOGOUT:
                        soket.close();
                        Kontroler.getInstance().izbrisiKlijenta(username);
                        Kontroler.getInstance().klijentKraj(username);
                        return;

                    case Operacija.VRATI_DRZAVE:
                        try {
                            o = new VratiDrzaveSO().izvrsenjeSO(new Drzava());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_DRZAVE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_TIMOVE:
                        try {
                            o = new VratiTimoveSO().izvrsenjeSO(new Tim());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_TIMOVE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_VOZACE:
                        try {
                            o = new VratiVozaceSO().izvrsenjeSO(new Vozac());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_VOZACE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_TRKE:
                        try {
                            o = new VratiTrkeSO().izvrsenjeSO(new Trka());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_TRKE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_TRKE:
                        try {
                            o = new VratiRezultateTrkeSO().izvrsenjeSO((Rezultat) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_REZULTATE_TRKE);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_VOZACA:
                        try {
                            o = new VratiRezultateVozacaSO().izvrsenjeSO((Rezultat) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_REZULTATE_VOZACA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_TIMA:
                        try {
                            o = new VratiRezultateTimaSO().izvrsenjeSO((Rezultat) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_REZULTATE_TIMA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.SACUVAJ_TIM:
                        try {
                            o = new SacuvajTimSO().izvrsenjeSO((Tim) z.getPodaci());
                            Kontroler.getInstance().dodatTim(username, (Tim) o.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.SACUVAJ_TIM);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom dodavanja tima u bazu!");
                        }
                        break;

                    case Operacija.SACUVAJ_VOZILO:
                        try {
                            o = new SacuvajVoziloSO().izvrsenjeSO((Vozilo) z.getPodaci());
                            Kontroler.getInstance().dodatoVozilo(username, (Vozilo) o.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.SACUVAJ_VOZILO);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.SACUVAJ_VOZACA:
                        try {
                            o = new SacuvajVozacaSO().izvrsenjeSO((Vozac) z.getPodaci());
                            Kontroler.getInstance().dodatVozac(username, (Vozac) o.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.SACUVAJ_VOZACA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom čuvanja vozača!");
                        }
                        break;

                    case Operacija.SACUVAJ_TRKU:
                        try {
                            o = new SacuvajTrkuSo().izvrsenjeSO((Trka) z.getPodaci());
                            Kontroler.getInstance().dodataTrka(username, (Trka) o.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.SACUVAJ_TRKU);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom čuvanja trke!");
                        }
                        break;

                    case Operacija.SACUVAJ_REZULTATE_TRKE:
                        try {
                            o = new SacuvajRezultateTrkeSO().izvrsenjeSO((ArrayList<Rezultat>) z.getPodaci());
                            ArrayList<Rezultat> r = (ArrayList<Rezultat>) o.getPodaci();
                            Kontroler.getInstance().dodatRezultat(username, r.get(0));
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.SACUVAJ_REZULTATE_TRKE);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom čuvanja rezultata trke!");
                        }
                        break;

                    case Operacija.IZMENI_TRKU:
                        try {
                            o = new IzmeniTrkuSO().izvrsenjeSO((IDomenskiObjekat) z.getPodaci());
                            Kontroler.getInstance().izmenjenaTrka(username, (Trka) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.IZMENI_TRKU);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izmene trke!");
                        }
                        break;

                    case Operacija.IZMENI_VOZACA:
                        try {
                            o = new IzmeniVozacaSO().izvrsenjeSO((Vozac) z.getPodaci());
                            Kontroler.getInstance().izmenjenVozac(username, (Vozac) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.IZMENI_VOZACA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.IZMENI_TIM:
                        try {
                            o = new IzmeniTimSO().izvrsenjeSO((Tim) z.getPodaci());
                            Kontroler.getInstance().izmenjenTim(username, (Tim) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.IZMENI_TIM);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.IZBRISI_TRKU:
                        try {
                            o = new ObrisiTrkuSO().izvrsenjeSO((IDomenskiObjekat) z.getPodaci());
                            Kontroler.getInstance().izbrisiTrku(username, (Trka) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.IZBRISI_TRKU);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom brisnja trke!");
                        }
                        break;

                    case Operacija.IZBRISI_VOZILO:
                        try {
                            o = new IzbrisiVoziloSO().izvrsenjeSO(z.getPodaci());
                            Kontroler.getInstance().izbrisiVozilo(username, (Vozilo) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.IZBRISI_VOZILO);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_STAZE:
                        try {
                            o = new VratiStazeSO().izvrsenjeSO(new Staza());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_STAZE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_SVE_REZULTATE:
                        try {
                            o = new VratiSveRezultateSO().izvrsenjeSO(new Rezultat());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_SVE_REZULTATE);
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_VOZILA:
                        try {
                            o = new VratiVozilaSO().izvrsenjeSO((Vozilo) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_VOZILA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;

                    case Operacija.VRATI_SVE_VOZACE_TIMA:
                        try {
                            o = new VratiSveVozaceTimaSo().izvrsenjeSO((Vozac) z.getPodaci());
                        } catch (Exception exception) {
                            Kontroler.getInstance().appendError(exception.getMessage());
                            o.setStatus(Status.ERROR);
                            o.setOperacija(Operacija.VRATI_SVE_VOZACE_TIMA);
                            o.setPodaci(z.getPodaci());
                            o.setPoruka("Nastala je greška prilikom izvršavanja zahteva!");
                        }
                        break;
                }
                Komunikacija.posaljiOdgovor(o, soket);
            }
        } catch (Exception exception) {
            try {
                soket.close();
            } catch (IOException ex) {

            }
            Kontroler.getInstance().klijentKraj(username);
            Kontroler.getInstance().getKlijenti().remove(username);
        }
    }

}
