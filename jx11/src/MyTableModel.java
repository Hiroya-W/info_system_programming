import javax.swing.table.AbstractTableModel;

//https://java.keicode.com/lib/swing-jtable-2.php
@SuppressWarnings("serial")
class MyTableModel extends AbstractTableModel {

    Object[][] data = {};
    Object change_index = "";

    String[] columns = {"番号", "名前", "住所", "年齢"};

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object val, int rowIndex, int columnIndex) {
        // data[rowIndex][columnIndex] 変更前
        // 変更後 val
        System.out.println(data[rowIndex][columnIndex] + " " + val);

        change_index = data[rowIndex][0];

        data[rowIndex][columnIndex] = val;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return data[0][columnIndex].getClass();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }


    public void setData(Object[][] data) {
        this.data = data;
    }

}
