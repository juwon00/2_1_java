import java.applet.Applet;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock2 extends Applet implements Runnable {
    int timeInteval = 1000;
    public void dc2start(){ new Thread(this).start();}
    public  void run(){
        while (true){
            try{
                repaint();
                Thread.sleep(timeInteval);
            } catch (Exception e) {}
        }
    }
    public void paint(Graphics g){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormatter = DateFormat.getTimeInstance();
        g.drawString(dateFormatter.format(date), 0, 10);
    }
}
