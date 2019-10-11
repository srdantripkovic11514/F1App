/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Korisnik;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import komunikacija.Komunikacija;
import kontroler.Kontroler;
import so.LoginSO;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Srdjan
 */
public class NitServer extends Thread {

    private ServerSocket ss;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(9000);
            Kontroler.getInstance().pokrenutServer(ss.getLocalPort());
            try {
                while (!isInterrupted()) {
                    Socket s = ss.accept();
                    boolean b = false;
                    Korisnik pom = null;
                    while (true) {
                        Zahtev z = Komunikacija.primiZahtev(s);
                        Odgovor o = new Odgovor();
                        Korisnik k = (Korisnik) z.getPodaci();
                        try {
                            o = new LoginSO().izvrsenjeSO(k);
                            o.setPoruka("true");
                            Kontroler.getInstance().povezanKlijent(o.getPodaci().toString());
                            Kontroler.getInstance().dodajKlijenta(o.getPodaci().toString(), s);
                            Komunikacija.posaljiOdgovor(o, s);
                            pom = k;
                            break;
                        } catch (Exception exception) {
                            o.setPoruka("Ne postoji korisnik sa tim parametrima");
                            Komunikacija.posaljiOdgovor(o, s);
                        }
                    }
                    if (pom == null) {
                        continue;
                    }
                    NitKlijentRad nk = new NitKlijentRad(s, pom.getUsername());
                    nk.start();
                }
            } catch (IOException ex) {

            }
        } catch (Exception ex) {
            Kontroler.getInstance().greskaServer(9000);
        }
    }

    public void zaustaviServer() {
        try {
            ss.close();
            //Kontroler.getInstance().zaustavljenServer();
        } catch (IOException ex) {

        }
    }

    public ServerSocket getSs() {
        return ss;
    }

}
