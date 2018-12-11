package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CaesarShiftCipherTest {
    @Test
    public void nullCipherTest() {
        String result=new CaesarShiftCipher().process("", 0);
        Assertions.assertEquals("",result);
    }

    @Test
    public void singleCharCipherTest() {
        String result=new CaesarShiftCipher().process("a",1);
        Assertions.assertEquals("b",result);
    }

    @Test
    public void singleCharLowerCipherTest() {
        String result=new CaesarShiftCipher().process("z",1);
        Assertions.assertEquals("a",result);
    }


    @Test
    public void outsideRangeCipherTest() {
        String result=new CaesarShiftCipher().process("42304",3);
        Assertions.assertEquals("invalid",result);
    }
    @Test
    public void outsideHighRangeCipherTest() {
        String result=new CaesarShiftCipher().process("~~",3);
        Assertions.assertEquals("invalid",result);
    }

}
