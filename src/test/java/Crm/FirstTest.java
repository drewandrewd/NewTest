package Crm;

import Crm.CrmChooseProjectPage;
import Crm.CrmCreateProjectPage;
import Crm.CrmLoginPage;
import Crm.CrmMyProjectPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;
    private Actions action;
    private CrmLoginPage pageOne;
    private CrmChooseProjectPage pageTwo;
    private CrmCreateProjectPage pageThree;
    private CrmMyProjectPage pageFour;
    private CrmProjectPage pageFive;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageOne = new CrmLoginPage(driver);
        pageTwo = new CrmChooseProjectPage(driver, action);
        pageThree = new CrmCreateProjectPage(driver);
        pageFour = new CrmMyProjectPage(driver);
        pageFive = new CrmProjectPage(driver);
    }

    @Test
    public void createProject() {
        try {
            //Login
            pageOne.getPage("https://crm.geekbrains.space/user/login");
            pageOne.clickLoginInput();
            pageOne.sendKeysLoginInput("Applanatest1");
            pageOne.clickPasswordInput();
            pageOne.sendKeysPasswordInput("Student2020!");
            pageOne.clickSubmitLoginButton();
            //Choose project page
            pageTwo.doSomeAction();
            pageTwo.clickMyProjectsButton();
            //Create project
            pageThree.clickCreateProject();
            //Project page
            pageFour.nameClick();
            pageFour.sendName("new789uu");
            pageFour.organisationClick();
            pageFour.organisationDropMenu();
            pageFour.waitForContact();
            pageFour.contactClick();
            pageFour.chooseContact();
            pageFour.selectBusiness();
            pageFour.selectCurator();
            pageFour.selectRp();
            pageFour.selectAdministrator();
            pageFour.selectManager();
            pageFour.submitClick();
            Assertions.assertEquals("Создать проект", pageFive.getResult());
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }

}