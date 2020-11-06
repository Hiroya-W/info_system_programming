import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class Edic extends JFrame implements ActionListener {
    JTextField tf1;
    JButton bn1;
    JButton bn2;
    JButton bn3;
    JLabel l1;

    static HashMap<String, String> dic = new HashMap<>();

    Edic(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(240, 120);
        setTitle("MyForm3");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        tf1 = new JTextField("", 30);
        bn1 = new JButton("Translate");
        bn2 = new JButton("Clear");
        bn3 = new JButton("Quit");
        l1 = new JLabel("");

        c.add(tf1);
        c.add(bn1);
        c.add(bn2);
        c.add(bn3);
        c.add(l1);

        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bn1) {
            String str = tf1.getText();
            if (!dic.containsKey(str)) {
               l1.setText("Error.");
            } else {
                l1.setText(dic.get(str));
            }
        } else if (actionEvent.getSource() == bn2) {
            tf1.setText("");
            l1.setText("");
        }
        else if(actionEvent.getSource() == bn3){
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new FileReader("dic.txt"));) {
            String str_before;
            String str_after;
            str_before = buffReader.readLine();
            while (str_before != null) {
                str_after = buffReader.readLine();
                dic.put(str_before, str_after);
                str_before = buffReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Read Error");
        }

        Edic mf = new Edic();
        mf.setVisible(true);
    }
}
