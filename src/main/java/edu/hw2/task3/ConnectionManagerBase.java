package edu.hw2.task3;

public abstract class ConnectionManagerBase implements ConnectionManager {
    private int activeConnectionsCount = 0;

    protected void openConnection() {
        ++activeConnectionsCount;
    }

    @Override
    public void closeConnection() {
        --activeConnectionsCount;
    }

    @Override
    public int getActiveConnectionsCount() {
        return activeConnectionsCount;
    }
}
