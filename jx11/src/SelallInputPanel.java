import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelallInputPanel extends JPanel implements ActionListener {
    // sna，sname，address, age，
    String[] labels = {"番号", "名前", "住所", "年齢"};
    JTextField[] tf_array = new JTextField[4];
    // 挿入
    String[] btn_labels = {"データを追加", "選択した行を削除"};

    public SelallInputPanel(int width, int height) {
        setPreferredSize(new Dimension(width,height));

        // 入力パネルを作成
        for (int i = 0; i < labels.length; i++) {
            JPanel p = new JPanel();
            SpringLayout layout = new SpringLayout();
            p.setLayout(layout);
            p.setPreferredSize(new Dimension(240, 30));

            JLabel l = new JLabel(labels[i] + ": ", JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField("", 10);
            textField.setName(labels[i]);
            l.setLabelFor(textField);
            p.add(textField);
            layout.putConstraint(SpringLayout.NORTH, l, 10, SpringLayout.NORTH, p);
            layout.putConstraint(SpringLayout.WEST, l, 10, SpringLayout.WEST, p);
            layout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, p);
            layout.putConstraint(SpringLayout.WEST, textField, 70, SpringLayout.WEST, l);
            add(p);
            tf_array[i] = textField;
        }
        for (String label : btn_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(240, 30));
            Button btn = new Button(label);
            btn.addActionListener(this);
            btn.setActionCommand(label);
            p.add(btn);
            add(p);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
