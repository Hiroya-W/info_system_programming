import javax.swing.table.DefaultTableModel;

public class BookCtrl {
    private BookModel mdl;

    BookCtrl() {
        mdl = new BookModel();
    }

    public void regist(String[] data) {
        mdl.regist(data);
    }

    public void showAll(DefaultTableModel tm) {
        mdl.showAll(tm);
    }

    public void search(String[] data, DefaultTableModel tm) {
        mdl.search(data, tm);
    }
}
