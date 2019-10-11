/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import util.SettingsLoader;

/**
 *
 * @author Srdjan
 */
public class DBKonekcija {

    private final Connection conn;
    private static DBKonekcija instance;

    private DBKonekcija() throws Exception {
        conn = DriverManager.getConnection(SettingsLoader.getInstance().getValue("url"),
                SettingsLoader.getInstance().getValue("user"),
                SettingsLoader.getInstance().getValue("password"));
    }

    public static DBKonekcija getInstance() throws Exception {
        if (instance == null) {
            instance = new DBKonekcija();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static void resetInstance() throws Exception{
        instance = new DBKonekcija();
    }
}
