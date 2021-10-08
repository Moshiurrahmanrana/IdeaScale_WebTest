package TestRunner;

import Pages.CommentIdea;
import Pages.UpvoteIdea;
import Setup.Setup;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CommentIdeaTestRunner extends Setup {
    CommentIdea objCommentIdea;
    @Test
    public void doComment() throws Exception {
        objCommentIdea = new CommentIdea(driver);
        String result = objCommentIdea.Comment();
        Assert.assertTrue(result.contains("This is good Idea"));

    }
}
