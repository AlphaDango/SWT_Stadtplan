package Stadtplan.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.Controller.Controller;


public class ReportAccidentUI extends JFrame{

    private StreetNetwork streetNetwork = new StreetNetwork();
    private Controller controller = new Controller();

    private final JFrame reportAccident = new JFrame("Stadtplan-Goslar");
    private final JLabel title = new JLabel("Unfall Melden");
    private final JLabel chooseStreetLabel = new JLabel("Straßenname");
    private JComboBox<String> streetName = new JComboBox<>(streetNetwork.getStreetNames().toArray(new String[0]));
    private final JLabel isSafeLabel = new JLabel("Unfall gesichert?");
    private final JLabel StartNode = new JLabel("Startknoten:");
    private final JLabel EndNode = new JLabel("Endknoten:");
    private final JLabel lengthLabel = new JLabel("Unfallänge:");
    private final JCheckBox isSecuredCheckBox = new JCheckBox("Ja");
    private final JButton submitButton=new JButton("Bestätigen");
    private final JButton backButton = new JButton("Verwerfen");
    private JTextField lengthInput = new JTextField("",5);

    public ReportAccidentUI(){
        //Init title
        title.setBounds(180,20,450,300);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Verdana", Font.PLAIN, 25));
        title.setPreferredSize(new Dimension(250, 100));
        title.setForeground(Color.blue);

        //Init street dropdown
        chooseStreetLabel.setBounds(50,70,150,30);
        streetName.setVisible(true);
        streetName.setBounds(180,75,150,20);

        //Init isSecuredCheckbox
        isSafeLabel.setBounds(50,120,150,30);
        isSecuredCheckBox.setBounds(170,120,50,30);

        //Init buttons
        submitButton.setBounds(180,270,100,30);
        backButton.setBounds(320,270,100,30);

        //Add textfield
        lengthLabel.setBounds(50,170,150,30);
        lengthInput.setBounds(170,170,50,30);

        //Init reportAccident frame
        reportAccident.add(chooseStreetLabel);
        reportAccident.add(isSafeLabel);
        reportAccident.add(isSafeLabel);
        reportAccident.add(StartNode);
        reportAccident.add(EndNode);
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
            String name = streetName.getSelectedItem().toString();
            boolean sercured = isSecuredCheckBox.isSelected();
            if(!controller.reportAccident(name,lengthInput.getText(),sercured)){
                JOptionPane.showMessageDialog(null,
                        "Ungültige Längenangabe!\nBitte die Länge in ganzen Zahlen eingeben.");
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ihre Angaben wurden gespeichert.");
                new WelcomeView();
                reportAccident.dispose();
            }
        });

        backButton.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null,"Möchtest du deine Angaben verwerfen?",null,JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                new WelcomeView();
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