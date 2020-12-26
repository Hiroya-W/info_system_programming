import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookView extends JFrame implements ActionListener {
    BookCtrl ctl;
    // 書名，著者名，出版社，ISBN
    String[] labels = {"Title", "Author", "Publisher", "ISBN"};
    // 登録，リスト表示、検索
    String[] btn_labels = {"Regist", "Show List", "Search"};
    JPanel registerPanel;
    DefaultTableModel tm;
    JTextField[] tf_array = new JTextField[4];

    public BookView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BookView");

        ctl = new BookCtrl();
        Container contentPane = getContentPane();

        // 本情報の登録パネル
        registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registerPanel.setBackground(Color.WHITE);
        registerPanel.setPreferredSize(new Dimension(240, 250));

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
            registerPanel.add(p);
            tf_array[i] = textField;
        }
        for (String label : btn_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(240, 30));
            Button btn = new Button(label);
            btn.addActionListener(this);
            btn.setActionCommand(label);
            p.add(btn);
            registerPanel.add(p);
        }
        contentPane.add("Center", registerPanel);

        //　本情報の表示パネル
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(600, 250));
        // 表形式で表示
        tm = new DefaultTableModel(null, labels);
        JTable table = new JTable(tm);
        JScrollPane scrollPane = new JScrollPane(table);
        infoPanel.add(scrollPane);

        contentPane.add("East", infoPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String[] bookinfo = {"", "", "", ""};

        for (int i = 0; i < tf_array.length; i++) {
            bookinfo[i] = tf_array[i].getText();
        }

        if (cmd.equals(btn_labels[0])) { // regist
            ctl.regist(bookinfo);
        } else if (cmd.equals(btn_labels[1])) { // show all
            ctl.showAll(tm);
        } else if (cmd.equals(btn_labels[2])) { // search
            ctl.search(bookinfo, tm);
        } else {
            System.out.println(cmd);
        }
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font", new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定
        BookView bv = new BookView();
        bv.pack();
        bv.setVisible(true);
    }
}
