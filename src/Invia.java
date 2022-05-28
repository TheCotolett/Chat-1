import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Invia implements Runnable {
    private DatagramSocket socket;
    private InetAddress ip; //InetAddress è il tipo per gli indirizzi ip
    private byte[] data;
    private int port;

    public Invia(int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
        this.ip = InetAddress.getByName("localhost");
        if (port == 5555)
            this.port = 6666;
        else
            this.port = 5555;
    }

    public void sendPacket(String msg) {
        if (msg != null) {
            data = msg.getBytes(StandardCharsets.UTF_8); // Convertire da stringa a byte[]
            // Creazione del pacchetto con ip, porta e il messaggio
            DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
            // Invio del pacchetto
            try {
                socket.send(packet);
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void run() {
        String msg = "";
        do {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader read = new BufferedReader(input);
            try {
                msg = read.readLine();
            } catch (IOException e) {
            }
            this.sendPacket(msg);
        } while (true);
    }
}
