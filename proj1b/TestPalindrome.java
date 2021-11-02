import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String a = "abba";
        assertTrue(palindrome.isPalindrome(a));
        String b = "aslfj";
        assertFalse(palindrome.isPalindrome(b));
        String c = "flake";
        assertTrue(palindrome.isPalindrome(c, cc));
        String d = "sdjfsldkjf";
        assertFalse(palindrome.isPalindrome(d, cc));
    }
    //Uncomment this class once you've created your Palindrome class.
}
