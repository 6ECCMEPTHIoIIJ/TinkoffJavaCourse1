package edu.project1;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class Observer<T> {
    private AutoCloseable unsubscriber;
    private final Consumer<T> action;

    public Observer(Consumer<T> action) {
        this.action = action;
    }

    public void subscribe(@NotNull Observable<T> provider) {
        if (unsubscriber != null) {
            throw new MultipleSubscriptionException();
        }

        unsubscriber = provider.subscribe(this);
    }

    public void onNotification(T info) {
        action.accept(info);
    }

    public void unsubscribe() throws Exception {
        if (unsubscriber == null) {
            return;
        }

        unsubscriber.close();
        unsubscriber = null;
    }
}
