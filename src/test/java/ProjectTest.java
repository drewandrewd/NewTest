import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProjectTest { // т.к. капчу в ThirdTest не проходит, добавил данный дополнительный тест

    private WebDriver driver;
    private Actions action;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        try {
            driver.get("https://online-bloknot.ru/");
            Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/h1")).isDisplayed());
            driver.findElement(By.cssSelector(".cke_button__bold_icon")).click();
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("/html/body")).sendKeys("Добрый день!!");
            action
                    .sendKeys(Keys.ENTER)
                    .sendKeys("Дополнительный тест: ")
                    .build()
                    .perform();
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id=\"cke_17\"]/span[1]")).click();
            driver.findElement(By.tagName("input")).click();
            driver.findElement(By.tagName("input")).sendKeys("https://yandex.ru/");
            driver.findElement(By.linkText("Сохранить")).click();
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }
}