public class Main {
    public static void main(String[] args) {
        ObservableConcret sujet = new ObservableConcret();
        ObserverImpl1 obs1 = new ObserverImpl1();
        sujet.addObserver(obs1);
        ObserverImpl2 obs2 = new ObserverImpl2();
        sujet.addObserver(obs2);
        sujet.setEtat(8);
        sujet.setEtat(3);
        sujet.deleteObserver(obs1);
        sujet.setEtat(10);
    }
}
/**
 * Resultat  :
 *              Resultat : 24
 *              Resultat : 48
 *
 *              Resultat : 9
 *              Resultat : 18
 *
 *              Resultat : 60
 */