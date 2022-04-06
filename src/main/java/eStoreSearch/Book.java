package eStoreSearch;

import java.util.*;

/**
 * Book class that contains variables for: 
 * productID, description, price, year, authors and publisher
 */
public class Book extends Product{
    
    private String authors;
    private String publisher;

    /**
     * Default Constructor for Book Class
     */
    public Book() {
        super();
        authors = "";
        publisher = "";
    }

    /**
     * Constructor for Book Class that takes in various parameters to be strored
     * @param productID productID of Book
     * @param description description of Book
     * @param price price of Book
     * @param year year book was published
     * @param authors authors of Book
     * @param publisher publisher of Book
     */
    public Book(String productID, String description, double price, int year, String authors, String publisher) throws Exception {
        super(productID,description,price,year);
        
        this.authors = authors;
        this.publisher = publisher;
    }
    
    
    /**
     * Get the ArrayList of authors in Book Class
     * @return ArrayList<String> of authors
     */
    public String getAuthors(){
        return authors;
    }

    /**
     * Get the publisher of Book Class
     * @return String publisher
     */
    public String getPublisher(){
        return publisher;
    }
    
    
    /**
     * Set the publisher from parameter
     * @param publisher
     */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    /**
     * Set the authors from parameter
     * This adds a new author to the ArrayList already created in Book
     * @param authors
     */
    public void setAuthors(String authors){
        this.authors = authors;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.authors + " " + this.publisher;
    }

    @Override
    public String fileToString(){
        if (this.authors.equals("")){
            this.authors = "n/a";
        }
        if (this.publisher.equals("")){
            this.publisher = "n/a";
        }
        return "\ntype = \"book\"\n" + super.fileToString() + "\nauthors = \"" + this.authors + "\"\npublisher = \"" + this.publisher + "\"";
    }

    /**
     * A Print Function that prints all relevant Book Class information
     */
    @Override
    public void print(){

        System.out.println("\n------------------");
        System.out.println("Book Product");
        super.print();        
        System.out.println("Author(s): \t" + this.authors);        
        System.out.println("Publisher: \t" + this.publisher);
        System.out.println("------------------\n");

    }

    
    @Override
    public boolean equals(Object p){        
         
        if (p == null || p.getClass() != this.getClass()) {
            return false;
        }
        Book b = (Book) p;
        return (productID).equals(b.productID) && (description).equals(b.description) && (year) == (b.year) && (price) == (b.price) && (authors).equals(b.authors) && (publisher).equals(b.publisher);
    }

}