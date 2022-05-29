import javax.swing.*;
import java.awt.*;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatGUI extends JFrame{
    private JButton sendButton;
    private JPanel mainPanel;
    private JPanel typingPanel;
    private JLabel messageArea;
    private JTextField typingArea;
    private String typedText;

    public ChatGUI (String title, int port){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        this.setMinimumSize(new Dimension(150, 400)); // Dimensione minima in pixel
        this.setContentPane(mainPanel);
        this.pack(); // Il metodo pack ridimensiona la cornice in modo che tutto
                    // il suo contenuto sia uguale o superiore alle dimensioni preferite

        // Ascolto per azioni sul bottone per inviare
        // Viene eseguito il contenuto ogni volta che si interagisce
        sendButton.addActionListener(e -> { // Metodo Lambda
            typedText = typingArea.getText(); // Salva ciò che è stato scritto in variabile
            try {
                Invia invia = new Invia(port); // Instanziazione della classe Invia
                invia.sendPacket(typedText); // Invio del pacchetto
            } catch (SocketException ex) {} catch (UnknownHostException ex) {}
            addMessage(typedText); // Aggiunta di ciò che è stato scritto nella chat
            typingArea.setText(""); // Reset dell'area dove si scrive
        });
    }

    // Metodo per aggiungere il messaggio agli altri ricevuti nella chat
    public void addMessage(String msg){
        this.messageArea.setText("<html>"+this.messageArea.getText()+"<br>"+msg+"<html>");
    }
}
