import java.util.ArrayList;
import java.util.List;

/**
 * Bierki, które mogą poruszać się na dowolną ogległość w zadnych kierunkach
 */
abstract public class LotnaBierka extends Bierka {

    public LotnaBierka(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    /**
     * tablica wektorów opisująca dozwolone kierunki int[n][2]
     */
    abstract protected int[][] kierunki();

    public List<Ruch> dajRuchy() {
        List<Ruch> wynik = new ArrayList<Ruch>();
        int w[][] = kierunki();
        int pomnozenie;
        int xPom,yPom;
        for(int i=0;i<w.length;i++) {
            pomnozenie = 1;
            int gdzieX = w[i][0];
            int gdzieY = w[i][1];
            xPom = x + gdzieX;
            yPom = y + gdzieY;
            while (pomnozenie > 0) {
                xPom = x + gdzieX*pomnozenie;
                yPom = y + gdzieY*pomnozenie;
                if (czyPustePole(xPom, yPom)) {
                    //System.out.println(x+"/"+y+" | "+xPom+"/"+yPom);
                    wynik.add(new Ruch(this, xPom, yPom));
                    pomnozenie++;
                }
                else {
                    pomnozenie = 0;
                }

            }
            if (czyDozwolonePole(xPom, yPom)) {
                wynik.add(new Ruch(this, xPom, yPom));
            }
        }
        return wynik;
    }
}

