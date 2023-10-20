package edu.project1;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class Observable<T> {
    private final Set<Observer<T>> observers = new java.util.HashSet<>();

    public AutoCloseable subscribe(@NotNull Observer<T> observer) {
        observers.add(observer);
        return new Unsubscriber(observers, observer);
    }

    public void sendNotification(T info) {
        for (var observer : observers) {
            observer.onNotification(info);
        }
    }

    private class Unsubscriber implements AutoCloseable {

        private final Set<Observer<T>> observers;
        private final Observer<T> observer;

        Unsubscriber(Set<Observer<T>> observers, Observer<T> observer) {
            this.observers = observers;
            this.observer = observer;
        }

        @Override
        public void close() throws Exception {
            if (observers != null) {
                observers.remove(observer);
            }
        }
    }
}
