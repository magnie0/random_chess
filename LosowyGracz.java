import java.util.*;
public class LosowyGracz extends Gracz {
    Random rnd = new Random();
    public LosowyGracz(KolorGracza kolor, Szachownica s) {
        super(kolor, s);
    }
    public Ruch dajRuch() {
        // zapytaj się szachownicy o Bierki
        List<Bierka> bierki = szachownica.dajBierkiGracza(kolor);
        List<Ruch> ruchy = new ArrayList<Ruch>();
        // zbierz wszystkie dozwolone ruchy
        for(Bierka b : bierki) {
            ruchy.addAll(b.dajRuchy());
        }
        // jesli lista jest pusta -> zwroc null
        if (ruchy.size()==0) return null;
        // wpp wybierz losowy ruch
        return ruchy.get(rnd.nextInt(ruchy.size()));
    }

}