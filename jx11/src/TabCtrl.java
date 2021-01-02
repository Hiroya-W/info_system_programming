import javax.swing.table.DefaultTableModel;

public class TabCtrl {
    private TabModel mdl;

    public TabCtrl() {
        this.mdl = new TabModel();
    }

    public void search(String data, DefaultTableModel tm){
        mdl.search(data, tm);
    }
}
