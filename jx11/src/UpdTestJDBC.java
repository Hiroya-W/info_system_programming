import java.sql.*;

public class UpdTestJDBC {
    public static void main(String[] args) {
        try {
            // ドライバクラスをロード
            Class.forName("org.sqlite.JDBC");
            // データベースに接続
            Connection con = DriverManager.getConnection("jdbc:sqlite:/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");
            // ステートメントオブジェクトを生成
            Statement st = con.createStatement();
            // タプルの挿入
            st.executeUpdate("INSERT INTO Goods VALUES ('G2000', 'desk', 'white', 20000);");
            // タプルの修正
            st.executeUpdate("UPDATE Goods SET color = 'black' WHERE gno = 'G2000';");

            // データベースから切断
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}