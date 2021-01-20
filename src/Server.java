import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(3200);
            server.setReuseAddress(true);

            System.out.println("Server started at port 3200!");

            while (true) {
                final Socket socket = server.accept();
                System.out.println("User connected to Server!");

                ServerThread serverThread = new ServerThread(socket);
                new Thread(serverThread).start();
            }

        } catch (IOException e) {
            System.out.println("Problem with ServerSocket");
        }
    }
}
