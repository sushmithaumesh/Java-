
package util;


// Util class to validate input data
 
public final class Validator {

 // Returns true if input value is a string.
 // @param input input string. @return true if input contains alphabets only.
 
    public static boolean validInput(String input) {
        String regex = "^[a-zA-Z]+$";
        return input.matches(regex);
    }
}
