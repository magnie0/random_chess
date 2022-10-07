/**
 * Losowe AntySzachy
 *
 * normalne bierki
 * usuwamy pojęcie szacha -> król to zwykła bierka
 * usuwamy wszystkie niestandardowe ruchy (roszady, bicie w przelocie, pionek poruszający się o dwa pola)
 * gra się kończy jeśli jakiś gracz nie ma ruchu (w tym jeśli nie ma już żadnych bierek)
 * jeśli po 100 ruchach gra się nie zakończyła to jest remis
 * nie ma awansowania pionków
 * nie ma reguły o remisie w wypadku powtórzenia się sytuacji na planszy
 *
 * losowi gracze:
 * - w każdej rundzie gracz generuje wszystkie dozwolone ruchy
 * - wybiera spośród nich losowy
 *
 * mamy zaprojektować program tak by można było łatwo dodać innych graczy (np. człowiek, albo gracz szukający optymalnego ruchu)
 *
 *
 * Szachownica
 * - Bierka plansza[8][8]
 * + List<Bierka> dajBierkiGracza(KolorGracza kolor)
 * + Bierka dajBierke(int x, int y)
 * + int rozmiar()
 *
 * Gracz (abstrakcyjna)
 * podklasa: 
 * LosowyGracz
 *
 * Ruch
 *
 * enum KolorGracza
 *
 * Bierka
 * int x, y
 *
 * podklasy:
 * BierkaNielotna - ma wektor możliwych ruchów, ale można go mnożyć o dowolną stałą
 nie może przeskakiwać innych bierek
 * BierkaLotna - ma ustalony zbiór wektorów, może przeskakiwać inne bierki
 *
 * Uwaga! Pionki ruszają się do przodu ale biją na skosy
 *
 */
public class AntySzachy {

    public void rozgrywka() {
        // utworzyć planszę
        // utworzyć graczy
        // w petli:
        // - zapytaj się gracza o ruch -> jeśli brak to koniec gry
        // - wypisz informację o ruchu
        // - wykonaj ruch
        // - wypisz planszę
        // napisz kto wygrał
        Szachownica s = new Szachownica();
        // pytanie gdzie rozkladamy bierki
        Gracz g1 = new LosowyGracz(KolorGracza.BIALY, s);
        Gracz g2 = new LosowyGracz(KolorGracza.CZARNY, s);
        Gracz zwyciezca = null;
        System.out.println(s);
        for(int numerRuchu=1;numerRuchu<=100;numerRuchu++) {
            Gracz g = (numerRuchu%2==1 ? g1 : g2);
            Ruch r = g.dajRuch();
            if (r == null) {
                zwyciezca = (numerRuchu%2==1 ? g2 : g1);
                break;
            }
            System.out.println("Gracz " + g + " wykonuje ruch " + r);
            s.wykonajRuch(r);
            System.out.println(s);
        }
        if (zwyciezca != null) {
            System.out.println("Zwyciezyl gracz " + zwyciezca);
        } else {
            System.out.println("Remis");
        }
    }

    public static void main(String[] args) {
        AntySzachy gra = new AntySzachy();
        gra.rozgrywka();
    }
}