package edu.hw2.task3;

public abstract class ConnectionBase implements Connection {
    private ConnectionManager owner;

    public ConnectionBase(ConnectionManager owner) {
        this.owner = owner;
    }

    @Override
    public void close() throws Exception {
        if (owner == null) {
            return;
        }

        owner.closeConnection();
        owner = null;
    }
}
