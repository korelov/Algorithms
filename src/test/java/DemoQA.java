import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class DemoQA {
    WebDriver driver;


    @AfterMethod
    public void DriverClose() {
        driver.quit();
    }


    @Ignore
    @Test
    public void testFirstSelenium() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        // Print the first result
        System.out.println(firstResult.getText());
    }

    @Test
    public void testDemoQAButtons() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-4']")).click();

        Actions action = new Actions(driver);

        action.doubleClick(driver.findElement(By.xpath("//button[@id='doubleClickBtn']"))).build().perform();
        action.contextClick(driver.findElement(By.xpath("//button[@id='rightClickBtn']"))).build().perform();
        action.click(driver.findElement(By.xpath("//button[text() = 'Click Me']"))).build().perform();

        List<WebElement> actual = driver.findElements(By.xpath("//div/p"));

        List<String> expected = Arrays.asList("You have done a double click", "You have done a right click", "You have done a dynamic click");

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(actual.get(i).getText(), expected.get(i));
        }
    }

    @Test
    public void testDemoQAWebTables() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-3']")).click();

        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys("Anna");
        driver.findElement(By.id("lastName")).sendKeys("Ivanov");
        driver.findElement(By.id("userEmail")).sendKeys("test@test.com");
        driver.findElement(By.id("age")).sendKeys("35");
        driver.findElement(By.id("salary")).sendKeys("100000");
        driver.findElement(By.id("department")).sendKeys("QA");

        driver.findElement(By.id("submit")).click();

        driver.findElement(By.id("searchBox")).sendKeys("Anna");

        Assert.assertEquals(driver.findElement(By.xpath("//div[text() = 'Anna']")).getText(), "Anna");

    }

    @Test
    public void testDemoQABrokenImage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-6']")).click();

        Assert.assertFalse(driver.findElement(By.xpath("(//div/img)[2]")).isDisplayed());
    }

    @Test
    public void testDemoQAValidImage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-6']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//div/img)[1]")).isDisplayed());
    }


    @Ignore
    @Test
    public void testDemoQACheckBox() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-1']")).click();

        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
    }


    @Test
    public void testDemoQAInteractionsDroppable() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Interactions']")).click();

        driver.findElement(By.xpath("(//li[@id='item-3'])[4]")).click();
        Actions action = new Actions(driver);

        action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

        Assert.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");
    }

    @Test
    public void testDemoQAAlertAccept() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();

        driver.findElement(By.xpath("(//li[@id='item-1'])[2]")).click();

        driver.findElement(By.id("confirmButton")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("confirmResult")).getText(), "You selected Ok");
    }
}
