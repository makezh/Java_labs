import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Dice extends JPanel {
    private static final int WIDTH = 170;
    private static final int HEIGHT = WIDTH;
    private static final int X = 160;
    private static final int Y = X;
    private int number;
    public Dice() {
        this.setBounds(X, Y, WIDTH, HEIGHT);
        this.setBackground(Color.gray);
        number = 1;
    }
    public void changeDieFace(int num) {
        number = num;
        repaint();
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        switch(number) {
            case 1:
                drawDot(g, WIDTH / 2, HEIGHT / 2);
                break;
            case 2:
                drawDot(g, WIDTH / 4, HEIGHT / 4);
                drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
                break;
            case 3:
                drawDot(g, WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 2, HEIGHT / 2);
                drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
                break;
            case 4:
                drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 4, HEIGHT / 4);
                drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
                drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
                break;
            case 5:
                drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 2, HEIGHT / 2);
                drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
                drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
                break;
            case 6:
                drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 4, HEIGHT / 4);
                drawDot(g, WIDTH / 4, HEIGHT / 2);
                drawDot(g, 3 * WIDTH / 4, HEIGHT / 2);
                drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
                drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
                break;
        }
    }
    private void drawDot(Graphics g, int x, int y) {
        int dot = 30;
        g.setColor(Color.black);
        g.fillOval(x - dot/2, y - dot/2, dot, dot);
    }
}