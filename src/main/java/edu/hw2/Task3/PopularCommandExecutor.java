package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Connection connect = manager.getConnection();
        for (int i = 0; i < this.maxAttempts; i++) {
            if (i == this.maxAttempts - 1) {
                try (connect) {
                    connect.execute(command);
                } catch (ConnectionException error) {
                    throw new ConnectionException(error);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            try (connect) {
                connect.execute(command);
                return;
            } catch (ConnectionException ignoredError) {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
