package Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmMyContactPage {

    private WebDriver driver;

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastName;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstName;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[1]/div[2]/div/div[1]/a/span[2]")
    private WebElement organisationList;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")
    private WebElement organisationChosen;

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/form/div[1]/div/div/div[2]/div[1]/div[4]/button")
    private WebElement submitButton;

    public CrmMyContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CrmMyContactPage lastNameClick() {
        lastName.click();
        return this;
    }

    public CrmMyContactPage lastNameSend(String text) {
        lastName.sendKeys(text);
        return this;
    }

    public CrmMyContactPage firstNameClick() {
        firstName.click();
        return this;
    }

    public CrmMyContactPage firstNameSend(String text) {
        firstName.sendKeys(text);
        return this;
    }

    public CrmMyContactPage organisationListClick() {
        organisationList.click();
        return this;
    }

    public CrmMyContactPage organisationChoose() {
        organisationChosen.click();
        return this;
    }

    public CrmMyContactPage jobTitleClick() {
        jobTitle.click();
        return this;
    }

    public CrmMyContactPage jobTitleSend(String text) {
        jobTitle.sendKeys(text);
        return this;
    }

    public CrmMyContactPage submitButtonClick() {
        submitButton.click();
        return this;
    }
}
