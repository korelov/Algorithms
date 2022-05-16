import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


import java.util.concurrent.TimeUnit;

public class MainTest extends BaseTest {

    @Test
    public  void testFirstSelenium() {


        getDriver().get("https://google.com");

        getDriver().getTitle(); // => "Google"

        getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        WebElement searchBox = getDriver().findElement(By.name("q"));
        WebElement searchButton = getDriver().findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = getDriver().findElement(By.name("q"));
        Assert.assertEquals(searchBox.getAttribute("value"),"Selenium"); // => "Selenium"

    }
}
