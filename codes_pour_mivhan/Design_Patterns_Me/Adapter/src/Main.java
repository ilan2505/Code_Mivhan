public class Main {
    public static void main(String[] args) {
        Standard standard1 = new StandardImpl();
        standard1.operation(7,9);                  //resultat du calcul standard

        Standard standard2 = new Adaptateur();
        standard2.operation(7,9);                  //resultat par heritage - donc en gros la classe StandarImpl ne sert a rien.

        Standard standard3 = new Adaptateur2();
        standard3.operation(7,9);                  //resultat par composition

        /**
         * Le resultat sera :
         * Standard : Résultat = 63
         * Ancienne Implementation : Résultat = 63
         * Ancienne Implementation : Résultat = 63
         */
    }
}