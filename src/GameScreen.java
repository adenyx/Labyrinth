import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameScreen extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width / 3;
    private int height = screenSize.height / 3;
    private JRadioButton levelColorSilver = new JRadioButton("Silver");
    private JRadioButton levelColorGreen = new JRadioButton("Green");
    private JRadioButton levelColorRed = new JRadioButton("Red");
    private JButton startButton = new JButton("Start");
    public Container startScreen;

    public GameScreen() {
        super("Labyrinth");
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonGroup group = new ButtonGroup();
        group.add(levelColorSilver);
        group.add(levelColorGreen);
        group.add(levelColorRed);
        levelColorSilver.setSelected(true);

        startScreen = this.getContentPane();
        startScreen.setLayout(null);
        startScreen.setBackground(Color.WHITE);

        levelColorSilver.setBounds(width/3-30, height/3, 70, 20);
        startScreen.add(levelColorSilver);
        levelColorGreen.setBounds(width/2-35, height/3, 70, 20);
        startScreen.add(levelColorGreen);
        levelColorRed.setBounds(width/2+40, height/3, 70, 20);
        startScreen.add(levelColorRed);
        startButton.setBounds(width/2-35, height/3+40, 70,30);
        startScreen.add(startButton);
        startButton.addActionListener(new ButtonStartGameEventListener());
    }

    class ButtonStartGameEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (levelColorSilver.isSelected()) {
                ChangeLevelOnSilver();
                CloseButtonsToChagewindow();
            } else if (levelColorGreen.isSelected()) {
                ChangeLevelOnGreen();
                CloseButtonsToChagewindow();
            } else if (levelColorRed.isSelected()){
                ChangeLevelOnRed();
                CloseButtonsToChagewindow();
            } else {
                String errorRadiobutton = "Choose some variant!";
                JOptionPane.showMessageDialog(null, errorRadiobutton, "Attention", JOptionPane.PLAIN_MESSAGE);
            }
            String helpText = "Выберите место старта!";
            JOptionPane.showMessageDialog(null, helpText, "Help", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void CloseButtonsToChagewindow() {
        levelColorSilver.setVisible(false);
        levelColorGreen.setVisible(false);
        levelColorRed.setVisible(false);
        startButton.setVisible(false);
    }

    public void ChangeLevelOnSilver () {
        GameScreen.this.setSize(400, 400);
        startScreen.setBackground(Color.LIGHT_GRAY);
    }

    public void ChangeLevelOnGreen () {
        GameScreen.this.setSize(400, 400);
        startScreen.setBackground(Color.getHSBColor(0.210f, 0.6f, 1.0f));
    }

    public void ChangeLevelOnRed () {
        GameScreen.this.setSize(400, 400);
        startScreen.setBackground(Color.getHSBColor(0.0f, 0.6f, 1.0f));
    }
}
