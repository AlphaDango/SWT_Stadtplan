package Stadtplan.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.Controller.Controller;


public class ReportAccidentUI extends JFrame{

    private StreetNetwork streetNetwork = new StreetNetwork();
    private Controller controller = new Controller();
    private String[] streetNames = { "Sesame Street", "15 Yemen Road", "Diagon Alley" };
    private String[] startNodes = { "1", "2", "3", "4", "5" };
    private String[] endNodes = { "1", "2", "3", "4", "5" };

    private final JFrame reportAccident = new JFrame("Stadtplan-Goslar");
    private final JLabel title=new JLabel("Unfall Melden");
    private final JLabel chooseStreetLabel=new JLabel("Straßenname");
    private JComboBox<String> streetName = new JComboBox<String>(streetNetwork.getStreetNames().toArray(new String[0]));
    private JComboBox<String> endNode = new JComboBox<String>(endNodes);
    private JComboBox<String> startNode = new JComboBox<String>(startNodes);
    private final JLabel isSafeLabel = new JLabel("Unfall gesichert?");
    private final JLabel StartNode=new JLabel("Startknoten:");
    private final JLabel EndNode=new JLabel("Endknoten:");
    private final JCheckBox isSecuredCheckBox = new JCheckBox("Ja");
    private final JButton submitButton=new JButton("Bestätigen");
    private final JButton backButton=new JButton("Zurück");
    private ButtonGroup buttonGroup = new ButtonGroup();



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

        //Init node dropdown
        StartNode.setBounds(50,130,250,100);
        startNode.setVisible(true);
        startNode.setBounds(120,170,50,20);
        EndNode.setBounds(200,130,250,100);
        endNode.setVisible(true);
        endNode.setBounds(270,170,50,20);

        //Init buttons
        submitButton.setBounds(180,270,100,30);
        backButton.setBounds(320,270,100,30);

        //Checkbox added to buttonGroup (but why?)
        buttonGroup.add(isSecuredCheckBox);

        //Init reportAccident frame
        reportAccident.add(chooseStreetLabel);
        reportAccident.add(isSafeLabel);
        reportAccident.add(isSafeLabel);
        reportAccident.add(StartNode);
        reportAccident.add(EndNode);
        reportAccident.add(submitButton);
        reportAccident.add(backButton);
        reportAccident.add(title);
        reportAccident.add(streetName);
        reportAccident.add(startNode);
        reportAccident.add(endNode);
        reportAccident.add(isSecuredCheckBox);
        reportAccident.setSize(600,400);
        reportAccident.setLayout(null);//using no layout managers
        reportAccident.setVisible(true);//making the frame visible

        //Pfft I dunno. The fuck is this for?
        ButtonModel buttonModel = isSecuredCheckBox.getModel();

        //Listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String name = streetName.getSelectedItem().toString();
                    boolean sercured = isSecuredCheckBox.isSelected();
                    StrassenAbschnitt strassenAbschnitt = streetNetwork.getStreetByName(name);
                    if(strassenAbschnitt == null){
                        JOptionPane.showMessageDialog(submitButton,
                                "Fehler!");
                        return;
                    }
                    controller.addUnfall(strassenAbschnitt,10,sercured);
                    System.out.println(name+"\nIs Secured: "+sercured);
                    JOptionPane.showMessageDialog(submitButton,
                            "Ihre Angaben wurden gespeichert.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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