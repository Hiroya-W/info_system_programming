import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintView extends JFrame implements ActionListener {
    JPanel selectPanel;

    CanvasPaint canvasPaint;

    // 直線、四角形、楕円、黒、赤、緑、クリア、終了
    String[] shape_labels = {"直線", "四角形", "楕円"};
    String[] color_labels = {"黒", "赤", "緑"};
    String[] ctl_labels = {"クリア", "終了"};

    public PaintView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PaintView");

//        ctl = new PaintCtrl();
        Container contentPane = getContentPane();

        // 選択パネル
        selectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        selectPanel.setBackground(Color.WHITE);
        selectPanel.setPreferredSize(new Dimension(240, 250));

        // 形選択ボタン
        JPanel shapePanel = new JPanel();
        shapePanel.setPreferredSize(new Dimension(240, 150));
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        shapePanel.setLayout(layout);

        for (String label : shape_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(240, 30));

            Button btn = new Button(label);
            btn.setPreferredSize(new Dimension(200, 25));
            btn.addActionListener(this);
            btn.setActionCommand(label);

            p.add(btn);
            shapePanel.add(p);
        }
        // 色選択ボタン
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(240, 40));
        for (String label : color_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(30, 30));
            Button btn = new Button(label);
            btn.addActionListener(this);
            btn.setActionCommand(label);
            p.add(btn);
            colorPanel.add(p);
        }
        // 制御選択ボタン
        JPanel ctlPanel = new JPanel();
        ctlPanel.setPreferredSize(new Dimension(240, 95));
        for (String label : ctl_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(110, 30));
            Button btn = new Button(label);
            btn.addActionListener(this);
            btn.setActionCommand(label);
            p.add(btn);
            ctlPanel.add(p);
        }

        selectPanel.add("Center", shapePanel);
        selectPanel.add("Center", colorPanel);
        selectPanel.add("Center", ctlPanel);
        contentPane.add("Center", selectPanel);

        //　描画領域パネル
        canvasPaint = new CanvasPaint();
        canvasPaint.setPreferredSize(new Dimension(300, 250));
        contentPane.add("East", canvasPaint);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // 形
        for (String label : shape_labels) {
            if (cmd.equals(label)) {
                canvasPaint.shape = cmd;
            }
        }

        // 色
        if (cmd.equals(color_labels[0])) { // 黒
            canvasPaint.color = Color.BLACK;
        } else if (cmd.equals(color_labels[1])) { // 赤
            canvasPaint.color = Color.RED;
        } else if (cmd.equals(color_labels[2])) { // 緑
            canvasPaint.color = Color.GREEN;
        }

        if (cmd.equals(ctl_labels[0])) { // クリア
            canvasPaint.drawClear();
        } else if (cmd.equals(ctl_labels[1])) { // 終了
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Linuxで実行した際に、読みにくいフォントで表示されてしまうため、フォントを変更しています
        UIManager.put("Button.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font", new Font("IPAPGothic", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font", new Font("IPAPGothic", Font.PLAIN, 12)); //TextFieldのフォント設定
        PaintView pv = new PaintView();
        pv.pack();
        pv.setVisible(true);
    }
}
