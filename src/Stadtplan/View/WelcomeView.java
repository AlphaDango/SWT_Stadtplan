package Stadtplan.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class WelcomeView extends JFrame {

    private final JFrame welcomeFrame = new JFrame("Stadtplan-Goslar");
    private final JLabel welcomeLabel = new JLabel("Willkommen zum Stadtplan-Goslar");
    private final JButton showStreetNetworkButton = new JButton("Straßennetz Anzeigen");
    private final JButton reportAccidentButton = new JButton("Unfall Melden");
    private final ImageIcon ii = new ImageIcon();
    private final JLabel image_label= new JLabel(ii);
    private final JPanel panel = new JPanel();

    public WelcomeView(){
        //Init welcomeLabel
        welcomeLabel.setBounds(80,10,450,300);
        welcomeLabel.setVerticalAlignment(JLabel.TOP);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        welcomeLabel.setPreferredSize(new Dimension(250, 100));
        welcomeLabel.setForeground(Color.blue);

        //Init showStreetNetworkButton
        showStreetNetworkButton.setBounds(20,120,100, 40);
        showStreetNetworkButton.setSize(200, 50);

        //Init reportAccidentButton
        reportAccidentButton.setBounds(20,180,100, 40);
        reportAccidentButton.setSize(200, 50);

        //Init panel
        panel.setPreferredSize(new Dimension(600,900));
        panel.add(image_label);
        panel.setVisible(true);
        panel.setSize(200, 200);
        panel.setBounds(350, 80, 200, 200);

        //Init the welcomeFrame
        welcomeFrame.add(showStreetNetworkButton);
        welcomeFrame.add(reportAccidentButton);
        welcomeFrame.add(welcomeLabel);
        welcomeFrame.setSize(600,400);
        welcomeFrame.setLayout(null);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
        welcomeFrame.setResizable(false);
        welcomeFrame.getContentPane().add(panel);

        //Listener
        welcomeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        reportAccidentButton.addActionListener(e -> {
            new ReportAccidentUI();
            welcomeFrame.dispose();
        });
        showStreetNetworkButton.addActionListener(e -> {
            new StreetsView();
            welcomeFrame.dispose();
        });
    }
}