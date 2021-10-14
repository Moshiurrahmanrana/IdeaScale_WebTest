package TestRunner;

import Pages.UpvoteIdea;
import Setup.Setup;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UpVoteTestRunner extends Setup {
    UpvoteIdea objUpvoteIdea;

    @Test
    public void Vote() throws Exception {
        objUpvoteIdea = new UpvoteIdea(driver);
        String result = objUpvoteIdea.upVote();
        Assert.assertEquals(result,1);

    }
}
