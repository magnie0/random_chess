public abstract class Gracz {
    public final KolorGracza kolor;
    protected Szachownica szachownica;
    public Gracz(KolorGracza kolor, Szachownica s) {
        this.kolor = kolor;
        this.szachownica = s;
    }
    public abstract Ruch dajRuch();

    @Override
    public String toString() {
        return "Gracz(" + this.kolor + ")";
    }
}