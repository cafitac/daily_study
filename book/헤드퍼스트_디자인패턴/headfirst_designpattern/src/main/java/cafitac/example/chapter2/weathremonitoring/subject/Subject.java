package cafitac.example.chapter2.weathremonitoring.subject;

import cafitac.example.chapter2.weathremonitoring.observer.Observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
