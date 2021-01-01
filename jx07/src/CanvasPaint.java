import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CanvasPaint extends JPanel implements MouseListener {
    int pos_x, pos_y, old_pos_x, old_pos_y;
    Color color = Color.RED;
    String shape = "直線";

    public CanvasPaint() {
        addMouseListener(this);
    }

    public void drawClear() {
        Graphics g = this.getGraphics();
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        old_pos_x = mouseEvent.getX();
        old_pos_y = mouseEvent.getY();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Graphics g = this.getGraphics();
        g.setColor(color);
        pos_x = mouseEvent.getX();
        pos_y = mouseEvent.getY();
        if (shape.equals("直線")) {
            g.drawLine(old_pos_x, old_pos_y, pos_x, pos_y);
        } else if (shape.equals("四角形")) {
            int left_up_x = Math.min(pos_x, old_pos_x);
            int left_up_y = Math.min(pos_y, old_pos_y);
            g.drawRect(left_up_x, left_up_y, Math.abs(pos_x - old_pos_x), Math.abs(pos_y - old_pos_y));
        } else if (shape.equals("楕円")) {
            int left_up_x = Math.min(pos_x, old_pos_x);
            int left_up_y = Math.min(pos_y, old_pos_y);
            g.drawOval(left_up_x, left_up_y, Math.abs(pos_x - old_pos_x), Math.abs(pos_y - old_pos_y));
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
