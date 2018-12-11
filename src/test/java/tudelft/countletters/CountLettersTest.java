package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {
//arbitrary definition of correctness blocks effective testing

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void exploratoryTest() {
        int words = new CountLetters().count("xdfffs");
        Assertions.assertEquals(1, words);
    }
    @Test
    public void exploratory03Test() {
        int words = new CountLetters().count("dis,ix,as");
        Assertions.assertEquals(2, words);
    }
    @Test
    public void exploratory04Test() {
        int words = new CountLetters().count("dis,ir,as");
        Assertions.assertEquals(3, words);
    }
    @Test
    public void exploratory02Test() {
        int words = new CountLetters().count(".");
        Assertions.assertEquals(0, words);
    }
}