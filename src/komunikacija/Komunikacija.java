/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Srdjan
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket socket;

    private Komunikacija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket() throws IOException {
        socket = new Socket("localhost", 9000);
    }

    public void posaljiZahtev(Zahtev zahtev) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(zahtev);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Odgovor primiOdgovor() {
        Odgovor odg = new Odgovor();

        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            odg = (Odgovor) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return odg;
    }
}
