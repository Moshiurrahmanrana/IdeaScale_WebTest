package TestRunner;

import Pages.CreateCampaign;
import Pages.UpvoteIdea;
import Setup.Setup;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpVoteTestRunner extends Setup {
    UpvoteIdea objUpvoteIdea;

    @Test
    public void doUpVote() throws Exception {
        objUpvoteIdea = new UpvoteIdea(driver);
        String result = objUpvoteIdea.upVote();
        Assert.assertEquals(result,"1");

    }
}
