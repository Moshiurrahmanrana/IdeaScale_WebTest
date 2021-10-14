package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CreateCampaign {
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
    @FindBy(xpath = "//*[@id=\"tab-campaign\"]/div[2]/button[1]")
    WebElement SDraftBtn;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/section/div[2]/div[2]/ul/li/div/div[2]/div[2]/ul/li[1]/div[1]")
    WebElement lblConfirmation;

    public CreateCampaign(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String doCreate() throws InterruptedException {
        driver.get("https://trialqa.ideascale.com");

        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector("button"));
        action.click(list.get(0)).perform();
        EmailBox.sendKeys("trialqa.ideascale@gmail.com");
        passwordBox.sendKeys("a@123456#");
        //LogInBtn
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/section/div/div/form/div[4]/button"))).click();
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))).click();
        Thread.sleep(10000);
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='is-svg-icon topbar-icon arrow-icon']"))).click();
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"utb-user-menu\"]/ul/li[2]/a"))).click();
//        CommunityBtn.click();
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        //switch to open tab
        driver.switchTo().window(w.get(1));
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Engagement')]"))).click();
//        EngageBtn.click();
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Campaigns')]"))).click();
//        campaignsBtn.click();
//        Thread.sleep(10000);
        ArrayList<String> h = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(h.get(2));
        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/div/section/div[2]/div[1]/a[2]"))).click();
//        CreateCamBtn.click();
        NameText.sendKeys("Nothing");
        saveBtn.click();
        ScheduleBtn.click();
        SDraftBtn.click();
        return lblConfirmation.getText();

    }
}
