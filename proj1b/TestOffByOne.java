import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars(b, c));
        assertFalse(offByOne.equalChars(a, c));
    }
    //    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *
}
