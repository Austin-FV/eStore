package eStoreSearch;

import java.util.*;

/**
 * Electronics Class that contains variables for:
 * productID, description, price, year and maker
 */
public class Product {
    protected String productID;
    protected String description;
    protected double price;
    int year;
    //String maker;

    /**
     * Default Constructor for Electronics Class
     */
    public Product() {
        productID = "";
        description = "";
        price = 0.0;
        year = 0;
        //maker = "";
    }

    /**
     * Constructor for Electronics Class that takes in various parameters to be stored
     * @param productID prodictID of Electronics
     * @param description description of Electronics
     * @param price price of Electronics
     * @param year year Electronics was created
     * @param maker maker of Electronics
     */
    public Product(String productID, String description, double price, int year) throws Exception{
        if (!(productID.isEmpty() || description.isEmpty() || price < 0 || year < 1000)){
            this.productID = productID;
            this.description = description;
            this.price = price;
            this.year = year;
        } else {
            throw new Exception("Fatal Error: Mandatory Values for ProductID, Description, Price or Year are incorrect.");
        }
        
        //this.maker = maker;
    }

    /**
     * Get Product ID for Electronics Class
     * @return integer productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Get description for Electronics Class
     * @return String description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Get price for Electronics Class
     * @return double price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Get year for Electronics Class
     * @return int year
     */
    public int getYear(){
        return year;
    }

    

    /**
     * Set the productID from parameter
     * @param productID
     */
    public void setProductID(String productID){
        this.productID = productID;
    }

    /**
     * Set the description from parameter
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Set the price from parameter
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    } 

    /**
     * Set the year from parameter
     * @param year
     */
    public void setYear(int year){
        this.year = year;
    }

    @Override
    public String toString(){
        return this.productID + " " + this.description + " " + this.year + " " + this.price;
    } 
    
    public void print(){
        
        System.out.println("Product ID: \t" + this.productID);
        System.out.println("Description: \t" + this.description);
        System.out.println("Year: \t\t" + this.year);
        System.out.format("Price: \t\t$ %.2f\n", this.price);
        
    }

    public String fileToString(){
        return "productID = \"" + productID + "\"\ndescription = \"" + description + "\"\nprice = \"" + price + "\"\nyear = \"" + year + "\"";
    }

    @Override
    public boolean equals(Object prod){
         
        if (prod == null || prod.getClass() != this.getClass()) {
            return false;
        }
        Product p = (Product) prod;
        return (productID).equals(p.productID) && (description).equals(p.description) && (year) == (p.year) && (price) == (p.price);
    }

}