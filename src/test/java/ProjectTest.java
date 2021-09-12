import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProjectTest {

    private WebDriver driver;
    private Actions action;
    private NotePage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        page = new NotePage(driver, action);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void putSomeText() {
        try {
            page.getPage("https://online-bloknot.ru/");
            page.clickBoldIcon();
            page.frameOne(1);
            page.sendTextMainContent("Добрый день!!");
            page.doSomeAction("Дополнительный тест: ");
            page.defaultFrame();
            page.clickLinkButton();
            page.clickInputArea();
            page.sentTextInputArea("https://yandex.ru/");
            page.clickSaveButton();
            String result = page.getResult();
            Assertions.assertEquals("Добрый день!!\n" + "Дополнительный тест: http://yandex.ru/", result);
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }
}