import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sw4TabbedPaneLab extends JFrame {

    public static void main (String args[]){
        new Sw4TabbedPaneLab();
    }

    Sw4TabbedPaneLab(){
        super("핵심 Java: TabbyPaneLab");
        JLabel cafe = new JLabel("핵심 Java 카페",SwingConstants.CENTER);
        getContentPane().add(cafe,"North");
        JTabbedPane tpane = new JTabbedPane(JTabbedPane.TOP);


        ImageIcon icon0 = new ImageIcon("icon-java.png");
        tpane.addTab("Java",null,new JLabel(icon0),"역시 Java.. 공부하자!");

        ImageIcon icon1 = new ImageIcon("image-cafe/cappuccino.JPG");
        tpane.addTab("Cappuccino",null,new JLabel(icon1),"따사로움을 찾...");

        ImageIcon icon2 = new ImageIcon("image-cafe/americano.JPG");
        tpane.addTab("Americano",null,new JLabel(icon2),"한잔의 여유를");

        ImageIcon icon3 = new ImageIcon("image-cafe/latte.jpg");
        tpane.addTab("Latte",null,new JLabel(icon3),"함께하는 낭만을!");


        JPanel pan = new JPanel(null);
        pan.setBackground(Color.WHITE);
        DrawingArea drawpan = new DrawingArea();
        pan.add(drawpan);
        tpane.addTab("my space",null,pan,"마음을 채우라!");
        tpane.setSelectedIndex(4);

        getContentPane().add(tpane,"Center");
        setSize(420,350);
        setVisible(true);
    }


    class DrawingArea extends JPanel implements MouseMotionListener{
        static int N = 50;
        int n = 0;
        private Point p1, p2;
        int xpoints[] = new int[N];
        int ypoints[] = new int[N];

        DrawingArea(){
            setBackground(Color.GRAY);
            setSize(420-40-20, 350-90-20);
            setLocation(20,10);
            addMouseMotionListener(this);
        }

        public void mouseMoved(MouseEvent e){}

        public void mouseDragged(MouseEvent e){
            p2= new Point(e.getX(),e.getY());
            if(n == 0){
                p1= p2;
                n=1;
                xpoints[0] = e.getX();
                ypoints[0] = e.getY();
            }
            if(n >= N)
                for (int i = 1; i < n; i++){
                    xpoints[i-1] = xpoints[i];
                    ypoints[i-1] = ypoints[i];
                }
            else n++;
            xpoints[n-1] = e.getX();
            ypoints[n-1] = e.getY();
            repaint();
        }

        public void paint (Graphics g){
            super.paint(g);
            if(n>1){
                int r = 20;
                r = (int) Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+Math.pow(p2.y - p1.y,2))*2;

                g.setColor(Color.RED);
                g.drawOval(p2.x-r, p2.y-r, r*2, r*2);
                p1 = p2;
                g.setColor(Color.BLUE);
                g.drawPolyline(xpoints, ypoints, n);
            }
        }
    }
}
