package edu.hw2.task3;

public class FaultyConnection implements Connection {
    static boolean needToThrowException = false;

    @Override
    public void execute(String command) throws ConnectionException {
        boolean oldNeedToThrowException = needToThrowException;
        needToThrowException = !needToThrowException;
        if (oldNeedToThrowException) {
            throw new ConnectionException();
        }

        Utility.LOGGER.info("Command <{}> executed successfully", command);
    }

    @Override
    public void close() throws Exception {
        Utility.LOGGER.info("Faulty connection closed successfully");
    }
}
