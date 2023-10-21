package edu.project1.observer;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {
    private final Set<Observer<T>> observers = new HashSet<>();

    public void sendNotification(T info) {
        for (var observer : observers) {
            observer.onNotification(info);
        }
    }

    public AutoCloseable subscribe(Observer<T> observer) {
        if (!observers.add(observer)) {
            throw new MultipleSubscribeException();
        }

        observer.subscribe(this);

        return new Unsubscriber(observers, observer);
    }

    private class Unsubscriber implements AutoCloseable {
        private final Set<Observer<T>> observers;
        private final Observer<T> observer;

        public Unsubscriber(Set<Observer<T>> observers, Observer<T> observer) {
            this.observers = observers;
            this.observer = observer;
        }

        @Override
        public void close() throws Exception {
            observers.remove(observer);
        }
    }
}
