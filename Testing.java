import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assume.assumeTrue;
import java.util.*;

public class Testing {

    @Test
    @DisplayName("EXAMPLE TEST CASE - 'A'-'G' Spec Example")
    public void firstCaseTest() {
        // Remember that you can change MIN_CHAR AND MAX_CHAR 
        // in Cipher.java to make testing easier! For this 
        // example test, we are using MIN_CHAR = A and MAX_CHAR = G

        // Skip this test if the constants have changed
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('G'));

        Cipher testSubstitution = new Substitution("GCBEAFD");
        assertEquals("FGE", testSubstitution.encrypt("FAD"));
        assertEquals("BAD", testSubstitution.decrypt("CGE"));
        
        // Per the spec, we should throw an IllegalArgumentException if 
        // the length of the shifter doesn't match the number of characters
        // within our Cipher's encodable range
        assertThrows(IllegalArgumentException.class, () -> {
            new Substitution("GCB");
        });
    }

    @Test
    @DisplayName("EXAMPLE TEST CASE - 'A'-'Z' Shifter")
    public void secondCaseTest() {
        // Skip this test if the constants have changed
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));

        // Reverse alphabetic
        Cipher testSubstitution = new Substitution(
            "ZYXWVUTSRQPONMLKJIHGFEDCBA"
        );
        assertEquals("UZW", testSubstitution.encrypt("FAD"));
        assertEquals("BAD", testSubstitution.decrypt("YZW"));
    }

    @Test
    @DisplayName("EXAMPLE TEST CASE - ' '-'}' Shifter")
    public void thirdCaseTest() {
        // Skip this test if the constants have changed
        assumeTrue(Cipher.MIN_CHAR == (int)(' ') && Cipher.MAX_CHAR == (int)('}'));
        
        // Swapping lowercase a<->b
        Cipher testSubstitution = new Substitution(
            " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`bacdefghijklmnopqrstuvwxyz{|}"
        );
        assertEquals("FAD", testSubstitution.encrypt("FAD"));
        assertEquals("fbd", testSubstitution.encrypt("fad"));
        assertEquals("BAD", testSubstitution.decrypt("BAD"));
        assertEquals("bad", testSubstitution.decrypt("abd"));
    }

    @Test
    @DisplayName("TODO: 1 Substitution - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 2 Substitution - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 1 CaesarKey - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 2 CaesarKey - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 1 CaesarShift - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 2 CaeserShift - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 1 MultiCipher - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }

    @Test
    @DisplayName("TODO: 1 MultiCipher - ' '-'}' Shifter")
    public void thirdCaseTest() {
        assertTrue(false, "Not yet implemented!");
    }
}
