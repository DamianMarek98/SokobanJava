import javafx.application.Platform;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Panel extends JPanel {
    private int wysokosc, szerokosc;

    private BufferedImage cel, postac, pustePole, sciana, skrzynia;

    public Plansza plansza;

    public Panel(int x, int y, Plansza plansza){
        this.wysokosc=x;
        this.szerokosc=y;
        this.plansza = plansza;
        setPreferredSize(new Dimension(900, 600));
        setVisible(true);
        File celGrafika = new File("src\\Grafika\\cel.bmp");
        File postacGrafika = new File("src\\Grafika\\postac.bmp");
        File pustePoleGrafika = new File("src\\Grafika\\puste.bmp");
        File scianaGrafika = new File("src\\Grafika\\sciana.bmp");
        File skrzyniaGrafika = new File("src\\Grafika\\skrzynia.bmp");

        try{
            cel = ImageIO.read(celGrafika);
            postac = ImageIO.read(postacGrafika);
            pustePole = ImageIO.read(pustePoleGrafika);
            sciana = ImageIO.read(scianaGrafika);
            skrzynia = ImageIO.read(skrzyniaGrafika);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int pozycjaX = ((900-(36*(plansza.x)))/2)+18, pozycjaY = 50;
        for (int i = 0; i < plansza.x; i++) {
            for (int j = 0; j < plansza.y; j++) {
                if(plansza.plansza[i][j] == 0){
                    g2d.drawImage(pustePole, pozycjaX, pozycjaY, this);
                } else if(plansza.plansza[i][j] == 1) {
                    g2d.drawImage(sciana, pozycjaX, pozycjaY, this);
                } else if(plansza.plansza[i][j] == 2) {
                    g2d.drawImage(skrzynia, pozycjaX, pozycjaY, this);
                } else if(plansza.plansza[i][j] == 3) {
                    g2d.drawImage(postac, pozycjaX, pozycjaY, this);
                } else if(plansza.plansza[i][j] == 4) {
                    g2d.drawImage(cel, pozycjaX, pozycjaY, this);
                }
                pozycjaX += 36;
            }
            pozycjaX = ((900-(36*(plansza.x)))/2)+18;
            pozycjaY += 36;
        }
        if(plansza.sprawdzCzyWygrana()){
            g.drawString("Wygrano w: "+ plansza.tura + " turach!", 410, 22);
        } else {
            g.drawString("Tura: "+ plansza.tura, 430, 22);
            g.drawString("Poziom: "+ plansza.nazwaPlanszy.substring(4,5), 430, 35);
        }
    }
}
