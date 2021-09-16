package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NotePage {

    private WebDriver driver;
    private Actions action;

    private final String content_xpath = "/html/body";

    @FindBy(css = ".cke_button__bold_icon")
    private WebElement boldIcon;

    @FindBy(xpath = "/html/body")
    private WebElement mainContent;

    @FindBy(xpath = "//*[@id=\"cke_17\"]/span[1]")
    private WebElement linkButton;

    @FindBy(tagName = "input")
    private WebElement inputArea;

    @FindBy(linkText = "Сохранить")
    private WebElement saveButton;

    public NotePage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    public void getPage(String text) {
        driver.get(text);
    }

    public String getResult() {
        return driver.switchTo().frame(0).findElement(By.xpath(content_xpath)).getText();
    }

    public NotePage clickBoldIcon() {
        boldIcon.click();
        return this;
    }

    public void frameOne(int frame) {
        driver.switchTo().frame(frame);
    }

    public NotePage clickMainContent() {
        mainContent.click();
        return this;
    }

    public NotePage sendTextMainContent(String text) {
        mainContent.sendKeys(text);
        return this;
    }

    public void doSomeAction(String text) {
        action
                .sendKeys(Keys.ENTER)
                .sendKeys(text)
                .build()
                .perform();
    }

    public void defaultFrame() {
        driver.switchTo().defaultContent();
    }

    public NotePage clickLinkButton() {
        linkButton.click();
        return this;
    }

    public NotePage clickInputArea() {
        inputArea.click();
        return this;
    }

    public NotePage sentTextInputArea(String text) {
        inputArea.sendKeys(text);
        return this;
    }

    public NotePage clickSaveButton() {
        saveButton.click();
        return  this;
    }

}
