/**
 * c'est une interface qui doit etre implémentée par toutes les classes qui souhaitent etre obsérvées.
 * elle definie generalement 3 methodes.
 */
public interface Observable {
    public void addObserver(Observer o);     //permet a l'observateur(observer) de s'inscrire/s'enregistré
    public void deleteObserver(Observer o); //s'abonner ou se désabonner/ s'inscrire ou se désinscrire.

    //methode qui doit permettre à l'observable de notifier tous les observateurs a chaque fois que son etat va changer.
    public void notifyObservers();
}
