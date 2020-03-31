import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class extentReportConcept {

    WebDriver driver;

    ExtentHtmlReporter extentHtmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;


    @BeforeClass
    public void launch()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");

        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/extent.html");
        extentHtmlReporter.config().setDocumentTitle("Automation report");
        extentHtmlReporter.config().setTheme(Theme.DARK);

        extentReports= new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentTest=extentReports.createTest("test case ", "test case started");
    }

    @Test
    public void getTitle()
    {
        System.out.println(driver.getTitle());
        extentTest.createNode("test start A");
        extentTest.log(Status.PASS, "Test Case is passed");
    }

    @Test
    public void serachText() throws InterruptedException {
        WebElement serachBox= driver.findElement(By.name("q"));
        WebElement googleSearchBtn= driver.findElement(By.name("btnK"));

        extentTest.log(Status.PASS, "Test Case is passed");
        serachBox.sendKeys("selenium");
        googleSearchBtn.submit();
        //Thread.sleep(4000);
        //googleSearchBtn.click();

    }

    @Test(dependsOnMethods = "serachText")
    public void getCount() throws InterruptedException {
        List< WebElement> searchText= driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        Thread.sleep(3000);

        System.out.println("Total count of search text " + searchText.size());
    }

    @AfterMethod


    @AfterClass
    public  void tearDown()
    {
        driver.quit();
        extentReports.flush();
    }
}
