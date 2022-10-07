public class Wieza extends LotnaBierka {

    public Wieza(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    public char symbol() { return 'w'; }

    protected int[][] kierunki() {
        return new int[][] {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };
    }

}
