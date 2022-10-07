import java.util.ArrayList;
import java.util.List;

public class Pion extends Bierka{
    public Pion(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }
    public char symbol() { return 'p'; }

    public List<Ruch> dajRuchy() {
        List<Ruch> wynik = new ArrayList<Ruch>();
        int yNowy;
        if (kolor == KolorGracza.BIALY) {
            yNowy = y + 1;
        }
        else {
            yNowy = y - 1;
        }
        if (czyNaPoluPrzeciwnik(x-1,yNowy))
            wynik.add(new Ruch(this,x-1, yNowy));
        if (czyPustePole(x,yNowy))
            wynik.add(new Ruch(this,x,yNowy));
        if (czyNaPoluPrzeciwnik(x+1,yNowy))
            wynik.add(new Ruch(this,x+1, yNowy));
        return wynik;
    }
}
