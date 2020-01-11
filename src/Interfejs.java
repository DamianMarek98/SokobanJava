import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfejs extends JFrame implements ActionListener, KeyListener, MouseListener {

    private JPanel panel;

    protected int x,y;

    protected Plansza plansza;

    private JButton przyciskReset, przyciskPlansza1, przyciskPlansza2, przyciskPlansza3;

    public Interfejs(int x, int y, Plansza plansza){
        this.x = x;
        this.y = y;
        this.plansza = plansza;
        panel = new Panel(x, y, plansza);

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        stworzPrzyciski();
        setLocation(320,180);

        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void stworzPrzyciski(){
        przyciskReset = new JButton("Reset");
        przyciskReset.setBounds(270, 550, 90, 30);
        przyciskReset.addActionListener(this);
        przyciskReset.setVisible(true);
        przyciskPlansza1 = new JButton("Poziom 1");
        przyciskPlansza1.setBounds(370, 550, 90, 30);
        przyciskPlansza1.addActionListener(this);
        przyciskPlansza1.setVisible(true);
        przyciskPlansza2 = new JButton("Poziom 2");
        przyciskPlansza2.setBounds(470, 550, 90, 30);
        przyciskPlansza2.addActionListener(this);
        przyciskPlansza2.setVisible(true);
        przyciskPlansza3 = new JButton("Poziom 3");
        przyciskPlansza3.setBounds(570, 550, 90, 30);
        przyciskPlansza3.addActionListener(this);
        przyciskPlansza3.setVisible(true);
        przyciskReset.setFocusable(false);
        przyciskPlansza3.setFocusable(false);
        przyciskPlansza2.setFocusable(false);
        przyciskPlansza1.setFocusable(false);
        add(przyciskPlansza1);
        add(przyciskPlansza2);
        add(przyciskPlansza3);
        add(przyciskReset);
    }

    private void dodajPrzyciskiDoInterfejsu(){
        panel.add(przyciskPlansza1);
        panel.add(przyciskPlansza2);
        panel.add(przyciskPlansza3);
        panel.add(przyciskReset);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == przyciskPlansza1) {
            plansza.wczytajPlanszeZPliku("pole1.txt");
            panel.repaint();
            dodajPrzyciskiDoInterfejsu();
        } else if (source == przyciskPlansza2) {
            plansza.wczytajPlanszeZPliku("pole2.txt");
            panel.repaint();
            dodajPrzyciskiDoInterfejsu();
        } else if (source == przyciskPlansza3) {
            plansza.wczytajPlanszeZPliku("pole3.txt");
            panel.repaint();
            dodajPrzyciskiDoInterfejsu();
        } else if (source == przyciskReset) {
            plansza.restart();
            panel.repaint();
            dodajPrzyciskiDoInterfejsu();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!plansza.sprawdzCzyWygrana()) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                plansza.wykonajTure(Kierunek.GORA);
                panel.repaint();
                dodajPrzyciskiDoInterfejsu();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                plansza.wykonajTure(Kierunek.DOL);
                panel.repaint();
                dodajPrzyciskiDoInterfejsu();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                plansza.wykonajTure(Kierunek.PRAWO);
                panel.repaint();
                dodajPrzyciskiDoInterfejsu();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                plansza.wykonajTure(Kierunek.LEWO);
                panel.repaint();
                dodajPrzyciskiDoInterfejsu();
            }
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
