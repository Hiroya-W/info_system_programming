import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TabModel {
    public TabModel() {
    }

    public void search(String data, DefaultTableModel tm){
        DbSel2 db = new DbSel2();
        String sqlstr;

        db.open("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");

        sqlstr = "SELECT * FROM Student";
        if(!data.equals("")){
            sqlstr += " WHERE " + data;
        }

        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        db.print(tm);
        db.close();
    }
}

class DbSel2 {
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

    public void print(DefaultTableModel tm) {
        tm.setRowCount(0);
        try {
            // 検索されたタプルを繰り返し処理する
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
                tm.addRow(new String[]{sno, sname, address, Integer.toString(age)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
