package edu.hw2.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("Number of max attempts should be > 0");
        }
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int curr = 0; curr < maxAttempts; ++curr) {
            try {
                var connection = manager.getConnection();
                connection.execute(command);
                LOGGER.info("Command was executed successfully");
                return;
            } catch (Exception err) {
                if (curr + 1 == maxAttempts) {
                    throw new ConnectionException("The maximum number of attempts has been exceeded", err);
                }
            }
        }
    }
}
