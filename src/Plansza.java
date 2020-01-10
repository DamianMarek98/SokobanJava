import Plansze.ElementPlanszy;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Plansza {
    protected int x, y;
    protected Integer[][] plansza;
    private int pozycjaGraczaX, pozycjaGraczaY;
    private int polePodGraczem = 0;
    public int tura = 0;

    public Plansza(int x, int y) {
        this.x = x;
        this.y = y;
        this.tura = 0;
        plansza = new Integer[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                plansza[i][j]=0; //puste pole
            }
        }
    }

    public void dodajObiekNaPlansze(int x, int y, int obiekt){
        plansza[x][y] = obiekt;
    }

    public Integer[][] getPlansza(){
        return plansza;
    }

    public void wykonajTure(Kierunek kierunek){
        tura++;
        if(kierunek == kierunek.GORA){
            plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
            pozycjaGraczaX--;
            polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
            plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
        }else if(kierunek == Kierunek.DOL){
            plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
            pozycjaGraczaX++;
            polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
            plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
        }else if(kierunek == Kierunek.PRAWO){
            plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
            pozycjaGraczaY++;
            polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
            plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
        }else if(kierunek == Kierunek.LEWO){
            plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
            pozycjaGraczaY--;
            polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
            plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
        }
        //sprawdzenie ruchu
    }

    public void wczytajPlanszeZPliku(String nazwaPliku){ //well coś nie działa
        try {
            Scanner odczyt = new Scanner(new File("src\\Plansze\\"+nazwaPliku));
            x = odczyt.nextInt();
            y = odczyt.nextInt();
            plansza = new Integer[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    plansza[i][j]=0; //puste pole
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    plansza[i][j] = odczyt.nextInt();
                    if(plansza[i][j] == 3){
                        pozycjaGraczaX = i;
                        pozycjaGraczaY = j;
                    }
                }
            }


            odczyt.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
