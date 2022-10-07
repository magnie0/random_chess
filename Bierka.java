import java.util.*;
abstract public class Bierka {
    public Bierka(KolorGracza k, int x, int y, Szachownica s) {
        this.kolor = k;
        this.x = x;
        this.y = y;
        this.szachownica = s;
    }

    protected Szachownica szachownica;
    public final KolorGracza kolor;
    protected int x, y;
    public int wspX() { return x; }
    public int wspY() { return y; }
    public void zmienPozycje(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract char symbol();

    @Override
    public String toString() {
        char c = symbol();
        if (kolor == KolorGracza.BIALY) return "" + c;
        else return "" + Character.toUpperCase(c);
    }

    public abstract List<Ruch> dajRuchy();

    public boolean czyWZakresiePlanszy(int x, int y) {
        if (x<0 || y <0) return false;
        if (x>=szachownica.ROZMIAR || y>=szachownica.ROZMIAR) return false;
        return true;
    }

    public boolean czyNaPoluPrzeciwnik(int x, int y) {
        if (!czyWZakresiePlanszy(x, y))
            return false;
        Bierka b = szachownica.dajBierke(x, y);
        if (b != null && this.kolor != b.kolor) return true;
        return false;
    }

    public boolean czyPustePole(int x, int y) {
        if (!czyWZakresiePlanszy(x, y))
            return false;
        if (szachownica.dajBierke(x,y) == null)
            return true;
        else
            return false;
    }

    public boolean czyDozwolonePole(int x, int y) {
        if (!czyWZakresiePlanszy(x, y))
            return false;
        Bierka b = szachownica.dajBierke(x, y);
        if (b != null && this.kolor == b.kolor) return false;
        return true;
    }
}