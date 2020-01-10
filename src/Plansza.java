import Plansze.ElementPlanszy;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Plansza {
    protected int x, y;
    protected Integer[][] plansza, bazowaPlansza;
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
                plansza[i][j] = 0; //puste pole
            }
        }
    }

    public void dodajObiekNaPlansze(int x, int y, int obiekt) {
        plansza[x][y] = obiekt;
    }

    public Integer[][] getPlansza() {
        return plansza;
    }

    public void wykonajTure(Kierunek kierunek) {
        tura++;
        if (sprawdzKolizje(kierunek)) {
            if (kierunek == kierunek.GORA) {
                plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
                pozycjaGraczaX--;
                polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
                plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
            } else if (kierunek == Kierunek.DOL) {
                plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
                pozycjaGraczaX++;
                polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
                plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
            } else if (kierunek == Kierunek.PRAWO) {
                plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
                pozycjaGraczaY++;
                polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
                plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
            } else if (kierunek == Kierunek.LEWO) {
                plansza[pozycjaGraczaX][pozycjaGraczaY] = polePodGraczem;
                pozycjaGraczaY--;
                polePodGraczem = plansza[pozycjaGraczaX][pozycjaGraczaY];
                plansza[pozycjaGraczaX][pozycjaGraczaY] = 3;
            }
        }
    }

    private boolean sprawdzKolizje(Kierunek kierunek) {
        if (kierunek == kierunek.GORA) {
            if (plansza[pozycjaGraczaX - 1][pozycjaGraczaY] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX - 1][pozycjaGraczaY] == 2) {
                if(sprawdzKolizjeSkrzyni(kierunek)){
                    plansza[pozycjaGraczaX - 2][pozycjaGraczaY] = 2;
                    plansza[pozycjaGraczaX - 1][pozycjaGraczaY] = bazowaPlansza[pozycjaGraczaX - 1][pozycjaGraczaY];
                    return true;
                }
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.DOL) {
            if (plansza[pozycjaGraczaX + 1][pozycjaGraczaY] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX + 1][pozycjaGraczaY] == 2) {
                if(sprawdzKolizjeSkrzyni(kierunek)){
                    plansza[pozycjaGraczaX + 2][pozycjaGraczaY] = 2;
                    plansza[pozycjaGraczaX + 1][pozycjaGraczaY] = bazowaPlansza[pozycjaGraczaX + 1][pozycjaGraczaY];
                    return true;
                }
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.PRAWO) {
            if (plansza[pozycjaGraczaX][pozycjaGraczaY + 1] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX][pozycjaGraczaY + 1] == 2) {
                if(sprawdzKolizjeSkrzyni(kierunek)){
                    plansza[pozycjaGraczaX][pozycjaGraczaY + 2] = 2;
                    plansza[pozycjaGraczaX][pozycjaGraczaY + 1] = bazowaPlansza[pozycjaGraczaX][pozycjaGraczaY + 1];
                    return true;
                }
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.LEWO) {
            if (plansza[pozycjaGraczaX][pozycjaGraczaY - 1] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX][pozycjaGraczaY - 1] == 2) {
                if(sprawdzKolizjeSkrzyni(kierunek)){
                    plansza[pozycjaGraczaX][pozycjaGraczaY - 2] = 2;
                    plansza[pozycjaGraczaX][pozycjaGraczaY - 1] = bazowaPlansza[pozycjaGraczaX][pozycjaGraczaY - 1];
                    return true;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    private boolean sprawdzKolizjeSkrzyni(Kierunek kierunek){
        if (kierunek == kierunek.GORA) {
            if (plansza[pozycjaGraczaX - 2][pozycjaGraczaY] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX - 2][pozycjaGraczaY] == 2) {
                return false;
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.DOL) {
            if (plansza[pozycjaGraczaX + 2][pozycjaGraczaY] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX + 2][pozycjaGraczaY] == 2) {
                return false;
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.PRAWO) {
            if (plansza[pozycjaGraczaX][pozycjaGraczaY + 2] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX][pozycjaGraczaY + 2] == 2) {
                return false;
            } else {
                return true;
            }
        } else if (kierunek == Kierunek.LEWO) {
            if (plansza[pozycjaGraczaX][pozycjaGraczaY - 2] == 1) {
                return false;
            } else if (plansza[pozycjaGraczaX][pozycjaGraczaY - 2] == 2) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void wczytajPlanszeZPliku(String nazwaPliku) { //well coś nie działa
        try {
            Scanner odczyt = new Scanner(new File("src\\Plansze\\" + nazwaPliku));
            x = odczyt.nextInt();
            y = odczyt.nextInt();
            plansza = new Integer[x][y];
            bazowaPlansza = new Integer[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    plansza[i][j] = 0; //puste pole
                    bazowaPlansza[i][j] = 0;
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    plansza[i][j] = odczyt.nextInt();
                    bazowaPlansza[i][j] = plansza[i][j];
                    if (plansza[i][j] == 3) {
                        bazowaPlansza[i][j] = 1;
                        pozycjaGraczaX = i;
                        pozycjaGraczaY = j;
                    }
                    if(bazowaPlansza[i][j] == 2){
                        bazowaPlansza[i][j] = 0;
                    }
                }
            }


            odczyt.close();
        } catch (Exception e) {
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
