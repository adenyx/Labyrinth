import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

public class Functionality extends JPanel implements ActionListener {
    private boolean inGame;
    private int time = 150;
    private Image MARIO;
    public static int MARIO_SIZE = 32;
    public static int marioX = 150;
    public static int marioY = 150;
    private boolean right;
    private boolean up;
    private boolean left;
    private boolean down;

    public Functionality() {
        setBackground(Color.BLACK);
        startGame();
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }

    public void startGame() {
        loadImages();
        Timer timer = new Timer(time, this);
        timer.start();
        inGame = true;
    }

    public void loadImages() {
        ImageIcon iim = new ImageIcon("mario.png");
        MARIO = iim.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("DRAW!");
        if (inGame) {
            g.drawImage(MARIO, marioX, marioY, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Timer!");
        if (inGame) {
            move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_A){
                left = true;
                up = false;
                down = false;
                right = false;
            }
            if(key == KeyEvent.VK_D){
                right = true;
                up = false;
                down = false;
                left = false;
            }
            if(key == KeyEvent.VK_W){
                up = true;
                left = false;
                right = false;
                down = false;
            }
            if(key == KeyEvent.VK_S){
                down = true;
                left = false;
                right = false;
                up = false;
            }
        }
    }

    public void move() {
        if (right) {
            marioX += MARIO_SIZE;
        }
        if (up) {
            marioY -= MARIO_SIZE;
        }
        if (left) {
            marioX -= MARIO_SIZE;
        }
        if (down) {
            marioY += MARIO_SIZE;
        }
    }
}
