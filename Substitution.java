/*Riya Affrin
4/7/24
CSE 123 BG
TA Eric Bae
C0:Cipher 
This is the subsitution class. This class is a way to cipher a string where we can encrpyt and
decrypt them by changing their letters in a specific way which is subsitution*/

// TODO: Write your implementation to Subsitution here!

import java.util.*;
//here is our class we extend cipher to be able to access the methds in cipher as a super
public class Substitution extends Cipher{
    //here we are creating our one field which is a privatestring shifter
    public String shifter;

    //here is our blank constructor we have this because we are constructing a new  subsitution 
    //cipher but one that has an empty shifter
    public Substitution(){

    }


    //here is our other constructor where we pass in the string and call the setShifter method here
    //if the length of the shifter is not equal to the total cipher characters then an
    //IllegalArgumentException is thrown 
    public Substitution (String shifter){
        if (shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException();
        }
        setShifter(shifter);
        
    }

    //In the setShifter class we don't return anything but we take in a String, shifter. The 
    //purpose of this method is to update the shifter
    //if the shifter length is not equal to the total charactrs then 
    //we throw an IllegalArgumentException
    public void setShifter(String shifter){
        if(shifter.length() != Cipher.TOTAL_CHARS){
            throw new IllegalArgumentException();

        }
        boolean[] hasSeen = new boolean[Cipher.TOTAL_CHARS];

        for(int i = 0; i < Cipher.TOTAL_CHARS; i++){
            char letter = shifter.charAt(i);
            //if the letter out of bounds or already been seen we throw an IllegalArgumentException 
            if(letter <Cipher.MIN_CHAR || letter > Cipher.MAX_CHAR || hasSeen[letter - Cipher.
            MIN_CHAR]){
                throw new IllegalArgumentException();
            }
            hasSeen[letter - Cipher.MIN_CHAR] = true;
        }

        this.shifter = shifter;
    }
    
    
    //This is the encrpyt method. We return the encrypted input string and also throw an
    // IllegalArgumentException if the shifter is null; We do this because if it is null
    // there is nothing to be changed
    
    public String encrypt (String input){
        //Here we are throwing the IllegalStateException if the shifter is null
        if(shifter == null){
            throw new IllegalStateException("Shifter isn't set");

        }
        //here we are creating a char array called val we create this array so that we can get
        //each individual letter of the input string
        char[] val = new char[input.length()];

        //here we are going through the string and shifting characters around to encrpyt it
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < Cipher.MIN_CHAR || c > Cipher.MAX_CHAR) {
                val[i] = c;
            } else {
                int index = c - Cipher.MIN_CHAR;
                val[i] = shifter.charAt(index);
            }
        }
        //Afterwards we return the new string val
        return new String(val);
    }



    //Here is the opposite of the previous method. Here we are still returning and passing in a 
    //string but we are now decrypting it. similarly to encrpyt we still throw an 
    //IllegalArgumentException if the shifter is null

    public String decrypt(String input) {
        if (shifter == null) {
            throw new IllegalStateException("Shifter isn't set");
        }

        //Again we create the char array to use to look at the characters in the inout string

        char[] val = new char[input.length()];
        int valIndex = 0;

        //we also need to go through the string to rearrange the characters which is what
        // we are doing here
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < Cipher.MIN_CHAR || c > Cipher.MAX_CHAR) {
                val[valIndex++] = c;
            } else {
                int index = shifter.indexOf(c);
                val[valIndex++] = (char) (Cipher.MIN_CHAR + index);
            }
        }
        //here we are returning a new string but it is updated with the char array and index
        return new String(val, 0, valIndex);
    }
}
