

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PictureForm {
    private JPanel mainPanel;
    private JSpinner radiusSpinner;
    private JTextField areaField;
    private CanvasPanel canvasPanel;

    public PictureForm() {
        SpinnerModel value = new SpinnerNumberModel(20, 1, 30, 1);
        radiusSpinner.setValue(value);
        radiusSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int radius = (int)radiusSpinner.getValue();
                canvasPanel.setRadius(radius);
                double area = Math.PI*radius*radius;
                areaField.setText(String.format("%.2f",area));
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Окружность");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

