package TestRunner;

import Pages.CreateCampaign;
import Setup.Setup;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CreateCampaignTestRunner extends Setup {

    CreateCampaign objCreateCampaign;

    @Test
    public void doCreateCam() throws Exception {
        objCreateCampaign = new CreateCampaign(driver);
        String result = objCreateCampaign.doCreate();
        Assert.assertTrue(result.contains("Nothing"));

    }

}