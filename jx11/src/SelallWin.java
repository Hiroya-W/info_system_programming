import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SelallWin extends JFrame {
    SelallCtrl ctrl;
    JScrollPane sp;
    JTable tb;
    DefaultTableModel tm;

    public SelallWin() {
        String[] colNames = new String[]{"sno", "sname", "address", "age"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SelallWin");

        ctrl = new SelallCtrl();

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        tm = new DefaultTableModel(new String[][]{}, colNames);
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(400, 300));
        contentPane.add(sp);
    }

    // ctrlに設定されたオブジェクトに依頼してテーブルStudentの情報を格納したStringの２次元配列を得る．
    public String[][] getData() {
        return ctrl.getData();
    }

    // テーブルStudentの情報を格納したStringの２次元配列dataをもらい，dataの値をテーブルに設定する．
    public void setData(String[][] data) {
        String[][] rows = getData();
        for (String[] row : rows) {
            System.out.println(row[0]+row[1]+row[2]+row[3]);
            tm.addRow(row);
        }
    }

    // dbfileで指定されたデータベースのオープンをctrlに設定されたオブジェクトに依頼する．
    public void openDB(String dbfile) {
        ctrl.openDB(dbfile);
    }

    // オープン中のデータベースのクローズをctrlに設定されたオブジェクトに依頼する．
    public void closeDB() {
        ctrl.closeDB();
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font", new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定

        SelallWin sw = new SelallWin();
        String[][] data;

        sw.openDB("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");
        data = sw.getData();
        sw.setData(data);
        sw.closeDB();
        sw.pack();
        sw.setVisible(true);
    }
}
