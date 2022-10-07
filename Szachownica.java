import java.util.*;

public class Szachownica {
    public final static int ROZMIAR=8;

    Bierka[][] plansza;

    public void ustawBierki(Bierka[] bierki) {
        plansza = new Bierka[ROZMIAR][ROZMIAR];
        for(Bierka b : bierki) {
            plansza[b.wspY()][b.wspX()] = b;
        }
    }

    public Szachownica() {
        ustawBierki(new Bierka[]{
                new Wieza(KolorGracza.BIALY, 0, 0, this),
                new Skoczek(KolorGracza.BIALY, 1, 0, this),
                new Goniec(KolorGracza.BIALY, 2, 0, this),
                new Hetman(KolorGracza.BIALY, 3, 0, this),
                new Krol(KolorGracza.BIALY, 4, 0, this),
                new Goniec(KolorGracza.BIALY, 5, 0,this),
                new Skoczek(KolorGracza.BIALY, 6, 0, this),
                new Wieza(KolorGracza.BIALY, 7, 0, this),
                new Pion(KolorGracza.BIALY, 0, 1, this),
                new Pion(KolorGracza.BIALY, 1, 1, this),
                new Pion(KolorGracza.BIALY, 2, 1, this),
                new Pion(KolorGracza.BIALY, 3, 1, this),
                new Pion(KolorGracza.BIALY, 4, 1, this),
                new Pion(KolorGracza.BIALY, 5, 1, this),
                new Pion(KolorGracza.BIALY, 6, 1, this),
                new Pion(KolorGracza.BIALY, 7, 1, this),


                new Wieza(KolorGracza.CZARNY, 0, 7, this),
                new Skoczek(KolorGracza.CZARNY, 1, 7, this),
                new Goniec(KolorGracza.CZARNY, 2, 7, this),
                new Hetman(KolorGracza.CZARNY, 3, 7, this),
                new Krol(KolorGracza.CZARNY, 4, 7, this),
                new Goniec(KolorGracza.CZARNY, 5, 7,this),
                new Skoczek(KolorGracza.CZARNY, 6, 7, this),
                new Wieza(KolorGracza.CZARNY, 7, 7, this),
                new Pion(KolorGracza.CZARNY, 0,6,this),
                new Pion(KolorGracza.CZARNY, 1,6,this),
                new Pion(KolorGracza.CZARNY, 2,6,this),
                new Pion(KolorGracza.CZARNY, 3,6,this),
                new Pion(KolorGracza.CZARNY, 4,6,this),
                new Pion(KolorGracza.CZARNY, 5,6,this),
                new Pion(KolorGracza.CZARNY, 6,6,this),
                new Pion(KolorGracza.CZARNY, 7,6,this)
        });
    }



    public Bierka dajBierke(int x, int y) {
        return plansza[y][x];
    }

    public List<Bierka> dajBierkiGracza(KolorGracza kolor) {
        List<Bierka> lista = new ArrayList<Bierka>();
        for(int y=0;y<ROZMIAR;y++)
            for(int x=0;x<ROZMIAR;x++) {
                Bierka b = dajBierke(x, y);
                if (b!=null && b.kolor==kolor) lista.add(b);
            }
        return lista;
    }


    public void wykonajRuch(Ruch r) {
        // ewentualnie mozna dodać sprawdzenie czy to legalny ruch
        //
        // musimy sie dowiedziec jaka bierka i gdzie jest
        Bierka co = r.co;
        int skadX = co.wspX();
        int skadY = co.wspY();
        // musimy zmienic zawartosc planszy
        plansza[skadY][skadX] = null;
        plansza[r.gdzieY][r.gdzieX] = co; // tu byc moze bijemy inna bierkę
        // i trzeba powiedziec bierce o nowej pozycji
        co.zmienPozycje(r.gdzieX, r.gdzieY);
    }
    /*
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_RESET = "\u001B[0m";
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int y=ROZMIAR-1;y>=0;y--) {
            sb.append(y+1);
            sb.append(" ");
            for(int x=0;x<ROZMIAR;x++) {

                if (plansza[y][x] != null) {
                    /*
                    if (plansza[y][x].kolor == KolorGracza.BIALY)
                        sb.append(TEXT_YELLOW + plansza[y][x] + TEXT_RESET);
                    else
                        sb.append(TEXT_CYAN + plansza[y][x] + TEXT_RESET);
                    */
                    sb.append(plansza[y][x]);

                }
                else sb.append(".");
            }
            sb.append("\n");
        }
        sb.append("  ");
        char c = 'A';
        for (int x=1; x<=ROZMIAR;x++) {
            sb.append(c);
            c++;
        }
        sb.append("\n");

        return sb.toString();
    }
}