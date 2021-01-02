import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OverlayedPanel extends JPanel {
    BufferedImage image = null;
    Point prvPoint;
    Color color = Color.BLACK;

    // レイヤーの数
    int cnt_layer = 10;

    // http://asistobe851.web.fc2.com/my-memo/Overlayed.html
    public OverlayedPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK, 1));
        setOpaque(false);

        // ドラッグして線を引く
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point curPoint = e.getPoint();
                //　絵が無い時
                if (image == null) {
                    image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                }
                Graphics2D g2d = image.createGraphics();

                g2d.setStroke(new BasicStroke(2.0F));
                g2d.setPaint(color);
                g2d.drawLine(prvPoint.x, prvPoint.y, curPoint.x, curPoint.y);
                g2d.dispose();
                repaint();
                prvPoint = e.getPoint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prvPoint = e.getPoint();
            }
        });
    }

    // 指定した枚数だけ重ねて絵を描く
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double n = 360.0 / cnt_layer;
        if (image != null) {
            for (int i = 0; i < cnt_layer; i++) {
                BufferedImage rotate_image;
                rotate_image = rotateImageByDegrees(image, n * i);
                if (i % 2 == 0) {
                    // 偶数のときは回転させて配置
                    g.drawImage(rotate_image, 0, 0, this);
                } else {
                    // 奇数のときは、反転+回転させて配置
                    g.drawImage(rotate_image, rotate_image.getWidth(), 0, -rotate_image.getWidth(), rotate_image.getHeight(), this);
                }
            }
        }
    }

    // bufferedImageを回転させる
    // https://stackoverflow.com/questions/37758061/rotate-a-buffered-image-in-java/37758533
    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, img.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w / 2, h / 2);
        graphic.drawImage(img, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    // 線の色をセットする
    public void setColor(Color color) {
        this.color = color;
    }

    // 描いた絵を消す
    public void imageClear() {
        this.image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        repaint();
    }

    // 描いた絵を保存する
    public void saveImage() {
        try {
            if (image != null) {
                File outputfile = new File("saved.png");
                BufferedImage saveImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = saveImage.createGraphics();

                double n = 360.0 / cnt_layer;

                for (int i = 0; i < cnt_layer; i++) {
                    BufferedImage rotate_image;
                    rotate_image = rotateImageByDegrees(image, n * i);
                    if (i % 2 == 0) {
                        g2d.drawImage(rotate_image, 0, 0, this);
                    } else {
                        g2d.drawImage(rotate_image, rotate_image.getWidth(), 0, -rotate_image.getWidth(), rotate_image.getHeight(), this);
                    }
                }
                ImageIO.write(saveImage, "png", outputfile);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
