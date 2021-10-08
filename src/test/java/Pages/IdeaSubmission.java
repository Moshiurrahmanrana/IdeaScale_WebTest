package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class IdeaSubmission {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[1]/div/div[2]/button[2]")
    WebElement cookiesBtn;
    @FindBy(id = "login-email")
    WebElement EmailBox;
    @FindBy(id = "login-password")
    WebElement passwordBox;
    @FindBy(xpath = "/html/body/div[5]/section/div/div/form/div[4]/button")
    WebElement LogInBtn;
    @FindBy(id = "topbar-avatar")
    WebElement settingsBtn;
    @FindBy(xpath = "//*[@id=\"utb-user-menu\"]/ul/li[2]/a")
    WebElement CommunityBtn;
    @FindBy(xpath = "//a[contains(text(),'Engagement')]")
    WebElement EngageBtn;
    @FindBy(xpath = "//a[contains(text(),'Campaigns')]")
    WebElement campaignsBtn;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/section/div[2]/div[1]/a[2]")
    WebElement CreateCamBtn;
    @FindBy(id = "category-name-field")
    WebElement NameText;
    @FindBy(xpath = "//*[@id=\"tab-campaign\"]/div[2]/div/button")
    WebElement saveBtn;
    @FindBy(xpath = "//*[@id=\"tab-campaign\"]/div[1]/ul/li[7]/a")
    WebElement ScheduleBtn;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/section/form/div/div[2]/section[1]/div[2]/div[2]/button")
    WebElement Launch;
    @FindBy(xpath = "/html/body/div[2]/nav/div/a/img")
    WebElement backBtn;
    @FindBy(id = "new-idea-button")
    WebElement SubmitIdeaBtn;
    @FindBy(id = "idea-title-input")
    WebElement TitleBox;
    @FindBy(id = "idea-desc-value")
    WebElement DescriptionBox;
    @FindBy(xpath = "/html/body/div[5]/div/div/div/article/form/div[4]/div/button")
    WebElement SubmitBtn;

    @FindBy(xpath = "/html/body/div[5]/div[1]/div[1]/div/article/header/h1")
    WebElement lblTitle;

    public IdeaSubmission(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String Idea() throws InterruptedException {
        driver.get("https://trialqa.ideascale.com");

        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector("button"));
        action.click(list.get(0)).perform();
        EmailBox.sendKeys("trialqa.ideascale@gmail.com");
        passwordBox.sendKeys("a@123456#");
        Thread.sleep(2000);
        LogInBtn.click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))).click();
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='is-svg-icon topbar-icon arrow-icon']"))).click();
        CommunityBtn.click();
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        //switch to open tab
        driver.switchTo().window(w.get(1));
        EngageBtn.click();
        campaignsBtn.click();
        Thread.sleep(10000);
        ArrayList<String> h = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(h.get(2));
        CreateCamBtn.click();
        NameText.sendKeys("Nothing");
        saveBtn.click();
        ScheduleBtn.click();
        Thread.sleep(5000);
        WebElement LaunchDate= driver.findElement(By.id("/html/body/div[5]/div[1]/div/section/form/div/div[2]/section[1]/div[2]/div[1]/div/div/input[2]"));
//        LaunchDate.clear();
        LaunchDate.sendKeys("12/Oct/21 12:00 PM");
        Launch.click();
        backBtn.click();
        SubmitIdeaBtn.click();
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/button[2]")));
        //Thread.sleep(10000);
        cookiesBtn.click();
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))).click();

        List<WebElement> campaignDropdown = driver.findElements(By.cssSelector("[role=combobox]"));
        Actions action2 = new Actions(driver);
        action2.click(campaignDropdown.get(0)).perform();
        Thread.sleep(1000);
        campaignDropdown.get(0).sendKeys(Keys.ARROW_DOWN);
        campaignDropdown.get(0).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        TitleBox.click();
        TitleBox.sendKeys("Title");
        Thread.sleep(3000);
        DescriptionBox.sendKeys("this is description");
        Thread.sleep(7000);
//        wait = new WebDriverWait(driver, 50);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div/article/form/div[4]/div/button")));
        SubmitBtn.click();
        Thread.sleep(5000);
        return lblTitle.getText();
    }
}