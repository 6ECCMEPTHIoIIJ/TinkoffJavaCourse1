package edu.project1.observer;

import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;

public class Observer<T> {
    private final Consumer<T> consumer;
    private AutoCloseable unsubscriber;

    public Observer(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void subscribe(@NotNull Observable<T> observable) {
        if (unsubscriber != null) {
            throw new MultipleSubscribeException();
        }

        unsubscriber = observable.subscribe(this);
    }

    public void onNotification(T info) {
        consumer.accept(info);
    }

    public void unsubscribe() throws Exception {
        if (unsubscriber == null) {
            return;
        }

        unsubscriber.close();
        unsubscriber = null;
    }
}

