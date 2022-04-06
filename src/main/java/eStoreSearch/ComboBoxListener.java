package eStoreSearch;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxListener implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    //text/scroll
    public static final int LINES = 15;
    public static final int CHAR_PER_LINE = 30;

    //create add panel
    public static JPanel addPanel = new JPanel();

    public static JLabel productType;
    //Labels for adding
    public static JLabel productTypeLabel;
    public static JLabel productIDLabel;
    public static JLabel descriptionLabel;
    public static JLabel priceLabel;
    public static JLabel makerLabel;
    public static JLabel authorLabel;
    public static JLabel publisherLabel;
    //combobox for product type
    public static String[] productOptions = {"book","electronics"};
    public static JComboBox productMenu;
    //text fields for adding
    public static JTextField productIDTextField;
    public static JTextField descriptionTextField;
    public static JTextField priceTextField;
    public static JTextField makerTextField;
    public static JTextField authorTextField;
    public static JTextField publisherTextField;
    //buttons for add and reset
    public static JButton addButton = new JButton("Add");
    public static JButton resetButton = new JButton("Reset");
    //error messages
    public static JLabel messagesLabel;
    public static JTextArea messagesTextArea;

    /*public ComboBoxListener() {

        super("eStoreSearch ComboBox");
        setSize(WIDTH, HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setLayout(new BorderLayout());

        //addPanel.setLayout(new BorderLayout());

        productMenu = new JComboBox(productOptions);
        productMenu.setSelectedIndex(0);
        productMenu.addActionListener(this);

        productType = new JLabel(productOptions[0]);
        //message.setFont(message.getFont().deriveFont(Font.ITALIC));
        //message.setHorizontalAlignment(JLabel.CENTER);
        add(productMenu,BorderLayout.WEST);
        //add(message,BorderLayout.CENTER);
        addProductPanel.add(productMenu);


    }*/
    public void actionPerformed(ActionEvent e){

        
        JComboBox cd = (JComboBox)e.getSource();
        String productOption = (String)cd.getSelectedItem();
        //productType.setText(productOption);
        
        if(productOption.equals ("book")){
            System.out.println(productOption);
        } else if (productOption.equals("electronics")){
            System.out.println(productOption);
        }

    }
}
