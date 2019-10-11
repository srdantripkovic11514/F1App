/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Rezultat;
import domen.Tim;
import domen.Trka;
import domen.Vozac;
import domen.Vozilo;
import forme.FServer;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Srdjan
 */
public class Kontroler {

    private static Kontroler instance;
    private HashMap<String, Socket> klijenti;
    private static FServer serverForm;

    private Kontroler() {
        klijenti = new HashMap<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public HashMap<String, Socket> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(HashMap<String, Socket> klijenti) {
        this.klijenti = klijenti;
    }

    public FServer getServerForm() {
        return serverForm;
    }

    public void setServerForm(FServer serverForm) {
        this.serverForm = serverForm;
    }

    public void dodajKlijenta(String username, Socket soket){
        klijenti.put(username, soket);
    }
    
    public void izbrisiKlijenta(String username){
        klijenti.remove(username);
    }
    
    public void pokrenutServer(int port) {
        serverForm.serverPokrenut(port);
    }
    
    public void zaustavljenServer() {
        serverForm.serverZaustavljen();
    }
    
    public void povezanKlijent(String user) {
        serverForm.povezanKlijent(user);
    }
    
    public void klijentKraj(String user) {
        serverForm.klijentKraj(user);
    }
    
    public void appendError(String poruka){
        serverForm.appendError(poruka);
    }
    
    public void dodataTrka(String user, Trka trka){
        serverForm.dodataTrka(user, trka);
    }
    
    public void dodatVozac(String user, Vozac v){
        serverForm.dodatVozac(user, v);
    }
    
    public void dodatTim(String user, Tim t){
        serverForm.dodatTim(t, user);
    }
    
    public void dodatRezultat(String user, Rezultat r){
        serverForm.dodatiRezultati(user, r);
    }
    
    public void dodatoVozilo(String user, Vozilo v){
        serverForm.dodatoVozilo(user, v);
    }
    
    public void izmenjenTim(String user, Tim t){
        serverForm.izmenjenTim(user, t);
    }
    
    public void izmenjenaTrka(String user, Trka t){
        serverForm.izmenjenaTrka(user, t);
    }
    
    public void izmenjenVozac(String user, Vozac v){
        serverForm.izmenjenVozac(user, v);
    }
    
    public void izbrisiVozilo(String user, Vozilo v){
        serverForm.izbrisiVozilo(user, v);
    }
    
    public void izbrisiTrku(String user, Trka t){
        serverForm.izbrisiTrku(user, t);
    }

    public void greskaServer(int localPort) {
        serverForm.greskaServera(localPort);
    }
}
