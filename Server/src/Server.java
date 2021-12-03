import java.io.*;
import java.net.*;
import java.util.LinkedList;


public class Server {

    //public static final int PORT = 8080;
    public static final int PORT = 4004;
    public static LinkedList<ServerThread> serverList = new LinkedList<>(); // список всех нитей - экземпляров
    // сервера, слушающих каждый своего клиента


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server Started");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            System.out.println("Server Closed");
            server.close();
        }
    }
}


