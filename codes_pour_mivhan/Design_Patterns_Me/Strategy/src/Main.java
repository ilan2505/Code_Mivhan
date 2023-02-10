/**
 * on utilise ce DP car on veut qu'il soit fermer a la mofification mais ouvert a l'extenssion.
 * on utilise ca pour respecter SOLID afin de pas faire If(etat = 1) ... elseif(etat = 2) .... elseif(etat = 3)....
 */
public class Main {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setStrategy(new StrategyImpl1());
        ctx.appliquerStrategy();//"Traitement Version 1"
        ctx.setStrategy(new StrategyImpl2());
        ctx.appliquerStrategy();//"Traitement Version 2"
        ctx.setStrategy(new StrategyImpl3());
        ctx.appliquerStrategy();//"Traitement Version 3"
    }
}
/**
 * Resultat :
 * Traitement Version 1
 * Traitement Version 2
 * Traitement Version 3
 */