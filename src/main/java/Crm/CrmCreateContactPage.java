package Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmCreateContactPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")
    private WebElement createContactButton;

    public CrmCreateContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CrmCreateContactPage clickCreateContact() {
        createContactButton.click();
        return this;
    }
}
