import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Plansza p1 = new Plansza(10,10);
        p1.wczytajPlanszeZPliku("pole1.txt");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfejs(20, 20, p1);
            }
        });

    }
}
