import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGConcept {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }


    @BeforeTest
    public void beforeTest()
    {
        System.out.println("before test");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("before Class");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("before Method");
    }


    @BeforeGroups
    public void beforeGroup()
    {
        System.out.println("before Group");
    }

    @Parameters("var1")
    @Test(groups = "test")
    public void testMethod(@Optional String var1)
    {
        System.out.println("Test Method "+var1);
    }

    @Test(groups = "test", retryAnalyzer = retryConcept.class)
    public void testMethod1()
    {
        System.out.println("Test Method1 ");

        Assert.assertTrue(false);
    }
}

