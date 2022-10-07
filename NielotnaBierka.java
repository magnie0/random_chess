import java.util.*;

/**
 * Bierki, które mają ustaloną listę dozwolonych ruchów zdefiniowanych przez wektory
 */
abstract public class NielotnaBierka extends Bierka {
    public NielotnaBierka(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    abstract protected int[][] wektory();

    public List<Ruch> dajRuchy() {
        List<Ruch> wynik = new ArrayList<Ruch>();
        int w[][] = wektory();
        for(int i=0;i<w.length;i++) {
            int gdzieX = x+w[i][0];
            int gdzieY = y+w[i][1];
            if (czyDozwolonePole(gdzieX, gdzieY)) {
                //System.out.println("K: "+x+"/"+y+" | "+gdzieX+"/"+gdzieY);
                wynik.add(new Ruch(this, gdzieX, gdzieY));
            }
        }
        return wynik;
    }
}