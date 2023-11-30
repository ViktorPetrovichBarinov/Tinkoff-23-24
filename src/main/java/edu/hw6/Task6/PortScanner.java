package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
public class PortScanner {
    private PortScanner() {
    }

    private static final Map<Integer, String> PORT_MAP = new HashMap<>();
    private static final String EMPTY_DESCRIPTION = "---";
    private static final String OUTPUT_FORMAT = "%-9s|%-6d|%s\n";

    static {
        PORT_MAP.put(135, "EPMAP");
        PORT_MAP.put(137, "Служба имен NetBIOS");
        PORT_MAP.put(138, "Служба датаграмм NetBIOS");
        PORT_MAP.put(139, "Служба сеансов NetBIOS");
        PORT_MAP.put(445, "Microsoft-DS Active Directory");
        PORT_MAP.put(843, "Adobe Flash");
        PORT_MAP.put(1900, "Simple Service Discovery Protocol (SSDP)");
        PORT_MAP.put(3702, "Динамическое обнаружение веб-служб");
        PORT_MAP.put(5353, "Многоадресный DNS");
        PORT_MAP.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        PORT_MAP.put(17500, "Dropbox");
        PORT_MAP.put(27017, "MongoDB");
    }


    private static final String TCP = "TCP";
    private static final String UDP = "UDP";

    public static void scanner(List<Integer> ports) {
        System.out.println("Протокол  Порт   Сервис");
        for (Integer port : ports) {
            if (isTcpBusy(port)) {
                String service = PORT_MAP.get(port);
                if (service == null) {
                    service = EMPTY_DESCRIPTION;
                }
                System.out.printf(OUTPUT_FORMAT, TCP, port, service);
            }

            if (isUdpBusy(port)) {
                String service = PORT_MAP.get(port);
                if (service == null) {
                    service = EMPTY_DESCRIPTION;
                }
                System.out.printf(OUTPUT_FORMAT, UDP, port, service);
            }
        }
    }

    public static boolean isTcpBusy(Integer port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    public static boolean isUdpBusy(Integer port) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);
            datagramSocket.close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
