import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SecondTest {

    private WebDriver driver;
    private Actions action;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test() { //Login
        try {
            driver.get("https://crm.geekbrains.space/user/login");
            Assertions.assertTrue(driver.findElement(By.className("title")).isDisplayed());
            driver.findElement(By.id("prependedInput")).click();
            driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
            driver.findElement(By.id("prependedInput2")).click();
            driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
            driver.findElement(By.id("_submit")).click();
            action
                    .moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")))
                    .build()
                    .perform();
            driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[4]/a/span")).click();
            driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")).click();
            //Create contact
            Assertions.assertTrue(driver.findElement(By.className("user-fieldset")).isDisplayed());
            driver.findElement(By.name("crm_contact[lastName]")).click();
            driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Drew");
            driver.findElement(By.name("crm_contact[firstName]")).click();
            driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Name");
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[1]/div[2]/div/div[1]/a/span[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();
            driver.findElement(By.name("crm_contact[jobTitle]")).click();
            driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }
}