import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm3 extends JFrame implements ActionListener {
    JTextField tf1;
    JButton bn1;
    JButton bn2;

    MyForm3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 100);
        setTitle("MyForm3");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        tf1 = new JTextField("", 24);
        bn1 = new JButton("Print");
        bn2 = new JButton("Clear");

        c.add(tf1);
        c.add(bn1);
        c.add(bn2);

        bn1.addActionListener(this);
        bn2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bn1) {
            System.out.println(tf1.getText());
        } else if (actionEvent.getSource() == bn2) {
            tf1.setText("");
        }
    }

    public static void main(String[] args) {
        MyForm3 mf = new MyForm3();
        mf.setVisible(true);
    }
}
