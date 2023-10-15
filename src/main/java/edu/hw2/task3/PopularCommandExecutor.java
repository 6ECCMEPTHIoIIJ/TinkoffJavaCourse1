package edu.hw2.task3;

public final class PopularCommandExecutor {

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (manager == null || maxAttempts <= 0) {
            throw new IllegalArgumentException();
        }

        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws Exception {
        ConnectionException cause = new ConnectionException();
        for (int attemptCount = 0; attemptCount < maxAttempts; ++attemptCount) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                cause = e;
            }
        }

        throw new ConnectionException(cause);
    }
}
