/**
 * c'est une interface qui doi etre implémentée par tout objet qui souhaite observer un autre objet. autrement dit
 * tout objet qui souhaite etre informer a chaque fois que l'Etat de l'objet observé va changer.
 */
public interface Observer {
    public void update(Observable o);
}
/**
 * il existe une deuxieme technique "poussée" qui consiste a :
 * 1. on remplace en haute "Observable o" par "int v"
 * 2. Dans ObservableConcret : on change dans la methode "notifyObservers()" le mot 'this' par 'etat'
 * 3. Dans les impl1 et impl2 ; on supprime la ligne de code 'int etat' et on remplace dans syso 'etat' par 'v' (l'argument de la methode)
 *
 * on appelle cela la technique poussée.
 * dans la premiere technique juste on nous dit que quelque chose a changer
 * alors que dans celle la on te le dis et on te donne la nouvelle valeur.
 */
