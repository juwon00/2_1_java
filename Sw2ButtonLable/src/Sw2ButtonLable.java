import javax.swing.*;
import java.awt.event.*;


public class Sw2ButtonLable extends JFrame{

    JLabel label;
    ImageIcon iicon[];
    String btnActCmd[] = {"Yes", "No"};
    JButton btn[];


    Sw2ButtonLable(){

        super("멋진 제목");

        iicon = new ImageIcon[3];
        iicon[0] = new ImageIcon("reset.jpg");

        label = new JLabel(iicon[0]);
        getContentPane().add(label, "Center");


        MyButtonWorker blisner = new MyButtonWorker();
        System.out.println(blisner);


        JPanel pan = new JPanel();
        btn = new JButton[2];

        iicon[1] = new ImageIcon("yes.PNG");
        btn[0] = new JButton("Yes");
        btn[0].setActionCommand("Yes!");
        btn[0].addActionListener(blisner);
        pan.add(btn[0]);

        getContentPane().add(pan,"South");


        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

   class MyButtonWorker implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton jb = (JButton) e.getSource();
            System.out.println(jb.getActionCommand());
        }
   }

    public static void main(String[] args){
        new Sw2ButtonLable();
    }

}
//집에서 한거



//수업시간에 한거
/*
import javax.swing.*;
import java.awt.event.*;


public class Sw2ButtonLabel extends JFrame{

    JLabel label;
    ImageIcon iicon[];
    String btnActCmd[] = {"Yes","No"};
    JButton btn[];


    Sw2ButtonLabel(){
        super("제목");

        iicon = new ImageIcon[3];
        iicon[0] = new ImageIcon("reset.jpg");

        label = new JLabel(iicon[0]);
        getContentPane().add(label,"Center");


        MyButtonWorker blisner = new MyButtonWorker();
        System.out.println(blisner);


        JPanel pan = new JPanel();
        btn = new JButton[2];

        iicon[1] = new ImageIcon("yes.png");
        btn[0] = new JButton("Yes");
        btn[0].setActionCommand("Yes!");
        btn[0].addActionListener( blisner);
        pan.add(btn[0]);

        getContentPane().add(pan,"South");


        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    class MyButtonWorker implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton jb = (JButton) e.getSource();
            System.out.println(jb.getActionCommand());
        }
    }

    public static void main(String[] args) {
        new Sw2ButtonLabel();
    }



}
*/








