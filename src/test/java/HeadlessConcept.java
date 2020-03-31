import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HeadlessConcept {


    WebDriver driver;

    @BeforeClass
    public void seUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("headless");

        driver= new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void openBrowser()
    {
        driver.get("https://www.google.com/");

        WebElement serachBox= driver.findElement(By.name("q"));
        WebElement googleSearchBtn= driver.findElement(By.name("btnK"));

        serachBox.sendKeys("ABC");
        Wait<WebDriver> fWait= new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        fWait.until(ExpectedConditions.elementToBeClickable(serachBox));
        serachBox.sendKeys("ABC");

        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(googleSearchBtn)).click();


    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
