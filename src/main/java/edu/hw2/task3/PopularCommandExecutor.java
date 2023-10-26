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
                } catch (ConnectionException error) {
                    throw new ConnectionException("Wrong attempt", error);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            try (connect) {
                connect.execute(command);
                return true;
            } catch (ConnectionException ignoredError) {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
