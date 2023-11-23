package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PortScanner {
    private final static int LAST_PORT_NUMBER = 49151;
    private static final Map<Integer, String> portMap = new HashMap<>();
    static {
        portMap.put(135, "EPMAP");
        portMap.put(137, "Служба имен NetBIOS");
        portMap.put(138, "Служба датаграмм NetBIOS");
        portMap.put(139, "Служба сеансов NetBIOS");
        portMap.put(445, "Microsoft-DS Active Directory");
        portMap.put(843, "Adobe Flash");
        portMap.put(1900, "Simple Service Discovery Protocol (SSDP)");
        portMap.put(3702, "Динамическое обнаружение веб-служб");
        portMap.put(5353, "Многоадресный DNS");
        portMap.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        portMap.put(17500, "Dropbox");
        portMap.put(27017, "MongoDB");
    }


    private static final String TCP = "TCP";
    private static final String UDP = "UDP";

    public static void scanner() {
        System.out.println("Протокол  Порт   Сервис");
        for (int port = 0; port <= 49151; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (IOException e) {
                String service = portMap.get(port);
                if(service == null) {
                    service = "---";
                }
                System.out.printf("%-9s|%-6d|%s\n", TCP, port, service);
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
            } catch (IOException e) {
                String service = portMap.get(port);
                if(service == null) {
                    service = "---";
                }
                System.out.printf("%-9s|%-6d|%s\n", UDP, port, service);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        scanner();
    }
}
