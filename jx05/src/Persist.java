import java.io.*;

public class Persist {
    public static void main(String[] args) {
        boolean hasFinishedInput = false;

        try (BufferedReader buffKeyboard = new BufferedReader(new InputStreamReader(System.in))) {
            String buff_no = null;
            String buff_name = null;

            // 入力されたデータをファイルへ出力
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt"))) {
                while (!hasFinishedInput) {
                    // キーボードから入力
                    System.out.print("No: ");
                    buff_no = buffKeyboard.readLine();
                    if (buff_no.equals("q")) {
                        hasFinishedInput = true;
                        continue;
                    }
                    System.out.print("Name: ");
                    buff_name = buffKeyboard.readLine();

                    bufferedWriter.write(String.format("%s %s", buff_no, buff_name));
                    bufferedWriter.newLine();
                }
            }
            catch(IOException e){
                    System.out.println("Write Error");
            }
        } catch (IOException e) {
            System.out.println("Keyboard Input Error");
        }
    }
}
