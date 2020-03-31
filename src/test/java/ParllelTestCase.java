import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class ParllelTestCase {


    @Test(invocationCount = 3)

    public void test1()
    {
        System.out.println("Test 1 is running "+Thread.currentThread().getId());
    }

    @Ignore
    @Test
    public void test2()
    {
        System.out.println("Test 2 is running "+Thread.currentThread().getId());
    }
}
