/**
 *This class defines the the exception for if you're trying to add a repeated book to the library
 * 
 * @author Lucie Sullivan 111718874
 * @version 1.0, March 29, 2019
 */
public class BookAlreadyExistsException extends Exception{
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
