import java.io.IOException;
import java.net.*;

public class Ricevi implements Runnable {
    private DatagramSocket socket;
    private InetAddress ip; //InetAddress è il tipo per gli indirizzi ip
    private byte[] data = new byte[256];

    public Ricevi(int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket(port);
        this.ip = InetAddress.getByName("localhost");
    }

    public void receivePacket() throws IOException {
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // Metodo bloccante per ricevere il pacchetto
        socket.receive(packet);

        // Convertire da byte[] a String e stampa
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("[Ricevuto]: " + received);
    }

    @Override
    public void run() {
        do {
            try {
                this.receivePacket();
            } catch (IOException e) {
            }
        } while (true);
    }
}
