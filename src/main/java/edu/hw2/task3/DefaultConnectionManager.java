package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    boolean needToReturnFaultyConnection = false;

    @Override
    public Connection getConnection() {
        boolean oldNeedToReturnFaultyConnection = needToReturnFaultyConnection;
        needToReturnFaultyConnection = !needToReturnFaultyConnection;
        return (oldNeedToReturnFaultyConnection)
            ? new FaultyConnection()
            : new StableConnection();
    }
}
