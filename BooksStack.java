
/**
 * This class defines a stack of books that is built from an array.
 *
 * The class defines the basic stack methods, push pop peek size and isEmpty. It
 * also does the methods required by the project, such as remove, get, print,
 * and sort. The purpose of this class is to allow the library manager to
 * describe and edit the library.
 *
 * @see LibraryManager and Book
 *
 * @author Lucie Sullivan 111718874
 * @version 1, March 29, 2019
 */
public class BooksStack {

    private Book[] books;
    private int top;
/**
 * Constructs a BooksStack object
 */
    public BooksStack() {
        this.books = new Book[100];
        top = -1;
    }

    /**
     * Works as a push to the stack as well as adding to the library
     *
     * This method uses an if statement and a try/catch block in order to add
     * new books
     *
     * @param newBook this is the new book being added to the library
     * @throws BookAlreadyExistsException will be thrown if the book trying to
     * be added already exists
     */
    public void push(Book newBook) throws BookAlreadyExistsException {
        try {
            for (Book b : books) {
                if (b.equals(newBook)) {
                    throw new BookAlreadyExistsException("This book is already in the stack!");
                }
            }
        } catch (BookAlreadyExistsException e) {
            System.out.println("This book is already in the library!");
        } catch (NullPointerException r) {
            top++;
            books[top] = newBook;
        }
    }

    /**
     * This method pops the top book out of the stack
     *
     * @return returns the book being removed from the stack
     * @throws EmptyStackException is thrown if the stack is empty
     */
    public Book pop() throws EmptyStackException {
        try {
            if (top == -1) {
                throw new EmptyStackException("The library is empty!!");
            }
            Book solution;
            solution = books[top];
            books[top] = null;
            top--;
            return solution;
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /**
     * This method allows the user to view the top book in the stack without
     * removing it
     *
     * @return returns the top book of the stack
     * @throws EmptyStackException is thrown if the stack is empty
     */
    public Book peek() throws EmptyStackException {
        try {
            if (top == -1) {
                throw new EmptyStackException("The library is empty!!");
            }
            Book solution;
            solution = books[top];
            return solution;
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /**
     * This method checks if the stack is empty
     *
     * @return returns true if the stack is empty
     */
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    /**
     * This method counts the number of books in the stack
     *
     * @return returns the number of books in the stack
     */
    public int size() {
        int count = 0;
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method removes the book based on the given title
     *
     * @param title the name of the book being removed
     * @throws EmptyStackException if the stack is empty
     * @throws BookAlreadyExistsException if the book being compared to exists
     * twice
     */
    public void remove(String title) throws EmptyStackException, BookAlreadyExistsException {

        //make a new stack and put everything in it until you get to what's being removed then put everything back
        BooksStack temp = new BooksStack();
        int num = top;

        //remove the given thing
        for (int i = top; i > -1; i--) {
            if (this.peek().getName().equalsIgnoreCase(title)) {
                System.out.println(title + " has been removed from the library!");
                this.pop();
                break;
            } else {
                temp.push(this.pop());
            }

        }
        if (this.isEmpty()) {
            System.out.println("There are no books in the library!");
        }

        for (int i = 0; i <= num; i++) {
            this.push(temp.pop());
        }

        //then fix the putting back in part
    }

    /**
     * This method prints the information of the book that is being searched for
     *
     * @param title name of the book being removed
     * @throws EmptyStackException
     * @throws BookAlreadyExistsException
     */
    public void get(String title) throws EmptyStackException, BookAlreadyExistsException {
        try {
            BooksStack temp = new BooksStack();
            int num = top;
            for (int i = num; i > 0; i--) {
                if (this.peek().getName().equalsIgnoreCase(title)) {

                    System.out.println(this.peek().getName() + " was written by " + this.peek().getAuthor()
                            + " in the year " + this.peek().getYearPublished() + ". It is of the "
                            + this.peek().getGenre() + " genre. The ISBN Number is " + this.peek().getISBN()
                            + " and it is " + this.peek().getCondition() + ".");
                    break;
                } else {
                    temp.push(this.pop());
                }

            }

            for (int i = 0; i <= num; i++) {
                this.push(temp.pop());
            }
            top = num;

        } catch (NullPointerException r) {
            System.out.println("There is no book with that title in the library!");
        }

    }

    /**
     * This method prints the information of all the books
     */
    public void print() {
        try {
            /*System.out.println("\tName\t|\tAuthor\t|\tGenre\t\t|\tYear\t|\tISBN Number\t|\tCondition"
             + "\n--------------------------------------------------------------------------"
             + "-------------------------------");*/
            System.out.printf("%20s %20s %20s %10s %18s %15s", "Name", "Author", "Genre", "Year", "ISBN", "Condition");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            for (Book book : books) {
                System.out.format("%20s %20s %20s %10s %18s %10s", book.getName(), book.getAuthor(), book.getGenre(),
                        book.getYearPublished(), book.getISBN(), book.getCondition());
                System.out.println();
            }
            /*for (int i = 0; i <= this.size(); i++) {
             System.out.println(books[i].toString());
             }*/
        } catch (NullPointerException r) {

        }
    }

    /**
     * Sorts the books alphabetically or numerically based on the requested
     * information
     *
     * @param choice this variable tells the program what criteria the books
     * should be sorted by
     */
    public void sort(String choice) {
        if (choice.equals("N")) {
            Book temp;
            for (int i = 0; i <= top; i++) {
                for (int j = i; j <= top; j++) {
                    if (((int) books[i].getName().charAt(0)) > ((int) books[j].getName().charAt(0))) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        } else if (choice.equals("A")) {
            Book temp;
            for (int i = 0; i < top; i++) {
                for (int j = i; j <= top; j++) {
                    if (((int) books[i].getAuthor().charAt(0)) > ((int) books[j].getAuthor().charAt(0))) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        } else if (choice.equals("G")) {
            Book temp;
            for (int i = 0; i < top; i++) {
                for (int j = i; j <= top; j++) {
                    if (((int) books[i].getGenre().charAt(0)) > ((int) books[j].getGenre().charAt(0))) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        } else if (choice.equals("Y")) {
            Book temp;
            for (int i = 0; i <= top; i++) {
                for (int j = i; j <= top; j++) {
                    if (books[i].getYearPublished() > books[j].getYearPublished()) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        } else if (choice.equals("C")) {
            Book temp;
            for (int i = 0; i < top; i++) {
                for (int j = i; j <= top; j++) {
                    if (books[i].getCondition().equals(Condition.OLD)) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        } else if (choice.equals("I")) {
            Book temp;
            for (int i = 0; i < top; i++) {
                for (int j = i; j <= top; j++) {
                    if (books[i].getISBN() > books[j].getISBN()) {
                        temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        }
    }
}