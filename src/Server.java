import javax.swing.*;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        int port = 6666;

        JFrame frame = new ChatGUI("Server", port);
        frame.setVisible(true);

        //Invia invia = new Invia(port);
        Ricevi ricevi = new Ricevi(port, frame);

        //Thread threadInvia = new Thread(invia);
        Thread threadRicevi = new Thread(ricevi);

        threadRicevi.start();
        //threadInvia.start();
    }
}
