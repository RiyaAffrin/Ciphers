/*Riya Affrin
4/7/24
CSE 123 BG
TA Eric Bae
C0:Cipher 
This is the multi cipher class here we are extending cipher because we are doing a different
type of encrpytion I like to think this is a mix of the otherr classes*/

// TODO: Write your implementation to MultiCipher here!
import java.util.List;


//here we have our class header MultiCipher which has the field
//List array ciphers
public class MultiCipher extends Cipher {
    public  List<Cipher> ciphers;


    //here is our constructor where we pass in our array of ciphers
    public MultiCipher(List<Cipher> cipherList) {
        // Constructs a new MultiCipher with the provided List of Ciphers
        //we throw an IllegalArgumentException if the list is null
        if (cipherList == null) {
            throw new IllegalArgumentException();
        }
        this.ciphers = cipherList;
    }

    //here we do a new method of encryption by iteration through the cipher adn return a
    //string outout
    public String encrypt(String input) {
        String output = input;
        for (Cipher cipher : ciphers) {
            output = cipher.encrypt(output);
        }
        return output;
    }

    //here we do a new method of dencryption by iteration through the cipher adn return a 
    //string outout
    public String decrypt(String input) {
        String output = input;
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            output = ciphers.get(i).decrypt(output);
        }
        return output;
    }
}