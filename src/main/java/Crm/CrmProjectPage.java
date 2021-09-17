package Crm;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CrmProjectPage {



    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")
    private WebElement createProjectButton;

    public CrmProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getResult() {
        return createProjectButton.getText();
    }
}