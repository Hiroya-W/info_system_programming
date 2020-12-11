import java.sql.*;

public class UpdTest {
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

    public String next() {
        String res = null;

        try {
            if (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                res = "sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return res;
        }
    }

    public static void main(String[] args) {
        UpdTest db = new UpdTest();
        String sqlstr;
        String res;

        db.open("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");

        // データ挿入
        sqlstr = "INSERT INTO Student VALUES('00000004', '長沢利伸', '新潟県', 42)";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        // データの検索
        sqlstr = "SELECT * FROM Student WHERE sno = '00000004'";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        res = db.next();
        System.out.println(res);
        // データの更新
        sqlstr = "UPDATE Student SET address='島根県' WHERE sno = '00000004'";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        // データの検索
        sqlstr = "SELECT * FROM Student WHERE sno = '00000004'";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        res = db.next();
        System.out.println(res);

        db.close();
    }
}
