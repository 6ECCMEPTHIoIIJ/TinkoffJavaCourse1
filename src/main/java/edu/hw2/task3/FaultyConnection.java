package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection extends ConnectionBase {
    private final static Random RANDOM = new Random();

    public FaultyConnection(ConnectionManager owner) {
        super(owner);
    }

    @Override
    public void execute(String command) throws ConnectionException {
        if (RANDOM.nextBoolean()) {
            throw new ConnectionException();
        }
    }
}
