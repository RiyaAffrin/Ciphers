/*Riya Affrin
4/7/24
CSE 123 BG
TA Eric Bae
C0:Cipher 
 
In this class we extend subsitution so that we can change the Substitution cipher.
this class involves placing
a key at the front of the subsitution, while the rest of the word follows alphabetically*/

public class CaesarKey extends Substitution {
    
    //This Is the ceaserkey method but here we take in a string called key. We will becasuse
    //checking through this key for length and characters

    //here we are checking the string length, if it is 0 in length then we will throw an
    //IllegalArgumentException becasuse the string cannot be 0

    public CaesarKey(String key) {
        //here we are seeing that if the length is 0 the IllegalArgumentException is thrown
        if (key.length() == 0) {
            throw new IllegalArgumentException();
        }
        //here we are creating our variables we have boolean and char array to keep track of the 
        //the letters in the string and the boolean to keep track of the true and false
        //we have an int shiftIndex because we need to update where everything is and initializes 
        //the fields

        boolean[] hasSeen = new boolean[Cipher.TOTAL_CHARS];
        char[] shift = new char[Cipher.TOTAL_CHARS];
        int shiftIndex = 0;

        //In this for loop we are iterating through the length of our string key, we create a char
        //variable because we need to check if the given character is within the bounds of 
        //the Cipher characters. If not in bound then we throw an IllegalArgumentException

        for (int i = 0; i < key.length(); i++) {
            char charr = key.charAt(i);
            //if it is not in bound an  IllegalArgumentException will be thrown
            if (charr < Cipher.MIN_CHAR || charr > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException();
            }

            //here we are checking along with our boolean array if charater has been seen before
            //If the character has been seen we throw an IllegalArgumentException

            if (hasSeen[charr - Cipher.MIN_CHAR]) {
                throw new IllegalArgumentException();
            }
            //otherwise the loop carries on and shift index gets added by one
            hasSeen[charr - Cipher.MIN_CHAR] = true;
            shift[shiftIndex++] = charr;
        }

         //After we exit the loop we check through the remaining characters which is
        // the total characters of cipher sbtracted by the length of the key string

        int remaining = Cipher.TOTAL_CHARS - key.length();
        for (int i = Cipher.MIN_CHAR; remaining > 0; i++) {
            char c = (char) i;
            if (!hasSeen[c - Cipher.MIN_CHAR]) {
                shift[shiftIndex++] = c;
                remaining--;
            }
        }
         //here we are calling the super method to run through the char array
        super.setShifter(new String(shift));
    }
}