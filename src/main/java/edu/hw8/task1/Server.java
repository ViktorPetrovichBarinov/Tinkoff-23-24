package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private int portNumber;
    private final QuoteBook quoteBook = new QuoteBook();
    private ExecutorService threadPool;

    public Server(int portNumber, int poolSize) {
        this.portNumber = portNumber;
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            LOGGER.log(Level.INFO, "Сервер начал работу");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                LOGGER.log(Level.INFO, "Клиент подключился");

                threadPool.execute(() -> {
                    handleClient(clientSocket);
                });
            }

        } catch (IOException e) {
            System.exit(-1);
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String clientRequest = reader.readLine();
            LOGGER.log(Level.INFO, "Получен запрос " + clientRequest);

            ArrayList<String> answer = quoteBook.quoteFinderByKeyWord(clientRequest);
            if (answer == null) {
                LOGGER.log(Level.INFO, "Ничего не найдено");
            } else {
                LOGGER.log(Level.INFO, "Найдено: " + answer);
            }
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(answer);
        } catch (IOException e) {
            System.exit(-1);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.exit(-1);
            }
        }
    }
}
