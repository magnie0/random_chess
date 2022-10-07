public class Hetman extends LotnaBierka{

    public Hetman(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    public char symbol() { return 'h'; }

    protected int[][] kierunki() {
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
