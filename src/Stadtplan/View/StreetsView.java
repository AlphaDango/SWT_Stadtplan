package Stadtplan.View;

import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.Model.Unfall;
import Stadtplan.Model.Verkehrsstoerung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StreetsView {
    private StreetNetwork streetNetwork = new StreetNetwork();
    private StrassenAbschnitt strassenAbschnitt;

    private final JFrame streetViewFrame = new JFrame("Stadtplan-Goslar");
    private final JLabel title = new JLabel("Straßenübersicht");
    private final JButton returnButton = new JButton("Zurück");
    private final JPanel panel = new JPanel();
    private final JLabel street0 = new JLabel(streetNetwork.getStreetNames().get(0));
    private final JLabel street1 = new JLabel(streetNetwork.getStreetNames().get(1));
    private final JLabel street2 = new JLabel(streetNetwork.getStreetNames().get(2));
    private JLabel street0Info, street1Info, street2Info;

    public StreetsView(){
        //Init panel
        panel.setPreferredSize(new Dimension(600,900));
        panel.setVisible(true);
        panel.setSize(200, 200);
        panel.setBounds(350, 80, 200, 200);

        //Init welcomeLabel
        title.setBounds(200,10,450,300);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        title.setPreferredSize(new Dimension(250, 100));
        title.setForeground(Color.blue);

        //Init streetlabels
        street0.setBounds(20,70,450,300);
        street0.setVerticalAlignment(JLabel.TOP);
        street0.setFont(new Font("Verdana", Font.PLAIN, 12));
        street0.setForeground(Color.black);

        strassenAbschnitt = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(0));
        if(strassenAbschnitt.getUnfall() == null){
            street0Info = new JLabel("Ist Einbahnstraße: "+strassenAbschnitt.isOneWay()+" | Keine Verkehrsstörungen vorhanden");
        }else{
            Unfall unfall = strassenAbschnitt.getUnfall();
            street0Info = new JLabel("Unfalllänge: "+unfall.getLength()+"m | Gesichert: "+unfall.isSecured());
        }
        street0Info.setBounds(20,90,450,300);
        street0Info.setVerticalAlignment(JLabel.TOP);
        street0Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street0Info.setForeground(Color.red);


        street1.setBounds(20,170,450,300);
        street1.setVerticalAlignment(JLabel.TOP);
        street1.setFont(new Font("Verdana", Font.PLAIN, 12));
        street1.setForeground(Color.black);

        strassenAbschnitt = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(1));
        if(strassenAbschnitt.getUnfall() == null){
            street1Info = new JLabel("Ist Einbahnstraße: "+strassenAbschnitt.isOneWay()+" | Keine Verkehrsstörungen vorhanden");
        }else{
            Unfall unfall = strassenAbschnitt.getUnfall();
            street1Info = new JLabel("Unfalllänge: "+unfall.getLength()+"m | Gesichert: "+unfall.isSecured());
        }
        street1Info.setBounds(20,190,450,300);
        street1Info.setVerticalAlignment(JLabel.TOP);
        street1Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street1Info.setForeground(Color.red);

        street2.setBounds(20,270,450,300);
        street2.setVerticalAlignment(JLabel.TOP);
        street2.setFont(new Font("Verdana", Font.PLAIN, 12));
        street2.setForeground(Color.black);

        strassenAbschnitt = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(2));
        if(strassenAbschnitt.getUnfall() == null){
            street2Info = new JLabel("Ist Einbahnstraße: "+strassenAbschnitt.isOneWay()+" | Keine Verkehrsstörungen vorhanden");
        }else{
            Unfall unfall = strassenAbschnitt.getUnfall();
            street2Info = new JLabel("Unfalllänge: "+unfall.getLength()+"m | Gesichert: "+unfall.isSecured());
        }
        street2Info.setBounds(20,290,450,300);
        street2Info.setVerticalAlignment(JLabel.TOP);
        street2Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street2Info.setForeground(Color.red);


        //Init returnButton
        returnButton.setBounds(460,320,100, 40);
        returnButton.setSize(100, 25);

        //Init the welcomeFrame
        streetViewFrame.add(returnButton);
        streetViewFrame.add(title);
        streetViewFrame.add(street0);
        streetViewFrame.add(street0Info);
        streetViewFrame.add(street1);
        streetViewFrame.add(street1Info);
        streetViewFrame.add(street2);
        streetViewFrame.add(street2Info);
        streetViewFrame.setSize(600,400);
        streetViewFrame.setLayout(null);
        streetViewFrame.setVisible(true);
        streetViewFrame.getContentPane().add(panel);

        //Listner
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeView();
                streetViewFrame.dispose();
            }
        });
        streetViewFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}