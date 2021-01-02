import java.sql.*;

public class SelallDB {
    Connection con;
    Statement st;
    ResultSet rs;

    // クエリ
    public void executeQuery(String sql) {
        System.out.println(sql);
        try {
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // テーブルStudentのタプル数を返却する．
    public int getNdata() {
        String sql = "SELECT count(*) FROM Student";
        executeQuery(sql);
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    // 自分自身のメソッドgetNdata()を用いてテーブルStudentのタプル数nrowを求め，String[nrow][4]の２次元配列rowsを作成し，rowsにテーブルStudentの情報を設定し，rowsを返却する．
    public String[][] getData() {
        int nrow = getNdata();
        int ncount = 0;
        String sql = "SELECT * FROM Student";
        executeQuery(sql);

        String[][] rows = new String[nrow][4];
        try {
            // 検索されたタプルを繰り返し処理する
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
                rows[ncount][0] = sno;
                rows[ncount][1] = sname;
                rows[ncount][2] = address;
                rows[ncount][3] = Integer.toString(age);
                ncount++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }

    // dbfileで指定されたデータベースをオープンする．
    public void open(String dbfile) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + dbfile);
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // オープン中のデータベースをクローズする．
    public void close() {
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
