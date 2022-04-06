# eStore

Problem to be Solved:
A problem being solved in this assignment is using GUI, exceptions and understanding polymorphism.
In this program the general problem I am trying to solve is organizing Class Objects in ArrayLists.
The program has two types of products: books and electronics. Both the Book and Electronics class are extensions of the parent Product Class. 
The program shall be able to add objects into a list that contains all products.
Each Book and Electronic Class contains ProductID, Year, Description and Price.
However Book has unique variables authors and publisher while Electronics has a maker variable.
The program shall be able to add new Book or Electronics Classes into the main ArrayList.
When searching through the products, a HashMap of indexes was created to greatly reduce search time and amount of code.


Assumptions and Limitations:
    The eStoreSearch program limitations: 
        Values in years cannot go past 9999 or below 1000
        
    The eStoreSearch program assumptions:
        Assumes positive values for most cases

User Guide:
When program starts a menu is shown that allows the user to pick either Add, Search or Quit.
If Add is chosen the user can choose to either add a Book product or a Electronics product.
Each product will require the user to input productID, year, description and price.
However depending on the choice, if the user picked Book then it will ask for authors and publisher.
If the user picked Electronics then it will ask for maker. 
Note: no duplicate productID's are allowed
Returns to Menu.
Next there is a Search which allows the user to search by productID, year or keywords.
It can use either one, two or all the fields. If enter is pressed for each field (left blank) then results in printing all products.
Then program prints found products that match search fields.
Returns to Menu.
Finally the program can quit.

How to Build : (./gradlew build)
How to Run: (./gradlew run)

Improvements:
I could error check for negatives better and create more methods for the main method to test
