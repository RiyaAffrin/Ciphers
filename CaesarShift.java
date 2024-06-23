/*Riya Affrin
4/7/24
CSE 123 BG
TA Eric Bae
C0:Cipher 
 
This is the CaesarShift class here we extend the subsitution class and we encrypt the string in a
different manner here we are replacing each character input with teh corresponding letter in the 
shifter in the same position*/

// TODO: Write your implementation to CaesarShift here!


public class CaesarShift extends Cipher {
    //here is our varible we have is set to final because we dont want it messed with or changed
    private final int shift;

    //this constructor method constructs a new caesarshift with the given shift value
    public CaesarShift(int shift) {
        //if the shift is less or equal to zero an IllegalArgumentException is thrown
        if (shift <= 0) {
            throw new IllegalArgumentException();
        }
        //otherwise teh shift is updated by modding it by teh total charactrs allowed
        this.shift = shift % Cipher.TOTAL_CHARS;
    }

    //this method here takes in a string input here we take the string and start to encrpyt it
    //we then return the encrpyted string
    public String encrypt(String input) {

        //we create a char array so that we get every single letter of teh string
        char[] output = new char[input.length()];
        //we iterate through it and put each ltter through an if statement to see if the letters
        //are in bounds for the characters allowed
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= Cipher.MIN_CHAR && c <= Cipher.MAX_CHAR) {
                int displace = c - Cipher.MIN_CHAR;
                int shiftedDisplacement = (displace + shift) % Cipher.TOTAL_CHARS;
                output[i] = (char)(Cipher.MIN_CHAR + shiftedDisplacement);
            } else {
                output[i] = c;
            }
        }
        //after we return the new encrpyted string
        return new String(output);
    }


    //This method decrypts the string we pass in the string that is encrpyted and 
    //return it decrypted
    public String decrypt(String input) {
        // like the encryption we create the char array and interate through teh letters
        char[] output = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //this time we check if the letters are in bounds but if not we setthe character
            // to the outbut at i
            if (c >= Cipher.MIN_CHAR && c <= Cipher.MAX_CHAR) {
                int displacement = c - Cipher.MIN_CHAR;
                int shiftedDisplacement = (displacement - shift + Cipher.TOTAL_CHARS) % Cipher.
                TOTAL_CHARS;
                output[i] = (char)(Cipher.MIN_CHAR + shiftedDisplacement);
            } else {
                output[i] = c;
            }
        }
        //here we return the decrypt  string 
        return new String(output);
    }

   
}