import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

class TableModelTest extends JFrame {
    DefaultTableModel tm;
    JTable tb;
    JScrollPane sp;

    TableModelTest() {
        getContentPane().setLayout(new FlowLayout());

        String[][] rowData = {};
/* String[][] rowData = { // 初期値を持つ場合
{ "A01", "B01", "C01" },
{ "A02", "B02", "C02" }
};*/
        String[] colNames = {"A", "B", "C"};

        tm = new DefaultTableModel(rowData, colNames);
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(230, 80));
        getContentPane().add(sp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TableModelTest");
        setSize(250, 120);
    }

    public void add(String[] row) {
        tm.addRow(row);
    }

    public static void main(String[] args) {
        TableModelTest obj = new TableModelTest();

        String[] r1 = {"A1", "B1", "C1"};
        obj.add(r1);
        String[] r2 = {"A2", "B2", "C2"};
        obj.add(r2);
        String[] r3 = {"A3", "B3", "C3"};
        obj.add(r3);
        String[] r4 = {"A4", "B4", "C4"};
        obj.add(r4);
        String[] r5 = {"A5", "B5", "C5"};
        obj.add(r5);

        obj.setVisible(true);
    }
}