import java.sql.*;

public class SelTest {
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

    public void print() {
        try {
            // 検索されたタプルを繰り返し処理する
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SelTest db = new SelTest();
        String sqlstr;

        db.open("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");

        sqlstr = "SELECT * FROM Student";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        db.print();

        db.close();
    }
}
