import org.junit.Before;
import org.junit.Test;
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
    }

    @Test
    public void createProject() {
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
        pageFour.sendName("new88");
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
    }

}