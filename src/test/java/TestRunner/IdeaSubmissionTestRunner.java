package TestRunner;

import Pages.CreateCampaign;
import Pages.IdeaSubmission;
import Setup.Setup;
import org.junit.Assert;
import org.testng.annotations.Test;

public class IdeaSubmissionTestRunner extends Setup {
    IdeaSubmission objIdeaSubmission;

    @Test
    public void doSubmitIdea() throws Exception {
        objIdeaSubmission = new IdeaSubmission(driver);
        String result = objIdeaSubmission.Idea();
        Assert.assertTrue(result.contains("Title"));

    }
}
