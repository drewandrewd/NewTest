import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmMyProjectPage {

    private WebDriver driver;

    private final String contactContainer = "select2-container-disabled";
    private final String businessUnit_name = "crm_project[businessUnit]";
    private final String businessText = "Research & Development";
    private final String curator_name = "crm_project[curator]";
    private final String selectText = "Applanatest Applanatest Applanatest";
    private final String rp_name = "crm_project[rp]";
    private final String administrator_name = "crm_project[administrator]";
    private final String manager_name = "crm_project[manager]";

    @FindBy(name = "crm_project[name]")
    private WebElement projectName;

    @FindBy(css = ".select2-default > .select2-arrow")
    private WebElement organisationChosen;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")
    private WebElement organisationList;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[4]/div[1]/div[2]/div/a/span[2]")
    private WebElement contactChosen;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")
    private WebElement contact;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement submit;

    public CrmMyProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CrmMyProjectPage nameClick() {
        projectName.click();
        return this;
    }

    public CrmMyProjectPage sendName(String text) {
        projectName.sendKeys(text);
        return this;
    }

    public CrmMyProjectPage organisationClick() {
        organisationChosen.click();
        return this;
    }

    public CrmMyProjectPage organisationDropMenu() {
        organisationList.click();
        return this;
    }

    public void waitForContact() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(By.className(contactContainer)));
    }

    public CrmMyProjectPage contactClick() {
        contactChosen.click();
        return this;
    }

    public CrmMyProjectPage chooseContact() {
        contact.click();
        return this;
    }

    public void select(String path, String text) {
        new Select(driver.findElement(By.name(path))).selectByVisibleText(text);
    }

    public void selectBusiness() {
        select(businessUnit_name, businessText);
    }

    public void selectCurator() {
        select(curator_name, selectText);
    }

    public void selectRp() {
        select(rp_name, selectText);
    }

    public void selectAdministrator() {
        select(administrator_name, selectText);
    }

    public void selectManager() {
        select(manager_name, selectText);
    }

    public CrmMyProjectPage submitClick() {
        submit.click();
        return this;
    }
}
