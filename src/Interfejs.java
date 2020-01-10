import javax.swing.*;
import java.awt.event.*;

public class Interfejs extends JFrame implements ActionListener, KeyListener, MouseListener {

    private JPanel panel;

    private JFrame frame;

    protected int x,y;

    protected Plansza plansza;

    public Interfejs(int x, int y, Plansza plansza){
        this.x = x;
        this.y = y;
        this.plansza = plansza;
        panel = new Panel(x, y, plansza);

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            plansza.wykonajTure(Kierunek.GORA);
            panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            plansza.wykonajTure(Kierunek.DOL);
            panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            plansza.wykonajTure(Kierunek.PRAWO);
            panel.repaint();

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            plansza.wykonajTure(Kierunek.LEWO);
            panel.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
