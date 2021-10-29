import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offByN = new OffByN(2);

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
    public void TestPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("Racecar"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));

    }
    @Test
    public void TestPalindrome2() {
        assertTrue(palindrome.isPalindrome("sbdecar", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertFalse(palindrome.isPalindrome("Racecar", offByOne));
        assertFalse(palindrome.isPalindrome("horse", offByOne));
        assertFalse(palindrome.isPalindrome("rancor", offByOne));
        assertFalse(palindrome.isPalindrome("aaaaab", offByOne));

    }
    @Test
    public void TestPalindrome3() {
        assertTrue(palindrome.isPalindrome("tceecar", offByN));
        assertTrue(palindrome.isPalindrome("glaje", offByN));
        assertTrue(palindrome.isPalindrome("d", offByN));
        assertTrue(palindrome.isPalindrome("", offByN));
        assertFalse(palindrome.isPalindrome("Racecar", offByN));
        assertFalse(palindrome.isPalindrome("horse", offByN));
        assertFalse(palindrome.isPalindrome("rancor", offByN));
        assertFalse(palindrome.isPalindrome("aaaaab", offByN));

    }
}
