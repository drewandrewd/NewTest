import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmLoginPage {

    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement loginTitle;

    @FindBy(id = "prependedInput")
    private WebElement loginInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement submitLoginButton;

    public CrmLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getPage(String text) {
        driver.get(text);
    }

    public CrmLoginPage clickLoginInput() {
        loginInput.click();
        return this;
    }

    public CrmLoginPage sendKeysLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public CrmLoginPage clickPasswordInput() {
        passwordInput.click();
        return this;
    }

    public CrmLoginPage sendKeysPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public CrmLoginPage clickSubmitLoginButton() {
        submitLoginButton.click();
        return this;
    }
}
