/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;
import javax.swing.JLabel;

/**
 *
 * @author FON
 */
public class NitTajmer extends Thread{
    
    JLabel lblClock;
    public NitTajmer(JLabel lblClock) {
        this.lblClock = lblClock;
    }

    @Override
    public void run() {
        LocalTime timeNow = LocalTime.now();
        while(!isInterrupted()){
            LocalTime time = LocalTime.now().minusHours(timeNow.getHour());
            time = time.minusMinutes(timeNow.getMinute());
            time = time.minusSeconds(timeNow.getSecond());
            time = time.minusNanos(timeNow.getNano());
            lblClock.setText(time.toString());
        }
        //lblClock.setText("00:00:00.000");
    }
    
    
}
