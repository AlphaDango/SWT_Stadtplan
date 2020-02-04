package Stadtplan.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.Controller.Controller;

/*
* GUI im wich the user is able to input
* data of a n traffic accident.
 */
public class ReportAccidentUI extends JFrame{

    private StreetNetwork streetNetwork = new StreetNetwork();
    private Controller controller = new Controller();

    private final JFrame reportAccident = new JFrame("Stadtplan-Goslar");
    private JComboBox<String> streetName = new JComboBox<>(streetNetwork.getStreetNames().toArray(new String[0]));
    private final JCheckBox isSecuredCheckBox = new JCheckBox("Ja");
    private JTextField lengthInput = new JTextField("",5);

    public ReportAccidentUI(){
        //Init title label
        JLabel title = new JLabel("Unfall melden");
        title.setBounds(180,20,450,300);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Verdana", Font.PLAIN, 25));
        title.setPreferredSize(new Dimension(250, 100));
        title.setForeground(Color.blue);

        //Init street dropdown
        JLabel chooseStreetLabel = new JLabel("Straßenname");
        chooseStreetLabel.setBounds(50,70,150,30);
        streetName.setVisible(true);
        streetName.setBounds(180,75,150,20);

        //Init isSecuredCheckbox
        JLabel isSafeLabel = new JLabel("Unfall gesichert?");
        isSafeLabel.setBounds(50,120,150,30);
        isSecuredCheckBox.setBounds(170,120,50,30);

        //Init buttons
        JButton submitButton = new JButton("Bestätigen");
        submitButton.setBounds(180,270,100,30);
        JButton backButton = new JButton("Verwerfen");
        backButton.setBounds(320,270,100,30);

        //Add textfield
        JLabel lengthLabel = new JLabel("Unfallänge:");
        lengthLabel.setBounds(50,170,150,30);
        lengthInput.setBounds(170,170,50,30);

        //Init reportAccident frame
        reportAccident.add(chooseStreetLabel);
        reportAccident.add(isSafeLabel);
        reportAccident.add(isSafeLabel);
        JLabel startNode = new JLabel("Startknoten:");
        reportAccident.add(startNode);
        JLabel endNode = new JLabel("Endknoten:");
        reportAccident.add(endNode);
        reportAccident.add(submitButton);
        reportAccident.add(lengthInput);
        reportAccident.add(lengthLabel);
        reportAccident.add(backButton);
        reportAccident.add(title);
        reportAccident.add(streetName);
        reportAccident.add(isSecuredCheckBox);
        reportAccident.setSize(600,400);
        reportAccident.setLayout(null);
        reportAccident.setLocationRelativeTo(null);
        reportAccident.setVisible(true);

        //Listeners
        submitButton.addActionListener(e -> {
            String name = Objects.requireNonNull(streetName.getSelectedItem()).toString();
            boolean sercured = isSecuredCheckBox.isSelected();
            if(!controller.reportTrafficAccident(name,lengthInput.getText(),sercured)){
                JOptionPane.showMessageDialog(null,
                        "Ungültige Längenangabe!\nBitte die Länge in ganzen Zahlen eingeben.");
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ihre Angaben wurden gespeichert.");
                new MainMenu();
                reportAccident.dispose();
            }
        });

        /*
        * Action listner of the backButton.
        * The user will be asked if he is sure to cancel his input.
         */
        backButton.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null,
                    "Möchtest du deine Angaben verwerfen?",null,JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                new MainMenu();
                reportAccident.dispose();
            }
        });

        reportAccident.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}