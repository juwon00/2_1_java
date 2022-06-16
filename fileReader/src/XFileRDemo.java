import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class XFileRDemo extends JFrame implements ActionListener {
    JTextArea tarea;
    JButton loadbtn;
    JButton savebtn;
    JFileChooser fchooser;

    public XFileRDemo(){
        super("Lab.X File Reader/Writer");
//        JPanel panel = new JPanel();
//        loadbtn = new JButton("Load");
//        loadbtn.addActionListener(this);
//        panel.add(loadbtn);


        tarea = new JTextArea(10, 50);
        JScrollPane spane = new JScrollPane(tarea);
        getContentPane().add(spane, "Center");
        tarea.setBackground(new Color(220, 255, 255));
        pack();
        tarea.setMargin(new Insets(5,5,5,5));

        loadbtn = new JButton("Load");
        loadbtn.addActionListener(this);
        JPanel pan = new JPanel();
        pan.add(loadbtn);
        savebtn = new JButton("Save");
        savebtn.addActionListener(this);
        pan.add(savebtn);
        getContentPane().add(pan, "South");

        FileNameExtensionFilter fxfilter = new FileNameExtensionFilter(
                "Text Files: txt,java", "txt", "java");
        fchooser = new JFileChooser();
        fchooser.setFileFilter(fxfilter);

        setSize(500, 400);
        setVisible(true);
    }

    public static void main (String[] args){
        new XFileRDemo();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loadbtn){
            int fc_result = fchooser.showOpenDialog(tarea);
            if(fc_result == JFileChooser.APPROVE_OPTION){
                File file = fchooser.getSelectedFile();
                System.out.println("File name" + file.getName());
                try{
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    tarea.setText("");
                    String line;
                    while ((line = br.readLine()) != null)
                        tarea.append(line + "\n");
                    br.close();
                }catch (IOException ex) {}
            }
        }
        else {
            int fc_result = fchooser.showOpenDialog(tarea);
            if(fc_result == JFileChooser.APPROVE_OPTION){
                File file = fchooser.getSelectedFile();
                System.out.println("Save name as" + file.getName());
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(tarea.getText());
                    bw.flush();
                    bw.close();
                }catch (IOException ex) {}
            }
        }
    }
}
