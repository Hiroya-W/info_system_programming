import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;

// https://mrradiology.hatenablog.jp/entry/2020/03/05/095048
public class SelallWin extends JFrame implements TableModelListener {
    SelallCtrl ctrl;
    JScrollPane sp;
    JTable tb;

    MyTableModel tm;

    String mydbfile = "/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3";

    public SelallWin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SelallWin");

        ctrl = new SelallCtrl();

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
//        tm = new DefaultTableModel(new String[][]{}, colNames);
        tm = new MyTableModel();
        tm.addTableModelListener(this);
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(400, 300));

        SelallInputPanel panel = new SelallInputPanel(240, 250){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cmd = actionEvent.getActionCommand();
                if("データを追加".equals(cmd)){
                    String sql = "INSERT INTO Student VALUES(";
                    sql += "'" + tf_array[0].getText() + "',";
                    sql += "'" + tf_array[1].getText() + "',";
                    sql += "'" + tf_array[2].getText() + "',";
                    sql += "'" + tf_array[3].getText() + "');";

                    ctrl.openDB(mydbfile);
                    ctrl.update(sql);
                    String[][] data = ctrl.getData();
                    // 表示用の表のデータに登録
                    setData(data);
                    ctrl.closeDB();
                    // 表示を更新
                    tm.fireTableDataChanged();
                }
                else if("選択した行を削除".equals(cmd)){
                    String selected_sno = tb.getValueAt(tb.getSelectedRow(),0).toString();
                    String sql = "DELETE FROM Student WHERE sno = '" + selected_sno + "';";

                    ctrl.openDB(mydbfile);
                    ctrl.update(sql);
                    String[][] data = ctrl.getData();
                    // 表示用の表のデータに登録
                    setData(data);
                    ctrl.closeDB();
                    // 表示を更新
                    tm.fireTableDataChanged();
                }
            }
        };
        contentPane.add("Center", panel);
        contentPane.add("East", sp);
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        if (tableModelEvent.getColumn() != -1 && tableModelEvent.getFirstRow() != -1) {
            // 変更されたセルの場所の値(変更後)
            System.out.println(tb.getValueAt(tableModelEvent.getFirstRow(), tableModelEvent.getColumn()));
            String val = tb.getValueAt(tableModelEvent.getFirstRow(), tableModelEvent.getColumn()).toString();
            String sno = tm.change_index.toString();
            // タプルの修正
            String sql = "UPDATE Student SET ";
            switch (tableModelEvent.getColumn()) {
                case 0 -> sql += "sno = '" + val + "'";
                case 1 -> sql += "sname = '" + val + "'";
                case 2 -> sql += "address = '" + val + "'";
                case 3 -> sql += "age = '" + val + "'";
            }
            sql += " WHERE sno = '" + sno + "';";
            ctrl.openDB(mydbfile);
            ctrl.update(sql);
            ctrl.closeDB();
        }
    }

    // ctrlに設定されたオブジェクトに依頼してテーブルStudentの情報を格納したStringの２次元配列を得る．
    public String[][] getData() {
        return ctrl.getData();
    }

    // テーブルStudentの情報を格納したStringの２次元配列dataをもらい，dataの値をテーブルに設定する．
    public void setData(String[][] data) {
        String[][] rows = getData();
        System.out.println("Set Data");
        for (String[] row : rows) {
            System.out.println(row[0] + row[1] + row[2] + row[3]);
        }
        tm.setData(rows);
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

        sw.openDB(sw.mydbfile);
        data = sw.getData();
        sw.setData(data);
        sw.closeDB();
        sw.pack();
        sw.setVisible(true);
    }
}
