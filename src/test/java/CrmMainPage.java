import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmMainPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/a/span")
    private WebElement projectsButton;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a")
    private WebElement myProjectsButton;

    public CrmMainPage clickMyProjectsButton() {
        myProjectsButton.click();
        return this;
    }
}
