import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabView extends JFrame {
    TabCtrl ctl;
    DefaultTableModel tm;

    public TabView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TabView");

        ctl = new TabCtrl();

        Container contentPane = getContentPane();

        InfoPanel infoPanel = new InfoPanel(600, 300);
        this.tm = infoPanel.tm;
        contentPane.add("East", infoPanel);

        InputPanel inputPanel = new InputPanel(300, 300);
        inputPanel.ctl = ctl;
        inputPanel.tm = tm;
        contentPane.add("Center", inputPanel);
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font", new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定
        TabView tv = new TabView();
        tv.pack();
        tv.setVisible(true);
    }
}

class InputPanel extends JPanel implements ActionListener {
    TabCtrl ctl;
    JTextField textField;
    DefaultTableModel tm;

    public InputPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("条件: ");
        label.setPreferredSize(new Dimension(width, 30));
        add(label);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(width - 10, 30));
        add(textField);

        JButton searchBtn = new JButton("検索");
        searchBtn.setPreferredSize(new Dimension(width - 30, 30));
        searchBtn.setActionCommand("検索");
        searchBtn.addActionListener(this);
        add(searchBtn);

        JButton exitBtn = new JButton("終了");
        exitBtn.setPreferredSize(new Dimension(width - 30, 30));
        exitBtn.setActionCommand("終了");
        exitBtn.addActionListener(this);
        add(exitBtn);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if ("検索".equals(cmd)) {
            ctl.search(textField.getText(), tm);
        } else if ("終了".equals(cmd)) {
            System.exit(0);
        }
    }
}

//　情報の表示パネル
class InfoPanel extends JPanel {
    String[] labels = {"sno", "sname", "address", "age"};
    DefaultTableModel tm;

    public InfoPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        // 表形式で表示
        tm = new DefaultTableModel(null, labels);
        JTable table = new JTable(tm);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}