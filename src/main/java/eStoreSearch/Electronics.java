package eStoreSearch;

import java.util.*;

/**
 * Electronics Class that contains variables for:
 * productID, description, price, year and maker
 */
public class Electronics extends Product{
    
    private String maker;

    /**
     * Default Constructor for Electronics Class
     */
    public Electronics() {
        super();
        maker = "";
    }

    /**
     * Constructor for Electronics Class that takes in various parameters to be stored
     * @param productID prodictID of Electronics
     * @param description description of Electronics
     * @param price price of Electronics
     * @param year year Electronics was created
     * @param maker maker of Electronics
     */
    public Electronics(String productID, String description, double price, int year, String maker) throws Exception{
        super(productID,description,price,year);
        
        this.maker = maker;
    }

    /**
     * Get maker for Electronics Class
     * @return String maker
     */
    public String getMaker(){
        return maker;
    }

    /**
     * Set the maker from parameter
     * @param maker
     */
    public void setMaker(String maker){
        this.maker = maker;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.maker;
    }

    @Override
    public String fileToString(){
        if (this.maker.equals("")){
            this.maker = "n/a";
        }
        return "\ntype = \"electronics\"\n" + super.fileToString() + "\nmaker = \"" + this.maker + "\"";
    }

    /**
     * A Print Function that prints all relevant Electronics Class information
     */
    @Override
    public void print(){
        System.out.println("\n------------------");
        System.out.println("Electronic Product");
        super.print();
        System.out.println("Maker: \t\t" + this.maker);
        System.out.println("------------------\n");

    }

    @Override
    public boolean equals(Object p){
         
        if (p == null || p.getClass() != this.getClass()) {
            return false;
        }
        Electronics e = (Electronics) p;
        return (productID).equals(e.productID) && (description).equals(e.description) && (year) == (e.year) && (price) == (e.price) && (maker).equals(e.maker);
    }

}