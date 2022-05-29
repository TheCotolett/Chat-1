import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        int port = 6666; // Porta del client

        ChatGUI frame = new ChatGUI("Server", port); // Creazione della GUI passando la porta
        frame.setVisible(true); // Rende la GUI visibile

        Ricevi ricevi = new Ricevi(port, frame); // Inizializzazione della classe Ricevi
        Thread threadRicevi = new Thread(ricevi); // Creazione del Thread
        threadRicevi.start(); // Avvio del Thread
    }
}
