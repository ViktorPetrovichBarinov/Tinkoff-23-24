package edu.hw6.Task6Test;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import static edu.hw6.Task6.PortScanner.isTcpBusy;
import static edu.hw6.Task6.PortScanner.isUdpBusy;
import static edu.hw6.Task6.PortScanner.scanner;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {


    @Test
    void test1() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int port = 0; port < 10000; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                assertThat(isTcpBusy(port)).isFalse();
            } catch(IOException e) {
                assertThat(isTcpBusy(port)).isTrue();
                testList.add(port);
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                assertThat(isUdpBusy(port)).isFalse();
            } catch(IOException e) {
                assertThat(isUdpBusy(port)).isTrue();
                testList.add(port);
            }
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        scanner(testList);
        for (Integer port : testList) {
            assertThat(outputStream.toString().contains(port.toString())).isTrue();
        }

        System.setOut(originalOut);
        System.out.println(outputStream);
    }
}
