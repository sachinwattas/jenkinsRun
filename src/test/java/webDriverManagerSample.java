import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class webDriverManagerSample {

    WebDriver driver;
    @BeforeClass
    public void launch()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void getTitle()
    {
        System.out.println(driver.getTitle());
    }

    @Test
    public void serachText() throws InterruptedException {
        WebElement serachBox= driver.findElement(By.name("q"));
        WebElement googleSearchBtn= driver.findElement(By.name("btnK"));


        serachBox.sendKeys("selenium");
        googleSearchBtn.submit();
        //Thread.sleep(4000);
        //googleSearchBtn.click();

    }

    @Test(dependsOnMethods = "serachText")
    public void getCount() throws InterruptedException {
       List< WebElement> searchText= driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));

        //*[contains(text(), 'selenium')]

        //WebDriverWait wait= new WebDriverWait(driver, 30);

        //wait.until(ExpectedConditions.visibilityOfAllElements(searchText));
        Thread.sleep(3000);

       System.out.println("Total count of search text " + searchText.size());
    }

    @AfterClass
    public  void tearDown()
    {
        driver.quit();
    }
}