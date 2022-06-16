import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


public class SimplySlider extends JPanel implements  ChangeListener{
    JSlider js;
    public SimplySlider(int orient){
        js = new JSlider(orient, 0, 100, 25);
        js.setMajorTickSpacing(50);
        js.setPaintTicks(true);
        js.setMinorTickSpacing(10);
        js.setPaintLabels(true);
        js.addChangeListener(this);
        setLayout(new BorderLayout());
        add(js);
    }

    public void stateChanged (ChangeEvent e){
        System.out.println(((JSlider)e.getSource()).getValue());
    }

    public static void main(String[] args){
        JFrame jf = new JFrame("핵심 Java: SimplySlider");
        jf.getContentPane().add(new SimplySlider(JSlider.HORIZONTAL));
        jf.setSize(300,200);
        jf.setVisible(true);
    }


}

