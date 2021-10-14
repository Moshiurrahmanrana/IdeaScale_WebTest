package Setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

public class Setup {
    public WebDriver driver;
    @BeforeTest
    public void setUp() {
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterTest
    public void Logout() {
//        driver.close();

    }

}
