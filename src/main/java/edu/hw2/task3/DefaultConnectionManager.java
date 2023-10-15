package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager extends ConnectionManagerBase {
    private final static Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        openConnection();

        return RANDOM.nextBoolean()
            ? new StableConnection(this)
            : new FaultyConnection(this);
    }
}
