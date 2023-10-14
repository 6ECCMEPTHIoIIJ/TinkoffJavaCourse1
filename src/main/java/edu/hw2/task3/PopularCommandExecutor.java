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
        Connection connection = manager.getConnection();
        ConnectionException cause = new ConnectionException();
        boolean isExecuted = false;
        for (int attemptCount = 0; attemptCount < maxAttempts && !isExecuted; ++attemptCount) {
            try {
                connection.execute(command);
                isExecuted = true;
            } catch (ConnectionException e) {
                int attemptsLeft = maxAttempts - attemptCount - 1;
                if (attemptsLeft > 0) {
                    Utility.LOGGER.error("Connection error. {} attempts left", attemptsLeft);
                } else {
                    Utility.LOGGER.error("Connection lost");
                }

                cause = e;
            }
        }

        connection.close();
        if (!isExecuted) {
            throw new ConnectionException(cause);
        }
    }

    public static void main(String[] args) throws Exception {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        for (int i = 0; i < 100; ++i) {
            executor.updatePackages();
        }
    }
}
