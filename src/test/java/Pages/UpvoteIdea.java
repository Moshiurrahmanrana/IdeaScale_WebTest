package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UpvoteIdea {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "login-email")
    WebElement EmailBox;
    @FindBy(id = "login-password")
    WebElement passwordBox;
    @FindBy(xpath = "/html/body/div[5]/section/div/div/form/div[4]/button")
    WebElement LogInBtn;
    @FindBy(id = "new-idea-button")
    WebElement SubmitIdeaBtn;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/button[2]")
    WebElement cookiesBtn;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div/article/form/div[2]/div/div/div[1]/span/span[1]/span")
    WebElement CampaignName;
    @FindBy(id = "idea-title-input")
    WebElement TitleBox;
    @FindBy(id = "idea-desc-value")
    WebElement DescriptionBox;
    @FindBy(xpath = "//*[@id=\"idea-form\"]/div[4]/div/button")
    WebElement SubmitBtn;
    @FindBy(xpath = "//*[@id=\"vote-up-380805\"]")
    WebElement upVoteBtn;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div[2]/article[1]/div[2]/section/div[1]/div[1]/strong")
    WebElement count;

    public UpvoteIdea(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String upVote() throws InterruptedException {
        driver.get("https://trialqa.ideascale.com");

        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector("button"));
        action.click(list.get(0)).perform();
        EmailBox.sendKeys("trialqa.ideascale@gmail.com");
        passwordBox.sendKeys("a@123456#");
        Thread.sleep(2000);
        LogInBtn.click();
        SubmitIdeaBtn.click();
        Thread.sleep(10000);
        cookiesBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        TitleBox.sendKeys("hlw");
        return count.getText();
    }
}
