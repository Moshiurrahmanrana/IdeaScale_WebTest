package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
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

        FirefoxProfile geoDisabled = new FirefoxProfile();
        geoDisabled.setPreference("geo.enabled", false);
        geoDisabled.setPreference("geo.provider.use_corelocation", false);
        geoDisabled.setPreference("geo.prompt.testing", false);
        geoDisabled.setPreference("geo.prompt.testing.allow", false);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);




    }

}
