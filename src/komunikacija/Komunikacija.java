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
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Srdjan
 */
public class Komunikacija {
    
    public static Komunikacija instance;
    
    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public static Zahtev primiZahtev(Socket s) {
        Zahtev z = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            z = (Zahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            
        }
        return z;
    }

    public static void posaljiOdgovor(Odgovor o, Socket s) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
        } catch (IOException ex) {
            
        }
    }
}
