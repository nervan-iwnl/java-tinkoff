package edu.hw2.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class FaultyConnection implements Connection {
    int exceptionChance = 3;
    private static final Logger LOGGER = LogManager.getLogger();

    public FaultyConnection() {

    }

    @Override
    public void execute(String command) {
        if ((int) (Math.random() * (exceptionChance + 1)) == exceptionChance) {
            throw new ConnectionException("Connection error");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
