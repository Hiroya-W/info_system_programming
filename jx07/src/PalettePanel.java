import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalettePanel extends JPanel {
    CtlPanel ctlPanel = null;
    ColorPanel colorPanel = null;

    public PalettePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));

        // 制御ボタンのパネル
        ctlPanel = new CtlPanel(200, 200);
        // カラーパレットのパネル
        colorPanel = new ColorPanel(200, 200);
        add(colorPanel);
        add(ctlPanel);
    }

    // 描画パネルのインスタンスを渡す
    public void setOverlayedPanel(OverlayedPanel inst) {
        ctlPanel.op = inst;
        colorPanel.op = inst;
    }
}

class CtlPanel extends JPanel implements ActionListener {
    OverlayedPanel op = null;
    String[] ctl_labels = {"保存", "クリア", "終了"};

    // 制御ボタン用パネル
    public CtlPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(new LineBorder(Color.BLACK, 1));
        // ボタンを配置
        for (String label : ctl_labels) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(width-3, 40));
            Button btn = new Button(label);
            btn.setPreferredSize(new Dimension((int) (width*0.8), 30));
            btn.addActionListener(this);
            btn.setActionCommand(label);
            p.add(btn);
            add(p);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        // 各ボタンごとの機能
        if("保存".equals(cmd)){
            op.saveImage();
        }
        else if ("クリア".equals(cmd)) {
            op.imageClear();
        } else if ("終了".equals(cmd)) {
            System.exit(0);
        }
    }
}

class ColorPanel extends JPanel implements ActionListener {
    OverlayedPanel op = null;
    // 利用可能な色の一覧
    Color[] color_list = {
            Color.WHITE,
            Color.LIGHT_GRAY,
            Color.GRAY,
            Color.DARK_GRAY,
            Color.BLACK,
            Color.RED,
            Color.PINK,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN,
            Color.BLUE
    };

    public ColorPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(new LineBorder(Color.BLACK, 1));
        JLabel l = new JLabel("カラーパレット");
        l.setPreferredSize(new Dimension(width,30));
        l.setHorizontalAlignment(JLabel.CENTER);
        add("Center",l);

        // 色選択ボタンを配置
        for (Color color : color_list) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(30, 30));
            Button btn = new Button("   ");
            btn.setBackground(color);
            btn.addActionListener(this);
            btn.setActionCommand(color.toString());
            p.add(btn);
            add(p);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        // 各ボタンの色にセットする
        for (Color color : color_list) {
           if(color.toString().equals(cmd)){
               op.setColor(color);
           }
        }
    }
}
