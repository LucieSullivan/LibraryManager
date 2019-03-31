
/**
 *This class defines the book object to be used by the stack class
 * 
 * @author Lucie Sullivan 111718874
 * @version 1.0, March 29, 2019
 */
enum Condition {

    OLD, NEW;
}

public class Book {

    private String name;
    private String author;
    private String genre;
    private int yearPublished;
    private long ISBN;
    private Condition condition;

    public Book(String name, String author, String genre, int yearPublished, long ISBN, Condition condition) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
        this.condition = condition;
    }

    public Book() {
    }
/**
 * This is just a BUNCH of getters and setters
 * (To be specific the order is getter then setter for each instance 
 *  
 */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
/**
 * This method is a basic toString method
 * @return The information of the book in a tabular format
 */
    public String toString() {

        return name + "\t|\t" + author + "\t|\t" + genre + "\t|\t" + yearPublished
                + "\t|\t" + ISBN + "\t|\t" + condition;
    }
/**
 * The purpose of this method is to compare if two book objects are the same 
 * @param b1 the first book being checked
 * @param b2 the second book being checked
 * @return true if the two books have all the same information
 */
    public boolean equals(Book b1, Book b2) {
        if (b1.name.equals(b2.name)) {
            if (b1.author.equals(b2.author)) {
                if (b1.genre.equals(b2.author)) {
                    if (b1.yearPublished == b2.yearPublished) {
                        if (b1.ISBN == b2.ISBN) {
                            if (b1.condition.equals(b2.condition)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
