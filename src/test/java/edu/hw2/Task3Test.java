package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnection;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.StableConnection;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Random;
import static org.mockito.Mockito.*;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Runtime Exeption String")
    void test1(){
        String errorMessage = "Test message";
        ConnectionException connectionException = new ConnectionException(errorMessage);

        assertThat(errorMessage).isEqualTo(connectionException.getMessage());
        assertThat(connectionException.getMessage()).isNotNull();
    }

    @Test
    @DisplayName("Runtime Exeption (String, Throwable")
    void test2() {
        String errorMessage = "Test message";
        Exception cause = new Exception("Test cause");
        ConnectionException connectionException = new ConnectionException(errorMessage, cause);

        assertThat(errorMessage).isEqualTo(connectionException.getMessage());
        assertThat(cause).isEqualTo(connectionException.getCause());
        assertThat(connectionException.getMessage()).isNotNull();
    }

    @Test
    @DisplayName("FaultyConnection")
    public void test3() {
        FaultyConnection faultyConnection = new FaultyConnection();
        for(int i = 0; i < 1000; i ++) {
            try{
                faultyConnection.execute("ls");
            } catch(ConnectionException e) {
                assertThat("Wrong attempt").isEqualTo(e.getMessage());
            }
        }
    }

    @Test
    public void test4() {
        for (int i = 0; i < 1000; i++) {
            DefaultConnectionManager defaultConnectionManager = new DefaultConnectionManager();
            Integer maxAttempts = 1;
            PopularCommandExecutor executor = new PopularCommandExecutor(defaultConnectionManager, maxAttempts);
            for (int j = 0; j < 1000; j++) {
                try{
                    executor.tryExecute("123");
                } catch(RuntimeException e) {
                    assertThat("Wrong attempt").isEqualTo(e.getMessage());
                }
            }
        }
    }


    @Test
    public void test5() {

    }


}
