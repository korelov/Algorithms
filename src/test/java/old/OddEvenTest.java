package old;

import org.junit.Assert;
import org.junit.Test;

public class OddEvenTest {

    private String odd = "Odd";
    private String evem = "Even";
    private String undefined = "Undefined";

    @Test
    public void testOddEven() {
        OddEven test = new OddEven();
        Assert.assertEquals(odd, test.oddEven(345));
    }

    @Test
    public void testOddNegat() {
        OddEven test = new OddEven();
        Assert.assertEquals(odd, test.oddEven(-345));
    }

    @Test
    public void testZero() {
        OddEven oddEven = new OddEven();
        Assert.assertEquals(evem, oddEven.oddEven(0));
    }

    @Test
    public void testEvenNegativeNumber() {
        OddEven oddEven = new OddEven();
        Assert.assertEquals(evem, oddEven.oddEven(-2222));
    }

    @Test
    public void testUndefinedMoreThanMax() {
        long number = 2147483648L;
        String expectedResult = "Undefined";
        OddEven oddEven = new OddEven();
        String actualResult = oddEven.oddEven((int) 2147483648L);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testUndefinedLessThanMin() {
        long number = -2147483649L;
        String expectedResult = "Undefined";
        OddEven oddEven = new OddEven();
        String actualResult = oddEven.oddEven((int) number);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
