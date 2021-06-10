package com.javaguides.javaswing.login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class zipSearch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel introLabel;
    private JLabel searchLabel;
    private JLabel variantLabel;
    private JTextField textField;
    private JTextField textVarField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public zipSearch(String name) {
        setSize(250, 200);
        setResizable(false);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        introLabel = new JLabel("Velkommen til CoronaNet!");
        introLabel.setLocation(-15,5);
        introLabel.setSize(200, 20);
        introLabel.setHorizontalAlignment(0);
        contentPane.add(introLabel);

        searchLabel = new JLabel("Indsæt Postnummer:");
        searchLabel.setLocation(-5,30);
        searchLabel.setSize(150, 20);
        searchLabel.setHorizontalAlignment(0);
        contentPane.add(searchLabel);

        textField = new JTextField();
        textField.setLocation(50,50);
        textField.setSize(125, 20);
        contentPane.add(textField);

        variantLabel = new JLabel("Indsæt Variant: ");
        variantLabel.setLocation(5,70);
        variantLabel.setSize(100, 20);
        variantLabel.setHorizontalAlignment(0);
        contentPane.add(variantLabel);

        textVarField = new JTextField();
        textVarField.setLocation(50,90);
        textVarField.setSize(125, 20);
        contentPane.add(textVarField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(0, 80);
        buttonPanel.setSize(250, 70);
        contentPane.add(buttonPanel);

        JButton btnSearch = new JButton("Søg");
        btnSearch.setLocation(75, 40);
        btnSearch.setSize(75, 30);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String pstr = textField.getText();
                String var = textVarField.getText();
                try {
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_gui",
                            "root", "root");

                    PreparedStatement st = (PreparedStatement) con
                            .prepareStatement("Select count(*) from mutantsearch where zipcode=? and variant=?");

                    st.setString(1, pstr);
                    st.setString(2, var);
                    ResultSet rs = st.executeQuery();
                    rs.next();
                    int count = rs.getInt(1);
                    JOptionPane.showMessageDialog(btnSearch, "COVID-positive: " + count, "Resultat", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        });
        buttonPanel.add(btnSearch);
    }
}