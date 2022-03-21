import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener {
    private Dice die;
    public Main() {
        super("Super-puper Dice");
        initComponents();
        setSize(500, 500);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 250,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents() {
        die = new Dice();
        JButton[] buttons = new JButton[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(Integer.toString(i + 1));
        }
        setLayout(null);
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setBounds((80 * i) + 5, 5, 80, 50);
        }
        add(die);
    }
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(e.getActionCommand());
        die.changeDieFace(num);
    }
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}