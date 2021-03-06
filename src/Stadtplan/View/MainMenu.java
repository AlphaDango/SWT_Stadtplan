package Stadtplan.View;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/*
* This is the Main menu GUI.
* In here the user can decide if they want
* to report an traffic accident or if they want
* to look up the current street status.
 */
public class MainMenu extends JFrame {

    private final JFrame welcomeFrame = new JFrame("Stadtplan-Goslar");

    public MainMenu(){
        //Init welcomeLabel
        JLabel welcomeLabel = new JLabel("Willkommen zum Stadtplan-Goslar");
        welcomeLabel.setBounds(80,10,450,300);
        welcomeLabel.setVerticalAlignment(JLabel.TOP);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        welcomeLabel.setPreferredSize(new Dimension(250, 100));
        welcomeLabel.setForeground(Color.blue);

        //Init showStreetNetworkButton
        JButton showStreetNetworkButton = new JButton("Straßeninfos");
        showStreetNetworkButton.setBounds(20,120,100, 40);
        showStreetNetworkButton.setSize(200, 50);

        //Init reportAccidentButton
        JButton reportAccidentButton = new JButton("Unfall melden");
        reportAccidentButton.setBounds(20,180,100, 40);
        reportAccidentButton.setSize(200, 50);

        //Init panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,900));
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