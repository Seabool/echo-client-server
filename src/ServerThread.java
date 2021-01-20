import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = input.readLine()) != null) {
                System.out.println("User#" + socket.hashCode() + ": " + line);
                output.println(line);
            }
        } catch (IOException e) {
            System.out.println("User " + socket.hashCode() + " disconnected!");
        }

    }

}
