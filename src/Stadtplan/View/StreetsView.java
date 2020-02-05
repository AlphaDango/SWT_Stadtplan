package Stadtplan.View;

import Stadtplan.Model.StreetSection;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.Model.TrafficAccident;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* This is the StreetView GUI.
* In this GUI the user can see the
* current street status.
 */
public class StreetsView implements Observer {

    private final JFrame streetViewFrame = new JFrame("Stadtplan-Goslar");
    StreetNetwork streetNetwork = new StreetNetwork();
    JLabel street0Info, street1Info, street2Info;

    public StreetsView(){
        new StreetSection().Attach(this);
        //Init panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,900));
        panel.setVisible(true);
        panel.setSize(200, 200);
        panel.setBounds(350, 80, 200, 200);

        //Init welcomeLabel
        JLabel title = new JLabel("Straßenübersicht");
        title.setBounds(200,10,450,300);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        title.setPreferredSize(new Dimension(250, 100));
        title.setForeground(Color.blue);

        //Init streetlabels
        JLabel street0 = new JLabel(streetNetwork.getStreetNames().get(0) + ":");
        street0.setBounds(20,70,450,300);
        street0.setVerticalAlignment(JLabel.TOP);
        street0.setFont(new Font("Verdana", Font.PLAIN, 12));
        street0.setForeground(Color.black);

        StreetSection streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(0));
        if(streetSection.getTrafficAccident() == null){
            street0Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Keine Verkehrsstörungen vorhanden");
        }else{
            TrafficAccident trafficAccident = streetSection.getTrafficAccident();
            street0Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
        }
        street0Info.setBounds(20,90,450,300);
        street0Info.setVerticalAlignment(JLabel.TOP);
        street0Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street0Info.setForeground(Color.red);


        JLabel street1 = new JLabel(streetNetwork.getStreetNames().get(1) + ":");
        street1.setBounds(20,170,450,300);
        street1.setVerticalAlignment(JLabel.TOP);
        street1.setFont(new Font("Verdana", Font.PLAIN, 12));
        street1.setForeground(Color.black);

        streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(1));
        if(streetSection.getTrafficAccident() == null){
            street1Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Keine Verkehrsstörungen vorhanden");
        }else{
            TrafficAccident trafficAccident = streetSection.getTrafficAccident();
            street1Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
        }
        street1Info.setBounds(20,190,450,300);
        street1Info.setVerticalAlignment(JLabel.TOP);
        street1Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street1Info.setForeground(Color.red);

        JLabel street2 = new JLabel(streetNetwork.getStreetNames().get(2) + ":");
        street2.setBounds(20,270,450,300);
        street2.setVerticalAlignment(JLabel.TOP);
        street2.setFont(new Font("Verdana", Font.PLAIN, 12));
        street2.setForeground(Color.black);

        streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(2));
        if(streetSection.getTrafficAccident() == null){
            street2Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Keine Verkehrsstörungen vorhanden");
        }else{
            TrafficAccident trafficAccident = streetSection.getTrafficAccident();
            street2Info = new JLabel("Einbahnstraße: "+ streetSection.isOneWay()+
                    " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
        }
        street2Info.setBounds(20,290,450,300);
        street2Info.setVerticalAlignment(JLabel.TOP);
        street2Info.setFont(new Font("Verdana", Font.PLAIN, 10));
        street2Info.setForeground(Color.red);


        //Init returnButton
        JButton returnButton = new JButton("Zurück");
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
        streetViewFrame.setLocationRelativeTo(null);
        streetViewFrame.setVisible(true);
        streetViewFrame.setResizable(false);
        streetViewFrame.getContentPane().add(panel);

        //Listner
        returnButton.addActionListener(e -> {
            new MainMenu();
            new StreetSection().Detach(this);
            streetViewFrame.dispose();
        });
        streetViewFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void update(Object obj) {
        if(obj instanceof StreetSection){
            StreetSection streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(0));
            if(streetSection.getTrafficAccident() == null){
                street0Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Keine Verkehrsstörungen vorhanden");
            }else{
                TrafficAccident trafficAccident = streetSection.getTrafficAccident();
                street0Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
            }
            //street0Info.repaint();
            streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(1));
            if(streetSection.getTrafficAccident() == null){
                street1Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Keine Verkehrsstörungen vorhanden");
            }else{
                TrafficAccident trafficAccident = streetSection.getTrafficAccident();
                street1Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
            }
            //street1Info.repaint();
            streetSection = streetNetwork.getStreetByName(streetNetwork.getStreetNames().get(2));
            if(streetSection.getTrafficAccident() == null){
                street2Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Keine Verkehrsstörungen vorhanden");
            }else{
                TrafficAccident trafficAccident = streetSection.getTrafficAccident();
                street2Info.setText("Einbahnstraße: "+ streetSection.isOneWay()+
                        " | Unfalllänge: "+ trafficAccident.getLength()+"m | Gesichert: "+ trafficAccident.isSecured());
            }
            //street2Info.repaint();
            //streetViewFrame.repaint();
        }
    }
}