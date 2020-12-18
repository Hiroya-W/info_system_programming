import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

class DbSel {
    Connection con;
    Statement st;
    ResultSet rs;

    public void open(String dbfile) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + dbfile);
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeQuery(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void print(Selall inst) {
        try {
            // 検索されたタプルを繰り返し処理する
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
                inst.add(new String[]{sno, sname, address, Integer.toString(age)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Selall extends JFrame {
    DefaultTableModel tm;
    JTable tb;
    JScrollPane sp;

    Selall(String[] argColNames) {
        getContentPane().setLayout(new FlowLayout());

        String[] colNames = argColNames.clone();

        // カラム名だけの表を作成する(データは空のものを渡す)
        tm = new DefaultTableModel(new String[][]{}, colNames);
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(300, 200));
        getContentPane().add(sp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Selall");
        setSize(250, 120);
    }

    public void add(String[] row) {
        tm.addRow(row);
    }

    public static void main(String[] args) {
        Selall obj = new Selall(new String[]{"sno", "sname", "address", "age"});
        DbSel db = new DbSel();
        String sqlstr;

        db.open("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");

        sqlstr = "SELECT * FROM Student";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        db.print(obj);
        db.close();

        obj.pack();
        obj.setVisible(true);
    }
}