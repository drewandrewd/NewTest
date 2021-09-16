package Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmChooseProjectPage {

    private WebDriver driver;
    private Actions actions;

    private final String openMenu = "//*[@id=\"main-menu\"]/ul/li[3]/a/span";

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a")
    private WebElement myProjectsButton;

    public CrmChooseProjectPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    public void doSomeAction() {
        actions
                .moveToElement(driver.findElement(By.xpath(openMenu)))
                .build()
                .perform();
    }

    public CrmChooseProjectPage clickMyProjectsButton() {
        myProjectsButton.click();
        return this;
    }
}
