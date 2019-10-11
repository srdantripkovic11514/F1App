/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Drzava;
import domen.Staza;
import domen.Tim;
import domen.Trka;
import domen.Vozac;
import domen.Vozilo;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import konstante.Operacija;
import konstante.Status;
import kontroler.Kontroler;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class KlijentskaNit extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Odgovor o = Komunikacija.getInstance().primiOdgovor();

                switch (o.getOperacija()) {

                    case Operacija.VRATI_DRZAVE:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setDrzave((ArrayList<Drzava>) o.getPodaci());
                            if (Kontroler.getInstance().getDodajTimForma() != null) {
                                Kontroler.getInstance().setComboDrzaveFDodajTim(o);
                            }
                            if (Kontroler.getInstance().getDodajVozacaForma() != null) {
                                Kontroler.getInstance().setComboDrzaveFDodajVozaca(o);
                            }

                        }
                        
                        break;

                    case Operacija.VRATI_TIMOVE:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setTimovi((ArrayList<Tim>) o.getPodaci());
                            if (Kontroler.getInstance().getVozilaForma() != null) {
                                Kontroler.getInstance().setComboTimoviFVozila(o);
                            }
                            if (Kontroler.getInstance().getDodajVozacaForma() != null) {
                                Kontroler.getInstance().setComboTimoviFDodajVozaca(o);
                            }
                            if (Kontroler.getInstance().getIzmeniVozacaForma() != null) {
                                Kontroler.getInstance().setComboTimoviFIzmeniVozaca(o);
                            }
                            if (Kontroler.getInstance().getTimoviForm() != null) {
                                Kontroler.getInstance().setTimoviFTim(o);
                            }
                            if (Kontroler.getInstance().getIzmeniTimForma() != null) {
                                Kontroler.getInstance().setTimoviFIzmeniTim(o);
                            }
                            if (Kontroler.getInstance().getTabelaForm() != null) {
                                Kontroler.getInstance().getSviTimoviFStatistika(o);
                            }
                        }

                        break;

                    case Operacija.VRATI_VOZACE:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setVozaci((ArrayList<Vozac>) o.getPodaci());
                            if (Kontroler.getInstance().getIzmeniVozacaForma() != null) {
                                Kontroler.getInstance().setTabelaVozacIzmena(o);
                            }
                            if (Kontroler.getInstance().getDodajRezultateForma() != null) {
                                Kontroler.getInstance().setComboVozaciFDodajRezultate(o);
                            }
                            if (Kontroler.getInstance().getVozaciForm() != null) {
                                Kontroler.getInstance().getVozaciFVozac(o);
                            }
                            if (Kontroler.getInstance().getTabelaForm() != null) {
                                Kontroler.getInstance().getSviVozaciFStatistika(o);
                            }
                        }

                        break;

                    case Operacija.VRATI_SVE_VOZACE_TIMA:
                        if (o.getStatus() == Status.OK) {
                            if (Kontroler.getInstance().getTimoviForm() != null) {
                                Kontroler.getInstance().getVozaciTimaFTim(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_TRKE:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setTrke((ArrayList<Trka>) o.getPodaci());
                            if (Kontroler.getInstance().getIzmeniTrkuForma() != null) {
                                Kontroler.getInstance().setTabelaTrkaIzmena(o);
                            }
                            if (Kontroler.getInstance().getObrisiTrkuForma() != null) {
                                Kontroler.getInstance().setTabelaTrkaObrisi(o);
                            }
                            if (Kontroler.getInstance().getDodajRezultateForma() != null) {
                                Kontroler.getInstance().setTabelaTrkaFDodajRezultate(o);
                            }
                            if (Kontroler.getInstance().getTrkeForm() != null) {
                                Kontroler.getInstance().vratiTrkeFTrke(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_STAZE:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setStaze((ArrayList<Staza>) o.getPodaci());
                            if (Kontroler.getInstance().getDodajTrkuForma() != null) {
                                Kontroler.getInstance().setComboFDodajTrku(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_TRKE:
                        if (o.getStatus() == Status.OK) {
                            if (Kontroler.getInstance().getDodajRezultateForma() != null) {
                                Kontroler.getInstance().vratiRezultateTrkeFDodajRezultate(o);
                            }
                            if (Kontroler.getInstance().getTrkeForm() != null) {
                                Kontroler.getInstance().vratiRezultateTrkeFTrke(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_VOZACA:
                        if (o.getStatus() == Status.OK) {
                            if (Kontroler.getInstance().getVozaciForm() != null) {
                                Kontroler.getInstance().getRezultatiVozacaFVozac(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_REZULTATE_TIMA:
                        if (o.getStatus() == Status.OK) {
                            if (Kontroler.getInstance().getTimoviForm() != null) {
                                Kontroler.getInstance().getRezultatiTimaFTim(o);
                            }
                        }
                        break;

                    case Operacija.VRATI_VOZILA:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setVozila((ArrayList<Vozilo>) o.getPodaci());
                            if (Kontroler.getInstance().getVozilaForma() != null) {
                                Kontroler.getInstance().setTabelaVozila(o);
                            }
                        }
                        break;
                    case Operacija.SACUVAJ_TIM:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().getTimovi().add((Tim) o.getPodaci());
                        }
                        Kontroler.getInstance().sacuvanTim(o);
                        break;

                    case Operacija.SACUVAJ_VOZILO:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().getVozila().add((Vozilo) o.getPodaci());
                        }
                        Kontroler.getInstance().sacuvanoVozilo(o);
                        break;

                    case Operacija.SACUVAJ_VOZACA:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().getVozaci().add((Vozac) o.getPodaci());
                        }
                        Kontroler.getInstance().sacuvanVozac(o);
                        break;

                    case Operacija.SACUVAJ_TRKU:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().getTrke().add((Trka) o.getPodaci());
                        }
                        Kontroler.getInstance().sacuvanaTrka(o);

                        break;

                    case Operacija.SACUVAJ_REZULTATE_TRKE:
                        if (o.getStatus() == Status.OK) {
                        }
                        Kontroler.getInstance().sacuvaniRez(o);
                        break;

                    case Operacija.IZMENI_TRKU:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setTrke((ArrayList<Trka>) o.getPodaci());
                        }
                        Kontroler.getInstance().izmenjenaTrka(o);
                        break;

                    case Operacija.IZMENI_TIM:
                        if (o.getStatus() == Status.OK) {
                            Kontroler.getInstance().setTimovi((ArrayList<Tim>) o.getPodaci());
                        }
                        Kontroler.getInstance().izmenjenTim(o);
                        break;

                    case Operacija.IZBRISI_TRKU:
                        Kontroler.getInstance().izbrisanaTrka(o);
                        break;

                    case Operacija.IZBRISI_VOZILO:
                        Kontroler.getInstance().izbrisanoVozilo(o);
                        break;

                    case Operacija.VRATI_SVE_REZULTATE:
                        if (o.getStatus() == Status.OK) {
                            if (Kontroler.getInstance().getTabelaForm()!= null) {
                                Kontroler.getInstance().getSviRezultatiFStatistika(o);
                            }
                        }
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
