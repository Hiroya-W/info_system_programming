import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyDraw extends JPanel implements MouseListener {
    private int x1, x2, y1, y2;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("MyDraw");
        Container c = f.getContentPane();

        MyDraw md = new MyDraw();
        c.add(md);
        f.setVisible(true);
    }

    public MyDraw() {
        addMouseListener(this);
        x1 = -10;
        y1 = -10;
        x2 = -10;
        y2 = -10;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        x1 = mouseEvent.getX();
        y1 = mouseEvent.getY();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        x2 = mouseEvent.getX();
        y2 = mouseEvent.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
