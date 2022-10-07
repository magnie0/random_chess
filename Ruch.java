public class Ruch {
    public final Bierka co;
    public final int gdzieX;
    public final int gdzieY;
    public Ruch(Bierka co, int gdzieX, int gdzieY) {
        this.co = co;
        this.gdzieX = gdzieX;
        this.gdzieY = gdzieY;
    }

    public static String pole(int x, int y) {
        return "" + (char) ('A' + x) + (y + 1);
    }

    @Override
    public String toString() {
        return "Bierka(" + co + ") z pola " + pole(co.wspX(), co.wspY()) + " na pole " + pole(gdzieX, gdzieY);
    }
}