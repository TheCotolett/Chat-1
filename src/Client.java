import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        int port = 5555; // Porta del client

        ChatGUI frame = new ChatGUI("Client", port); // Creazione della GUI passando la porta
        frame.setVisible(true); // Rende la GUI visibile

        Ricevi ricevi = new Ricevi(port, frame); // Inizializzazione della classe Ricevi
        Thread threadRicevi = new Thread(ricevi); // Creazione del Thread
        threadRicevi.start(); // Avvio del Thread
    }
}
