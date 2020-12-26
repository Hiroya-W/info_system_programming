import javax.swing.table.DefaultTableModel;
import java.io.*;

public class BookModel {
    public BookModel() {
    }

    public void search(String[] data, DefaultTableModel tm) {
        tm.setRowCount(0);
        try (BufferedReader buffReader = new BufferedReader(new FileReader("book.txt"));) {
            String str;
            str = buffReader.readLine();
            while (str != null) {
                String[] row = str.split(",", -1);
                boolean is_match = true;
                for (int i = 0; i < 4; i++) {
                    if (data[i].equals("")) {
                        continue;
                    }

                    if (!row[i].contains(data[i])) {
                        is_match = false;
                    }
                }
                if (is_match) {
                    tm.addRow(new String[]{row[0], row[1], row[2], row[3]});
                }
                str = buffReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Read Error");
        }
    }

    public void regist(String[] data) {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("book.txt", true));) {
            for (int i = 0; i < 4; i++) {
                buffWriter.write(data[i] + ",");
            }
            buffWriter.newLine();
        } catch (IOException e) {
            System.out.println("Write Error");
        }
    }

    public void showAll(DefaultTableModel tm) {
        tm.setRowCount(0);
        try (BufferedReader buffReader = new BufferedReader(new FileReader("book.txt"));) {
            String str;
            str = buffReader.readLine();
            while (str != null) {
                String[] row = str.split(",", -1);
                tm.addRow(new String[]{row[0], row[1], row[2], row[3]});
                str = buffReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Read Error");
        }
    }
}
