/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Drzava;
import domen.Rezultat;
import domen.Staza;
import domen.Tim;
import domen.Trka;
import domen.Vozac;
import domen.Vozilo;
import forme.glavna.FGlavna;
import forme.login.FLogin;
import forme.statistika.FStatistika;
import forme.timovi.FDodajTim;
import forme.timovi.FIzmeniTim;
import forme.timovi.FTimovi;
import forme.timovi.FVozila;
import forme.trke.FDodajRezultate;
import forme.trke.FDodajTrku;
import forme.trke.FIzmeniTrku;
import forme.trke.FObrisiTrku;
import forme.trke.FTrke;
import forme.vozaci.FDodajVozaca;
import forme.vozaci.FIzmeniVozaca;
import forme.vozaci.FVozaci;
import java.util.ArrayList;
import transfer.Odgovor;

/**
 *
 * @author Srdjan
 */
public class Kontroler {

    private static Kontroler instanca;

    private FLogin loginForm;
    private FGlavna glavnaForm;
    private FStatistika tabelaForm;
    private FTimovi timoviForm;
    private FTrke trkeForm;
    private FVozaci vozaciForm;
    private FIzmeniTrku izmeniTrkuForma;
    private FDodajTrku dodajTrkuForma;
    private FObrisiTrku obrisiTrkuForma;
    private FDodajRezultate dodajRezultateForma;
    private FDodajTim dodajTimForma;
    private FIzmeniTim izmeniTimForma;
    private FVozila vozilaForma;
    private FDodajVozaca dodajVozacaForma;
    private FIzmeniVozaca izmeniVozacaForma;

    private ArrayList<Drzava> drzave;
    private ArrayList<Tim> timovi;
    private ArrayList<Vozac> vozaci;
    private ArrayList<Trka> trke;
    private ArrayList<Staza> staze;
    private ArrayList<Vozilo> vozila;

    private Kontroler() {
        drzave = new ArrayList<>();
        timovi = new ArrayList<>();
        vozaci = new ArrayList<>();
        staze = new ArrayList<>();
        trke = new ArrayList<>();
        vozila = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public FLogin getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(FLogin loginForm) {
        this.loginForm = loginForm;
    }

    public FGlavna getGlavnaForm() {
        return glavnaForm;
    }

    public void setGlavnaForm(FGlavna glavnaForm) {
        this.glavnaForm = glavnaForm;
    }

    public FStatistika getTabelaForm() {
        return tabelaForm;
    }

    public void setTabelaForm(FStatistika tabelaForm) {
        this.tabelaForm = tabelaForm;
    }

    public FTimovi getTimoviForm() {
        return timoviForm;
    }

    public void setTimoviForm(FTimovi timoviForm) {
        this.timoviForm = timoviForm;
    }

    public FTrke getTrkeForm() {
        return trkeForm;
    }

    public void setTrkeForm(FTrke trkeForm) {
        this.trkeForm = trkeForm;
    }

    public FVozaci getVozaciForm() {
        return vozaciForm;
    }

    public void setVozaciForm(FVozaci vozaciForm) {
        this.vozaciForm = vozaciForm;
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }

    public ArrayList<Tim> getTimovi() {
        return timovi;
    }

    public void setTimovi(ArrayList<Tim> timovi) {
        this.timovi = timovi;
    }

    public ArrayList<Vozac> getVozaci() {
        return vozaci;
    }

    public void setVozaci(ArrayList<Vozac> vozaci) {
        this.vozaci = vozaci;
    }

    public FIzmeniTrku getIzmeniTrkuForma() {
        return izmeniTrkuForma;
    }

    public void setIzmeniTrkuForma(FIzmeniTrku izmeniTrkuForma) {
        this.izmeniTrkuForma = izmeniTrkuForma;
    }

    public FDodajTrku getDodajTrkuForma() {
        return dodajTrkuForma;
    }

    public void setDodajTrkuForma(FDodajTrku dodajTrkuForma) {
        this.dodajTrkuForma = dodajTrkuForma;
    }

    public ArrayList<Trka> getTrke() {
        return trke;
    }

    public void setTrke(ArrayList<Trka> trke) {
        this.trke = trke;
    }

    public ArrayList<Staza> getStaze() {
        return staze;
    }

    public void setStaze(ArrayList<Staza> staze) {
        this.staze = staze;
    }

    public ArrayList<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(ArrayList<Vozilo> vozila) {
        this.vozila = vozila;
    }

    public FObrisiTrku getObrisiTrkuForma() {
        return obrisiTrkuForma;
    }

    public void setObrisiTrkuForma(FObrisiTrku obrisiTrkuForma) {
        this.obrisiTrkuForma = obrisiTrkuForma;
    }

    public FDodajRezultate getDodajRezultateForma() {
        return dodajRezultateForma;
    }

    public void setDodajRezultateForma(FDodajRezultate dodajRezultateForma) {
        this.dodajRezultateForma = dodajRezultateForma;
    }

    public FDodajTim getDodajTimForma() {
        return dodajTimForma;
    }

    public void setDodajTimForma(FDodajTim dodajTimForma) {
        this.dodajTimForma = dodajTimForma;
    }

    public FIzmeniTim getIzmeniTimForma() {
        return izmeniTimForma;
    }

    public void setIzmeniTimForma(FIzmeniTim izmeniTimForma) {
        this.izmeniTimForma = izmeniTimForma;
    }

    public FVozila getVozilaForma() {
        return vozilaForma;
    }

    public void setVozilaForma(FVozila vozilaForma) {
        this.vozilaForma = vozilaForma;
    }

    public FDodajVozaca getDodajVozacaForma() {
        return dodajVozacaForma;
    }

    public void setDodajVozacaForma(FDodajVozaca dodajVozacaForma) {
        this.dodajVozacaForma = dodajVozacaForma;
    }

    public FIzmeniVozaca getIzmeniVozacaForma() {
        return izmeniVozacaForma;
    }

    public void setIzmeniVozacaForma(FIzmeniVozaca izmeniVozacaForma) {
        this.izmeniVozacaForma = izmeniVozacaForma;
    }

    public void setTabelaTrkaIzmena(Odgovor o) {
        izmeniTrkuForma.postaviModel(o);
    }

    public void setComboFDodajTrku(Odgovor o) {
        dodajTrkuForma.popuniKomboStaze(o);
    }

    public void setTabelaTrkaObrisi(Odgovor o) {
        obrisiTrkuForma.postaviModel(o);
    }

    public void setComboDrzaveFDodajTim(Odgovor o) {
        dodajTimForma.popuniKomboDrzave(o);
    }

    public void setComboDrzaveFDodajVozaca(Odgovor o) {
        dodajVozacaForma.popuniKomboDrzave(o);
    }

    public void setComboTimoviFVozila(Odgovor o) {
        vozilaForma.popuniKomboTimovi(o);
    }

    public void setComboTimoviFDodajVozaca(Odgovor o) {
        dodajVozacaForma.popuniKomboTimove(o);
    }

    public void setTabelaVozila(Odgovor o) {
        vozilaForma.ubaciVozilaUTabelu(o);
    }

    public void osveziModelVozila() {
        vozilaForma.osveziModel(vozila);
    }

    public void setTabelaVozacIzmena(Odgovor o) {
        izmeniVozacaForma.postaviModel(o);
    }

    public void setComboTimoviFIzmeniVozaca(Odgovor o) {
        izmeniVozacaForma.popuniKomboTimove(o);
    }

    public void setComboVozaciFDodajRezultate(Odgovor o) {
        dodajRezultateForma.popuniKomboVozace(o);
    }

    public void setTabelaTrkaFDodajRezultate(Odgovor o) {
        dodajRezultateForma.postaviModel(o);
    }

    public void vratiRezultateTrkeFDodajRezultate(Odgovor o) {
        dodajRezultateForma.vratiRezultateTrke(o);
    }

    public void vratiRezultateTrkeFTrke(Odgovor o) {
        trkeForm.prikaziRezultateTrke(o);
    }

    public void vratiTrkeFTrke(Odgovor o) {
        trkeForm.postaviModel(o);
    }

    public void getVozaciFVozac(Odgovor o) {
        vozaciForm.postaviModel(o);
    }

    public void getRezultatiVozacaFVozac(Odgovor o) {
        vozaciForm.prikaziRezultateVozaca(o);
    }

    public void getRezultatiTimaFTim(Odgovor o) {
        timoviForm.prikaziRezultateTima(o);
    }

    public void setTimoviFTim(Odgovor o) {
        timoviForm.postaviModel(o);
    }

    public void getVozaciTimaFTim(Odgovor o) {
        timoviForm.prikaziVozaceTima(o);
    }

    public void setTimoviFIzmeniTim(Odgovor o) {
        izmeniTimForma.postaviModel(o);
    }

    public void vratiError(Odgovor o) {

    }

    public void sacuvanaTrka(Odgovor o) {
        dodajTrkuForma.sacuvanaTrka(o);
    }

    public void sacuvaniRez(Odgovor o) {
        dodajRezultateForma.sacuvaniRez(o);
    }

    public void izmenjenaTrka(Odgovor o) {
        izmeniTrkuForma.izmenjenaTrka(o);
    }

    public void izmenjenTim(Odgovor o) {
        izmeniTimForma.izmenjenTim(o);
    }

    public void izbrisanaTrka(Odgovor o) {
        obrisiTrkuForma.obrisana(o);
    }

    public void izbrisanoVozilo(Odgovor o) {
        vozilaForma.obrisano(o);
    }

    public void sacuvanTim(Odgovor o) {
        dodajTimForma.sacuvan(o);
    }

    public void sacuvanoVozilo(Odgovor o) {
        vozilaForma.sacuvano(o);
    }

    public void sacuvanVozac(Odgovor o) {
        dodajVozacaForma.sacuvan(o);
    }

    public void getSviRezultatiFStatistika(Odgovor o) {
        tabelaForm.rezultatiVraceni(o);
    }

    public void getSviVozaciFStatistika(Odgovor o) {
        tabelaForm.vozaciVraceni(o);
    }

    public void getSviTimoviFStatistika(Odgovor o) {
        tabelaForm.timoviVraceni(o);
    }
}
