package Project;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;


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

    @Attachment(value = "Вложение_1", type = "text/plain", fileExtension = ".doc")
    public void getPage(String text) {
        driver.get(text);
    }

    @Attachment(value = "Вложение_2", type = "text/plain", fileExtension = ".doc")
    public String getResult() {
        return driver.switchTo().frame(0).findElement(By.xpath(content_xpath)).getText();
    }

    @Step(value = "Выбор жирного шрифта")
    public NotePage clickBoldIcon() {
        boldIcon.click();
        return this;
    }

    @Step(value = "Переключение в окно ввода")
    public void frameOne(int frame) {
        driver.switchTo().frame(frame);
    }

//    public NotePage clickMainContent() {
//        mainContent.click();
//        return this;
//    }
    @Step(value = "Напечатать текст")
    public NotePage sendTextMainContent(String text) {
        mainContent.sendKeys(text);
        return this;
    }

    @Step(value = "Напечатать текст и нажать Enter")
    public void doSomeAction(String text) {
        action
                .sendKeys(Keys.ENTER)
                .sendKeys(text)
                .build()
                .perform();
    }

    @Step(value = "Переключится во внешнее окно")
    public void defaultFrame() {
        driver.switchTo().defaultContent();
    }

    @Step(value = "Выбрать текст типа ссылка")
    public NotePage clickLinkButton() {
        linkButton.click();
        return this;
    }

    @Step(value = "Кликнуть в поле ввода")
    public NotePage clickInputArea() {
        inputArea.click();
        return this;
    }

    @Step(value = "Ввести текст в поле ввода")
    public NotePage sentTextInputArea(String text) {
        inputArea.sendKeys(text);
        return this;
    }

    @Step(value = "Кликнуть кнопку сохранить")
    public NotePage clickSaveButton() {
        saveButton.click();
        return  this;
    }

}
