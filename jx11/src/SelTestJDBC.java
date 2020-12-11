import java.sql.*;

public class SelTestJDBC {
    public static void main(String[] args) {
        try {
            // ドライバクラスをロード
            Class.forName("org.sqlite.JDBC");
            // データベースに接続
            Connection con = DriverManager.getConnection("jdbc:sqlite:/home/hiroya/Documents/git-repos/info_system_programming/jx11/stock3.sqlite3");
            // ステートメントオブジェクトを生成
            Statement st = con.createStatement();
            // 全てのタプルを検索するSQL文を生成
            String sql = "SELECT * FROM Goods";
            // 問い合わせを実行して結果集合を取得
            ResultSet rs = st.executeQuery(sql);
            // 検索されたタプルを繰り返し処理する
            while (rs.next()) {
                // gnoを取得
                String gno = rs.getString("gno");
                // gnameを取得
                String gname = rs.getString("gname");
                // colorを取得
                String color = rs.getString("color");
                // priceを取得
                int price = rs.getInt("price");
                // 標準出力に表示
                System.out.println("gno:" + gno + " gname:" + gname + " color:" + color + " price:" + price);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
