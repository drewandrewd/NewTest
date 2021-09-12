import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmMyProjectsPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")
    private WebElement createProjectButton;

    public CrmMyProjectsPage clickCreateProjectButton() {
        createProjectButton.click();
        return this;
    }
}
