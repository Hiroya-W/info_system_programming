public class SelallCtrl {
    SelallDB db;

    public SelallCtrl() {
        db = new SelallDB();
    }

    // dbに設定されたオブジェクトに依頼してテーブルStudentの情報をStringの２次元配列の形式でもらい，それをそのまま返却する．
    public String[][] getData(){
        return db.getData();
    }

    // 修正、挿入、削除を行う
    public void update(String sql){
        db.executeUpdate(sql);
    }

    // dbfileで指定されたデータベースのオープンをdbに設定されたオブジェクトに依頼する．
    public void openDB(String dbfile){
        db.open(dbfile);
    }

    // オープン中のデータベースのクローズをdbに設定されたオブジェクトに依頼する．
    public void closeDB(){
        db.close();
    }
}
