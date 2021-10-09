import org.junit.Assert;
import org.junit.Test;

public class OddEvenTest {

    @Test
    public void testOddEven(){
        String odd = "Odd";
        String evem = "Even";
        String undefined = "Undefined";

        OddEven test = new OddEven();
        Assert.assertEquals(odd,test.oddEven(2));
    }

}
