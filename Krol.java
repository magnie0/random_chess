public class Krol extends NielotnaBierka {
    public Krol(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    public char symbol() { return 'k'; }

    protected int[][] wektory() {
        return new int[][] {
                {-1, 1},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
        };
    }
}