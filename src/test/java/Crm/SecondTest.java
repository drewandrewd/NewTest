package Crm;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SecondTest {

    private WebDriver driver;
    private Actions action;
    private CrmLoginPage pageOne;
    private CrmChooseContactPage pageTwo;
    private CrmCreateContactPage pageThree;
    private CrmMyContactPage pageFour;
    private CrmContactPage pageFive;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageOne = new CrmLoginPage(driver);
        pageTwo = new CrmChooseContactPage(driver, action);
        pageThree = new CrmCreateContactPage(driver);
        pageFour = new CrmMyContactPage(driver);
        pageFive = new CrmContactPage(driver);
    }

    @Test
    public void test() {
        try {
            //Login
            pageOne.getPage("https://crm.geekbrains.space/user/login");
            pageOne.clickLoginInput();
            pageOne.sendKeysLoginInput("Applanatest1");
            pageOne.clickPasswordInput();
            pageOne.sendKeysPasswordInput("Student2020!");
            pageOne.clickSubmitLoginButton();
            //Choose contact page
            pageTwo.doSomeAction();
            pageTwo.clickContactButton();
            //Create contact
            pageThree.clickCreateContact();
            //Contact page
            pageFour.lastNameClick();
            pageFour.lastNameSend("Drve");
            pageFour.firstNameClick();
            pageFour.firstNameSend("Namf");
            pageFour.organisationListClick();
            pageFour.organisationChoose();
            pageFour.jobTitleClick();
            pageFour.jobTitleSend("QA");
            pageFour.submitButtonClick();
            Assertions.assertEquals("Создать контактное лицо", pageFive.getResult());
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }
}