package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GHappyTest {
    @Test
    public void unhappystring() {
        boolean result = new GHappy().gHappy("xxxyzz");
        Assertions.assertEquals(false,result);
    }
    @Test
    public void emptystring() {
        boolean result = new GHappy().gHappy("");
        Assertions.assertEquals(false,result);
    }
    @Test
    public void happystart() {
        boolean result = new GHappy().gHappy("ggXsdlifsd");
        Assertions.assertEquals(true,result);
    }
    @Test
    public void slightlyhappystart() {
        boolean result = new GHappy().gHappy("gslijeojfd");
        Assertions.assertEquals(false,result);
    }
    @Test
    public void happyslightly() {
        boolean result = new GHappy().gHappy("hgtyttr");
        Assertions.assertEquals(false,result);
    }
    @Test
    public void hiddenhappystart() {
        boolean result = new GHappy().gHappy("mggXsdlifsd");
        Assertions.assertEquals(true,result);
    }
    @Test
    public void happyend() {
        boolean result = new GHappy().gHappy("00Xsdlifgg");
        Assertions.assertEquals(true,result);
    }
    @Test
    public void slightlyhappyend() {
        boolean result = new GHappy().gHappy("Xsdlifsdg");
        Assertions.assertEquals(false,result);
    }
    @Test
    public void hiddenhappyend() {
        boolean result = new GHappy().gHappy("Xsdlifsggd");
        Assertions.assertEquals(true,result);
    }
}
