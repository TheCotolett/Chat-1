import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Invia {
    private DatagramSocket socket; // Socket per la gestione dei pacchetti UDP
    private InetAddress ip; //InetAddress è il tipo per gli indirizzi ip
    private byte[] data; // Array per i dati del pacchetto
    private int port;

    public Invia(int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket(); // Inizializzazione del socket con la porta
        this.ip = InetAddress.getByName("localhost");
        if (port == 5555)
            this.port = 6666;
        else
            this.port = 5555;
    }

    // Metodo per inviare il pacchetto
    public void sendPacket(String msg) {
        if (msg != null) {
            data = msg.getBytes(StandardCharsets.UTF_8); // Conversione da stringa a byte[]
            // Creazione del pacchetto con ip, porta e il messaggio
            DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
            // Invio del pacchetto
            try {
                socket.send(packet);
            } catch (IOException e) {
            }
        }
    }
}
