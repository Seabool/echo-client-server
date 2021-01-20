import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3200);
            System.out.println("You are connected to server on port 3200!");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Type 'exit' to quit the program...");
            while (true) {
                System.out.print("Enter text: ");
                String line = userInput.readLine();
                if (line.equals("exit")) {
                    break;
                }
                output.println(line);
                output.flush();
                System.out.println("Server response: " + input.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}