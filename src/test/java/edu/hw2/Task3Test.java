package edu.hw2.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PopularCommandExecutorTest {


    @BeforeEach
    void setUp() {
        manager = mock(ConnectionManager.class);
        executor = new PopularCommandExecutor(manager, 3);
    }

}
