package model;

import view.Observer;

import java.util.Date;
import java.util.List;

/**
 * Created by Isabela on 24/03/2015.
 */
public interface Subject {

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);

    public void notifyObserversAdd();
    public void notifyObserversBusca(List resultado);
    public void notifyObserversMulta(String valor);
    public void notifyObserversRelatorio(List resultado);
}
