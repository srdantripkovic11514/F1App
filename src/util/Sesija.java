/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Srdjan
 */
public class Sesija {
    private static Sesija instance;
    private Map<String, Object> map;
    private Socket socket;

    private Sesija() {
        map = new HashMap<>();
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object remove(String key) {
        return map.remove(key);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket() throws IOException {
        socket = new Socket("localhost", 9000);
    }
    
    
}
