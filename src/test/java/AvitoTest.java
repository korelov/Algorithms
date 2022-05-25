import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import runner.BaseTest;


public class AvitoTest extends BaseTest {


    @Test
    public void tesAvito() throws InterruptedException {
        getDriver().get("https://www.avito.ru/");
        getDriver().findElement(By.id("category")).click();

        new Select(getDriver().findElement(By.id("category"))).selectByValue("99");

        getDriver().findElement(By.xpath("//input[@class='input-input-Zpzc1']")).sendKeys("Принтер");
        getDriver().findElement(By.xpath("//div[@class='main-select-JJyaZ main-location-XUs1_']")).click();
        getDriver().findElement(By.xpath("//input[@class='suggest-input-rORJM']")).sendKeys("Владивосток");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ul[@class='suggest-suggests-CzXfs']/li[@data-marker='suggest(0)']")).click();

        getDriver().findElement(By.xpath("//span[text()='Сначала в выбранном городе']")).click();

        getDriver().findElement(By.xpath("//button[contains(@class, 'F button-primary-x_x8w')]")).click();

        new Select(getDriver().findElement(By.xpath("//div[@class='index-content-_KxNP']//select"))).selectByValue("2");

        for (int i = 1; i < 4; i++) {
            System.out.println(getDriver().findElement(By.xpath("(//a//h3)[" + i + "]")).getText());
            System.out.println(getDriver().findElement(By.xpath("(//span[@class='price-price-JP7qe'])[" + i + "]")).getText());
        }
    }


}
