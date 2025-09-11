package ex7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Koch extends JPanel {
    private int order = 3;         // change with +/- keys
    private int sign = +1;         // +1 = bump “outside”, -1 = inside (flip with space)

    public static void main(String[] args) {
        JFrame f = new JFrame("Koch with cos/sin");
        Koch panel = new Koch();
        f.add(panel);
        f.setSize(700, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        f.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') { panel.order++; panel.repaint(); }
                if (e.getKeyChar() == '-') { panel.order = Math.max(0, panel.order - 1); panel.repaint(); }
                if (e.getKeyChar() == ' ') { panel.sign *= -1; panel.repaint(); } // flip side of the bump
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();
        double side = 0.85 * Math.min(w, h);         // side length
        double H = side * Math.sqrt(3) / 2.0;        // height of equilateral
        double cx = w / 2.0, cy = h / 2.0 + H / 3.0; // center nicely

        // Equilateral triangle vertices
        double x1 = cx - side/2, y1 = cy;
        double x2 = cx + side/2, y2 = cy;
        double x3 = cx,           y3 = cy - H;

        // Draw three Koch sides
        koch(g, order, x1, y1, x2, y2);
        koch(g, order, x2, y2, x3, y3);
        koch(g, order, x3, y3, x1, y1);

        g.drawString("Order: " + order + "   (+/- to change, space to flip side)", 10, 20);
    }

    // Koch segment from (x1,y1) to (x2,y2) using rotation by ±60° with cos/sin
    private void koch(Graphics2D g, int k, double x1, double y1, double x2, double y2) {
        if (k == 0) {
            g.drawLine((int)Math.round(x1), (int)Math.round(y1),
                    (int)Math.round(x2), (int)Math.round(y2));
            return;
        }

        // 1) Points at 1/3 and 2/3
        double px = x1 + (x2 - x1) / 3.0;
        double py = y1 + (y2 - y1) / 3.0;
        double qx = x1 + 2.0*(x2 - x1) / 3.0;
        double qy = y1 + 2.0*(y2 - y1) / 3.0;

        // 2) Middle-third vector u = Q - P
        double ux = qx - px;
        double uy = qy - py;

        // 3) Rotate u by ±60° around P using cos/sin
        double theta = sign * Math.PI / 3.0; // ±60 degrees
        double cos = Math.cos(theta);
        double sin = Math.sin(theta);
        double rx = ux * cos - uy * sin;
        double ry = ux * sin + uy * cos;

        // Peak point C = P + rotated vector
        double cx = px + rx;
        double cy = py + ry;

        // 4) Recurse on the four sub-segments
        koch(g, k - 1, x1, y1, px, py);   // A -> P
        koch(g, k - 1, px, py, cx, cy);   // P -> C
        koch(g, k - 1, cx, cy, qx, qy);   // C -> Q
        koch(g, k - 1, qx, qy, x2, y2);   // Q -> B
    }
}
