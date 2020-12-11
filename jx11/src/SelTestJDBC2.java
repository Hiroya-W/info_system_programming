import java.sql.*;

public class SelTestJDBC2 {
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
                String gno = rs.getString("gno");
                String gname = rs.getString("gname");
                String color = rs.getString("color");
                int price = rs.getInt("price");
                System.out.println("gno:" + gno + " gname:" + gname + " color:" + color + " price:" + price);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String next() {
        String res = null;

        try {
            if (rs.next()) {
                String gno = rs.getString("gno");
                String gname = rs.getString("gname");
                String color = rs.getString("color");
                int price = rs.getInt("price");
                res = "gno:" + gno + " gname:" + gname + " color:" + color + " price:" + price;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return res;
        }
    }

    public static void main(String[] args) {
        SelTestJDBC2 db = new SelTestJDBC2();
        String sqlstr;
        String str;

        db.open("/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");

        sqlstr = "SELECT * FROM Goods";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        db.print();
        System.out.println();

        sqlstr = "SELECT price, color, gname, gno FROM Goods";
        System.out.println("SQL: " + sqlstr);
        db.executeQuery(sqlstr);
        str = db.next();
        while (str != null) {
            System.out.println(str);
            str = db.next();
        }

        db.close();
    }
}
