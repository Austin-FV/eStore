package eStoreSearch;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Window extends JFrame implements ActionListener{

    public static boolean isNum(String string) {
        if (string.equals("")) {
            return true;
        } 
        try{
            double num = Double.parseDouble(string);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isYear(String string) {
        
        if (string.length() == 4 && isNum(string) == true){
            return true;
        } else if (string.equals("")){
            return true;
        } else if (string.length() != 4){
            return false;
        } else if (isNum(string) == false){
            return false;
        }

        return true;
    }

    public static void addYear(ArrayList<Product> products, ArrayList<Product> foundProducts,String year){
        int firstYear = 0;
        int secondYear = 0;
        int yearNum = 0;
        //year to year
        if (year.length() == 9) {

            firstYear = Integer.parseInt(year.substring(0, 4));
            secondYear = Integer.parseInt(year.substring(5,9));

            //2020-1900 or 1900-2020
            if (firstYear > secondYear){
                int temp = firstYear;
                firstYear = secondYear;
                secondYear = temp;
            }

            //Books

            for (int i = 0; i < products.size(); i++){

                if (products.get(i).getYear() >= firstYear && products.get(i).getYear() <= secondYear){
                    foundProducts.add(products.get(i));
                }
            }

            //other year cases
            //until year
        } else if (year.substring(0, 1).equals("-")){

            //everything less than year

            yearNum = Integer.parseInt(year.substring(1,5));

            for (int i=0; i < products.size(); i++){
                if (products.get(i).getYear() <= yearNum){
                    foundProducts.add(products.get(i));
                    
                }
            }
            
            //year onwards

        } else if (year.length() == 4){
            yearNum = Integer.parseInt(year);
            for (int i=0; i < products.size(); i++){
                if (yearNum == products.get(i).getYear()){
                    foundProducts.add(products.get(i));
                    
                }
            }
            
        } else if (year.substring(4, 5).equals("-")){

            //everything greater than year

            yearNum = Integer.parseInt(year.substring(0, 4));

            for (int i=0; i < products.size(); i++){
                if (products.get(i).getYear() >= yearNum){
                    foundProducts.add(products.get(i));
                    
                }
            }
            
        }
    }
    public static void removeYearIndex(ArrayList<Product> foundProducts,String year){
        int firstYear = 0;
        int secondYear = 0;
        int yearNum = 0;
        if (year.length() == 9) {

            //Books
            firstYear = Integer.parseInt(year.substring(0, 4));
            secondYear = Integer.parseInt(year.substring(5,9));

            //2020-1900 or 1900-2020
            if (firstYear > secondYear){
                int temp = firstYear;
                firstYear = secondYear;
                secondYear = temp;
            }

            for (int i = 0; i < foundProducts.size(); i++){

                if (!(foundProducts.get(i).getYear() >= firstYear && foundProducts.get(i).getYear() <= secondYear)){
                    foundProducts.remove(i);
                    i--;
                }
            }

            
            //other year cases
        } else if (year.substring(0, 1).equals("-")){

            //everything less than year

            yearNum = Integer.parseInt(year.substring(1,5));

            for (int i=0; i < foundProducts.size(); i++){
                if ((yearNum < foundProducts.get(i).getYear())){
                    foundProducts.remove(i);
                    i--;
                }
            }
            
        } else if (year.length() == 4){
            yearNum = Integer.parseInt(year);
            for (int i=0; i < foundProducts.size(); i++){
                if (!(yearNum == foundProducts.get(i).getYear())){
                    foundProducts.remove(i);
                    i--;
                }
            }
            
        } else if (year.substring(4, 5).equals("-")){

            //everything greater than year

            yearNum = Integer.parseInt(year.substring(0, 4));

            for (int i=0; i < foundProducts.size(); i++){
                if ((yearNum > foundProducts.get(i).getYear())){
                    foundProducts.remove(i);
                    i--;
                }
            }
            
        }
    }

    public static void removeIDIndex(ArrayList<Product> foundProducts,String productID){
        for (int i = 0; i<foundProducts.size(); i++){
            if ( !((productID).equals(foundProducts.get(i).getProductID())) ){
                foundProducts.remove(i);
                i--;
            }
        }
    }

    public static void addID(ArrayList<Product> products, ArrayList<Product> foundProducts,String productID){
        for (int i = 0; i<products.size(); i++){
            if ((productID).equals(products.get(i).getProductID())){
                foundProducts.add(products.get(i));
            }
        }
    }

    public static ArrayList<Product> products = new ArrayList<Product>(1);
    public static HashMap<String, ArrayList<Integer>> index = new HashMap<String, ArrayList<Integer>>();

    private class comboBoxL implements ActionListener{

        public void actionPerformed(ActionEvent e){
            //makerTextField.setVisible(false);
            JComboBox cd = (JComboBox)e.getSource();
            String productOption = (String)cd.getSelectedItem();
            productType.setText(productOption);
            
            if(productOption.equals ("book")){
                makerTextField.setVisible(false);
                authorTextField.setVisible(true);
                publisherTextField.setVisible(true);

            } else if (productOption.equals("electronics")){
                makerTextField.setVisible(true);
                authorTextField.setVisible(false);
                publisherTextField.setVisible(false);
            } else {
                makerTextField.setVisible(true);
                authorTextField.setVisible(true);
                publisherTextField.setVisible(true);
            }
        }

    }
    
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    //text/scroll
    public static final int LINES = 7;
    public static final int CHAR_PER_LINE = 15;

    //create add panel
    public static JPanel addPanel = new JPanel();
    public static JPanel addProductPanel = new JPanel();
    //Labels for adding
    public static JLabel productType;
    public static JLabel productTypeLabel = new JLabel("Type: ");
    public static JLabel productIDLabel = new JLabel("Product ID: ");
    public static JLabel descriptionLabel = new JLabel("Description: ");
    public static JLabel priceLabel = new JLabel("Price: ");
    public static JLabel makerLabel = new JLabel("Maker: ");
    public static JLabel authorLabel = new JLabel("Author(s): ");
    public static JLabel publisherLabel = new JLabel("Publisher: ");
    //combobox for product type
    public static String[] productOptions = {"book","electronics"};
    //public static String productType;
    public static JComboBox productMenu;
    //text fields for adding
    public static JTextField productIDTextField;
    public static JTextField descriptionTextField;
    public static JTextField priceTextField;
    public static JTextField makerTextField;
    public static JTextField authorTextField;
    public static JTextField publisherTextField;
    public static JTextField yearTextField;
    //buttons for add and reset
    public static JButton addButton = new JButton("Add");
    public static JButton resetButton = new JButton("Reset");
    //error messages
    public static JLabel messagesLabel = new JLabel("messages: ");
    public static JTextArea messagesTextArea;
    public static JScrollPane scrolledText;

    JLabel message;

    public Window(){

        //can also be used to set title
        super("eStoreSearch");
        setSize(WIDTH, HEIGHT);

        //button that outputs to terminal
        /*JButton testButton = new JButton("Hi");
        MyListener ear = new MyListener();
        testButton.addActionListener(ear);
        add(testButton);*/

        //can close with x on top
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //can be n/s/e/w/center
        setLayout(new BorderLayout());

        JMenu commandMenu = new JMenu("Commands");

        JMenuItem addChoice = new JMenuItem("Add Product");
        addChoice.addActionListener(this);
        commandMenu.add(addChoice);

        JMenuItem searchChoice = new JMenuItem("Search Product");
        searchChoice.addActionListener(this);
        commandMenu.add(searchChoice);

        JMenuItem quitChoice = new JMenuItem("Quit Program");
        quitChoice.addActionListener(this);
        commandMenu.add(quitChoice);

        JMenuBar bar = new JMenuBar();
        bar.add(commandMenu);
        setJMenuBar(bar);

        //welcome message
        message = new JLabel("<html>Welcome to eStoreSearch <br/> Choose a command from the \"commands\" menu above for<html>" + 
        "<html> adding a product, search products, or quitting the program<html>");
        message.setFont(message.getFont().deriveFont(Font.ITALIC));
        message.setHorizontalAlignment(JLabel.CENTER);
        add(message,BorderLayout.CENTER); //behind text area, make a whole new panel just for messages

        //setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        //ADD PRODUCT STUFF
        //addProductPanel.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));        
        
        //combobox for products
        productMenu = new JComboBox(productOptions);
        productMenu.setSelectedIndex(0);
        productMenu.addActionListener(new comboBoxL());

        productType = new JLabel(productOptions[0]);

        addProductPanel.setLayout(new BoxLayout(addProductPanel,BoxLayout.Y_AXIS));
        //message.setFont(message.getFont().deriveFont(Font.ITALIC));
        //message.setHorizontalAlignment(JLabel.CENTER);

        //add(productMenu,BorderLayout.WEST);

        //add(message,BorderLayout.CENTER);
        addProductPanel.add(productMenu);

        productIDTextField = new JTextField("Product ID ", 15);
        descriptionTextField = new JTextField("Description ", 15);
        yearTextField = new JTextField("Year ",15);
        priceTextField = new JTextField("Price ", 15);
        makerTextField = new JTextField("Maker ", 15);
        authorTextField = new JTextField("Author ", 15);
        publisherTextField = new JTextField("Publisher ", 15);
        addProductPanel.add(productIDTextField);
        addProductPanel.add(descriptionTextField);
        addProductPanel.add(yearTextField);
        addProductPanel.add(priceTextField);
        addProductPanel.add(authorTextField);
        addProductPanel.add(publisherTextField);
        addProductPanel.add(makerTextField);

        //makerTextField.setVisible(false);
        //addProductPanel.setLayout(new BorderLayout());
        //add labels and jtext


        add(addProductPanel,BorderLayout.WEST);
        
        addPanel.setLayout(new BoxLayout(addPanel,BoxLayout.Y_AXIS));
        addButton.addActionListener(this);
        addPanel.add(addButton);
        resetButton.addActionListener(this);
        addPanel.add(resetButton);

        add(addPanel,BorderLayout.EAST);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.BLUE);

        messagesTextArea = new JTextArea(LINES, CHAR_PER_LINE);
        messagesTextArea.setBackground(Color.WHITE);

        scrolledText = new JScrollPane(messagesTextArea);
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(scrolledText);

        add(messagesLabel,BorderLayout.SOUTH);
        add(scrolledText,BorderLayout.SOUTH);

        

        addPanel.setVisible(false);
        addProductPanel.setVisible(false);
        messagesTextArea.setVisible(false);
        scrolledText.setVisible(false);
        messagesTextArea.setEditable(false);
    }

    public void actionPerformed(ActionEvent e){
        //addPanel.setVisible(false);
        //AddWindow aw = new AddWindow();

       
        //Combo Boxes for product 
        /*
        JComboBox cd = (JComboBox)e.getSource();
        String productOption = (String)cd.getSelectedItem();
        productType.setText(productOption);
        */
        
        String commandOption = e.getActionCommand();

        if(commandOption.equals("Add Product")){
            message.setText("add");
            addPanel.setVisible(true);
            addProductPanel.setVisible(true);
            messagesTextArea.setVisible(true);
            scrolledText.setVisible(true);
            
            //make new listener
            //ComboBoxListener.actionPerformed(new ActionEvent());
            
            /*
            JComboBox cd = (JComboBox)e.getSource();
            String productOption = (String)cd.getSelectedItem();
            productType.setText(productOption);
            System.out.println(productOption);*/

        } else if (commandOption.equals("Search Product")){
            addPanel.setVisible(false);
            addProductPanel.setVisible(false);
            messagesTextArea.setVisible(true);
            message.setText("<html>search<br/>Shows all products added when started");
            scrolledText.setVisible(true);

            String output = "";
            for (int i = 0; i < products.size();i++){
                output = output + products.get(i).fileToString();
            }

            messagesTextArea.setText(output);


        } else if (commandOption.equals("Quit Program")){
            System.exit(0);
        } else if (commandOption.equals("Reset")) {
            messagesTextArea.setText("");
            productIDTextField.setText("Product ID");
            yearTextField.setText("Year");
            priceTextField.setText("Price");
            descriptionTextField.setText("Description");
            makerTextField.setText("Maker");
            authorTextField.setText("Author(s)");
            publisherTextField.setText("Publisher");

        } else if (commandOption.equals("Add")){
            //copy over code from previous main and print to messagesTextArea
            //first must gettext for each case
            String productIDString = productIDTextField.getText();
            String descriptionString = descriptionTextField.getText();
            String priceString = priceTextField.getText();
            String yearString = yearTextField.getText();

            String authorString = authorTextField.getText();
            String publisherString = publisherTextField.getText();
            String makerString = makerTextField.getText();

            boolean errorFound = false;

            if((!isNum(productIDString)) || productIDString.equals("") || (productIDString.length() < 6)){
                messagesTextArea.setText("Enter a valid ProductID, must be a number that contains 6 digits");
                errorFound = true;
            }

            if (descriptionString.equals("")){
                messagesTextArea.setText("\nCan't leave blank.\nEnter Description of Product: ");
                errorFound = true;
            }

            for (int i = 0; i < products.size();i++){
                if (productIDString.equals(products.get(i).getProductID())){
                    messagesTextArea.setText("Duplicate Product ID.");
                    errorFound = true;
                }
            }

            if (!isNum(yearString) || yearString.length() != 4){
                messagesTextArea.setText("\nEnter a valid Year (1000 - 9999) ");
                errorFound = true;
            }

            double priceNum = 0;
            if (!isNum(priceString)){
                messagesTextArea.setText("\nEnter a valid price.\n(leave blank to set price to $0.00)");
                errorFound = true;
            } else {
                if(priceString.equals("")){
                    priceNum = 0.0;
                } else {
                    priceNum = Double.parseDouble(priceString);
                }
            }           
            

            if (productType.getText().equals("book") && errorFound == false){
                try {
                    Book newBook = new Book(productIDString,descriptionString,priceNum,Integer.parseInt(yearString),authorString,publisherString);
                    products.add(newBook);
                    messagesTextArea.setText("Successfully added new Book.");
                }                
                catch (Exception ex){
                    messagesTextArea.setText(ex.getMessage());
                }
                //System.out.println(newBook.toString());
                
            }

            if (productType.getText().equals("electronics") && errorFound == false){
                try{
                    Electronics newE = new Electronics(productIDString,descriptionString,priceNum,Integer.parseInt(yearString),makerString);
                    products.add(newE);          
                    messagesTextArea.setText("Successfully added new Electronic.");      
                } catch (Exception ex){
                    messagesTextArea.setText(ex.getMessage());
                }
                
                //System.out.println(newBook.toString());
                
            }

            
            
        }
        

    }
    
}