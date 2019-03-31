
/**
 * This class manages the information in the stack and interacts with the user
 *
 * @author Lucie Sullivan 111718874
 * @version 1.0, March 29, 2019
 */
import java.util.Scanner;

public class LibraryManager {

    /**
     * The main method!
     *
     * @param args
     * @throws BookAlreadyExistsException
     * @throws EmptyStackException
     */
    public static void main(String[] args) throws BookAlreadyExistsException, EmptyStackException {
       

            System.out.println("Welcome to Lucie's Library!");
            boolean flag = true;
            Scanner input = new Scanner(System.in);
            BooksStack library = new BooksStack();
            while (flag) {
                 try {
                System.out.println("Menu: \n(A) Add Book \n(R) Remove Book \n(G) Get Book \n(P) Print Books"
                        + "\n(S) Sort Books \n(Q) Quit");
                System.out.print("Please make a selection: ");
                String answer = input.next();
                if (answer.equalsIgnoreCase("A")) {
                    System.out.print("Please enter the title: ");
                    input.nextLine();
                    String title = input.nextLine();
                    System.out.print("Please enter the author: ");
                    String author = input.nextLine();
                    System.out.print("Please enter the genre: ");
                    String genre = input.nextLine();
                    System.out.print("Please enter the year it was published: ");
                    int year = input.nextInt();
                    System.out.print("Please enter the ISBN number: ");
                    String thing = input.next();
                    long ISBN = Long.parseLong(thing);
                    System.out.print("Please enter the condition: ");
                    String ugh = input.next();
                    Condition condition;
                    if (ugh.equalsIgnoreCase("new")) {
                        condition = Condition.NEW;
                    } else {
                        condition = Condition.OLD;
                    }
                    library.push(new Book(title, author, genre, year, ISBN, condition));
                    System.out.println(title + " has been added to the library!");
                } else if (answer.equalsIgnoreCase("R")) {
                    System.out.print("Please enter the name of the book: ");
                    input.nextLine();
                    String name = input.nextLine();
                    library.remove(name);
                } else if (answer.equalsIgnoreCase("G")) {
                    System.out.print("Please enter the name of the book: ");
                    input.nextLine();
                    String name = input.nextLine();
                    library.get(name);
                } else if (answer.equalsIgnoreCase("P")) {
                    library.print();
                } else if (answer.equalsIgnoreCase("S")) {
                    System.out.print("(N) Name\n(A) Author\n(G) Genre\n(Y) Year\n(C) Condition\n(I) ISBN Number\nSelection: ");
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("N")) {
                        library.sort("N");
                        System.out.println("The library has been sorted by name.");
                    } else if (choice.equalsIgnoreCase("A")) {
                        library.sort("A");
                        System.out.println("The library has been sorted by author.");
                    } else if (choice.equalsIgnoreCase("G")) {
                        library.sort("G");
                        System.out.println("The library has been sorted by genre.");
                    } else if (choice.equalsIgnoreCase("Y")) {
                        library.sort("Y");
                        System.out.println("The library has been sorted by year published.");
                    } else if (choice.equalsIgnoreCase("C")) {
                        library.sort("C");
                        System.out.println("The library has been sorted by condition.");
                    } else if (choice.equalsIgnoreCase("I")) {
                        library.sort("A");
                        System.out.println("The library has been sorted by ISBN Number.");
                    } else {
                        System.out.println("Invalid selection please try again.");
                    }
                } else if (answer.equalsIgnoreCase("Q")) {
                    System.out.println("Thanks for visiting Lucie's Library! Come again :))))");
                    flag = false;
                } else {
                    System.out.println("Invalid selection please try again!");
                }
                } catch (Exception e) {
            System.out.println("Invalid input try again");
        }
            }
        
    }
}
