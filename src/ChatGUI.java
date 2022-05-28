import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typedText = typingArea.getText();
                try {
                    Invia invia = new Invia(port);
                    invia.sendPacket(typedText);
                } catch (SocketException ex) {} catch (UnknownHostException ex) {}
            }
        });
    }

    public String getTypedText() {
        return typedText;
    }
}
