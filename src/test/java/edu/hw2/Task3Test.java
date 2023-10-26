package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnection;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.StableConnection;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.text.DecimalFormat;
import java.util.Random;
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
    void test2(){
        String errorMessage = "Test message";
        Exception cause = new Exception("Test cause");
        ConnectionException connectionException = new ConnectionException(errorMessage, cause);

        assertThat(errorMessage).isEqualTo(connectionException.getMessage());
        assertThat(cause).isEqualTo(connectionException.getCause());
        assertThat(connectionException.getMessage()).isNotNull();
    }

    @Test
    @DisplayName("Дефолтное соединение")
    void test3() {
        DefaultConnectionManager manager = new DefaultConnectionManager();
        assertThat(manager.getConnection()).isNull();
    }

}
