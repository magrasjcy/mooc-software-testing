package tudelft.sum;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TwoNumbersSumTest {
    @Test
    public void singleDigits() {

    ArrayList<Integer> x=new ArrayList<Integer>() {{ add(1) ;}};
    ArrayList<Integer> y=new ArrayList<Integer>() {{ add(1) ;}};

    ArrayList<Integer> result =
            new TwoNumbersSum().addTwoNumbers(x,y);
    Assertions.assertEquals(2,(int)result.get(0));
    }

    @Test
    public void singleDigitsOver10() {

        ArrayList<Integer> x=new ArrayList<Integer>() {{ add(5) ;}};
        ArrayList<Integer> y=new ArrayList<Integer>() {{ add(8) ;}};

        ArrayList<Integer> result =
                new TwoNumbersSum().addTwoNumbers(x,y);
        Assertions.assertEquals(3,(int)result.get(1));
        Assertions.assertEquals(1,(int)result.get(0));

    }
    @Test
    public void doubleDigitsOver100() {

        ArrayList<Integer> x=new ArrayList<Integer>() {{ add(4); add(7); ;}};
        ArrayList<Integer> y=new ArrayList<Integer>() {{ add(5) ;add(5);}};

        ArrayList<Integer> result =
                new TwoNumbersSum().addTwoNumbers(x,y);
        Assertions.assertEquals(1,(int)result.get(0));
        Assertions.assertEquals(0,(int)result.get(1));
        Assertions.assertEquals(2,(int)result.get(2));
    }

}
