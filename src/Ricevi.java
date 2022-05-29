import java.io.IOException;
import java.net.*;

public class Ricevi implements Runnable { //Implementa Runnable per il multithreading
    private DatagramSocket socket; // Socket per la gestione dei pacchetti UDP
    private InetAddress ip; // InetAddress è il tipo per gli indirizzi ip
    private byte[] data = new byte[256]; // Array per i dati del pacchetto
    private ChatGUI frame; // GUI

    // Il costruttore riceve oltre la porta anche un oggetto ChatGUI in modo da richiamare il
    // metodo .addMessage per stampare il messaggio sulla GUI
    public Ricevi(int port, ChatGUI frame) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket(port); // Inizializzazione del socket con la porta
        this.ip = InetAddress.getByName("localhost");
        this.frame=frame;
    }

    public void receivePacket() throws IOException {
        // Creazione pacchetto vuoto per la ricezione
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // Metodo bloccante per ricevere il pacchetto
        socket.receive(packet);

        // Convertire da byte[] a String e stampa
        String received = new String(packet.getData(), 0, packet.getLength());

        //Aggiunge il messaggio appena ricevuto alla GUI
        this.frame.addMessage("[Ricevuto]: " + received);

        // System.out.println("[Ricevuto]: " + received);
    }

    @Override
    public void run() { // Metodo run in loop per la ricezione del pacchetto
        do {
            try {
                this.receivePacket();
            } catch (IOException e) {
            }
        } while (true);
    }
}
