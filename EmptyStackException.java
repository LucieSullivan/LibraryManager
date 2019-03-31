/**
 *This class defines the the exception for if you're trying to read from an empty library
 * 
 * @author Lucie Sullivan 111718874
 * @version 1.0, March 29, 2019
 */
public class EmptyStackException extends Exception{
    public EmptyStackException(String message){
        super(message);
    }
    
}
