package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentIdea {
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
}
