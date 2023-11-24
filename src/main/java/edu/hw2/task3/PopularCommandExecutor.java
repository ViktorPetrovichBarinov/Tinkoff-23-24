package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public boolean updatePackages() {
        return tryExecute("apt update && apt upgrade -y");
    }

    public boolean tryExecute(String command) {
        Connection connect = manager.getConnection();
        for (int i = 0; i < this.maxAttempts; i++) {
            if (i == this.maxAttempts - 1) {
                try (connect) {
                    connect.execute(command);
                    return true;
                } catch (Exception error) {
                    throw new ConnectionException("Wrong attempt", error);
                }
            }
            try (connect) {
                connect.execute(command);
                return true;
            } catch (Exception ignoredError) {

            }
        }
        return false;
    }
}
