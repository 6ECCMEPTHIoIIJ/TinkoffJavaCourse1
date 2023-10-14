package edu.hw2.task3;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        Utility.LOGGER.info("Command <{}> executed successfully", command);
    }

    @Override
    public void close() throws Exception {
        Utility.LOGGER.info("Stable connection closed successfully");
    }
}
