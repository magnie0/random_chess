public class Skoczek extends NielotnaBierka{
    public Skoczek(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    public char symbol() { return 's'; }

    protected int[][] wektory() {
        return new int[][] {
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
        };
    }
}
