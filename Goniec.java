public class Goniec extends LotnaBierka{

    public Goniec(KolorGracza k, int x, int y, Szachownica s) {
        super(k, x, y, s);
    }

    public char symbol() { return 'g'; }

    protected int[][] kierunki() {
        return new int[][] {
                {1, 1},
                {1, -1},
                {-1, -1},
                {-1, 1},
        };
    }
}
