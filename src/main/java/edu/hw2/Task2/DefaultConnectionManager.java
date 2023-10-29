package edu.hw2.Task2;

@SuppressWarnings("MagicNumber")
public class DefaultConnectionManager implements ConnectionManager {
    int exceptionChance = 3;

    public DefaultConnectionManager() {

    }

    @Override
    public Connection getConnection() {
        if ((int) (Math.random() * (exceptionChance + 1)) == exceptionChance) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }

}
