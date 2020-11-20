import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalcView extends JFrame implements ActionListener {
    private CalcCtrl ctrl;
    private Container c;
    private Panel p_t, p_b;
    private JLabel l_eq, l_ans;
    private JButton b_calc, b_clear;
    private JTextField tf_oprand1, tf_oprator, tf_oprand2;

    public CalcView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 100);
        setTitle("CalcView");

        ctrl = new CalcCtrl();

        c = getContentPane();
        c.setLayout(new GridLayout(2, 1));

        p_t = new Panel();
        p_t.setLayout(new GridLayout(1, 5));
        p_b = new Panel();
        p_b.setLayout(new GridLayout(1, 2));

        l_eq = new JLabel(" = ");
        l_ans = new JLabel("");
        b_calc = new JButton("Calc");
        b_clear = new JButton("Clear");
        tf_oprand1 = new JTextField("",5);
        tf_oprator = new JTextField("",5);
        tf_oprand2 = new JTextField("",5);

        p_t.add(tf_oprand1);
        p_t.add(tf_oprator);
        p_t.add(tf_oprand2);
        p_t.add(l_eq);
        p_t.add(l_ans);

        p_b.add(b_calc);
        p_b.add(b_clear);

        c.add(p_t);
        c.add(p_b);

        b_calc.addActionListener(this);
        b_clear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_calc) {
            String op1 = tf_oprand1.getText();
            String op = tf_oprator.getText();
            String op2 = tf_oprand2.getText();
            int ans = ctrl.calc(op1,op,op2);
            l_ans.setText(Integer.toString(ans));
        } else if (e.getSource() == b_clear) {
            tf_oprand1.setText("");
            tf_oprator.setText("");
            tf_oprand2.setText("");
            l_ans.setText("");
        }
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font",new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font",new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font",new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定
        CalcView cv = new CalcView();

        cv.setVisible(true);
    }
}