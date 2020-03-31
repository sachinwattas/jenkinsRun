import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {

    public static void main(String [] args)
    {
       WebDriverInterafce webDriverInterafce= new Chromedriver();

       webDriverInterafce.get("Google.com");
       webDriverInterafce.sendKey("Enter Key");

       System.setProperty("webdriver.chrome.driver", "chromedriver-4");
       WebDriver driver= new ChromeDriver();

       //Open URL
        driver.get("https://www.google.com");

        //get title
        System.out.println("current url " + driver.getCurrentUrl());

        System.out.println("Current title " + driver.getTitle());

        WebElement element;
    }


}
