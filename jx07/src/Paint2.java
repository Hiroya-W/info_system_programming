import javax.swing.*;
import java.awt.*;

public class Paint2 extends JFrame {
    public Paint2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("魔法陣　お絵描き");

        Container contentPane = getContentPane();
        // 絵描きパネル
        OverlayedPanel overlayedPanel = new OverlayedPanel(600, 600);
        // カラーパレットパネル
        PalettePanel palettePanel = new PalettePanel(200, 600);
        palettePanel.setOverlayedPanel(overlayedPanel);

        contentPane.add("Center", palettePanel);
        contentPane.add("East", overlayedPanel);
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font", new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定
        Paint2 paint = new Paint2();
        paint.pack();
        paint.setVisible(true);
    }
}
