package edu.project1;

public abstract class Observer<T> {
    private AutoCloseable unsubscriber;

    public void subscribe(edu.project1.Observable<T> provider) {
        if (provider != null) {
            unsubscriber = provider.subscribe(this);
        }
    }

    public abstract void onNotification(T info);

    public void unsubscribe() throws Exception {
        unsubscriber.close();
    }
}
