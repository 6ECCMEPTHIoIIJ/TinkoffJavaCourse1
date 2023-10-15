package edu.hw2.task3;

public class FaultyConnectionManager extends ConnectionManagerBase {
    @Override
    public Connection getConnection() {
        openConnection();

        return new FaultyConnection(this);
    }
}
