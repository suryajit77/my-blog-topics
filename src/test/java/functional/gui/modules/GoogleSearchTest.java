package functional.gui.modules;

import com.framework.util.testhelper.AssertSnapshot;
import functional.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.framework.util.Await.awaitUntil;
import static com.framework.util.Await.elementIsDisplayed;

public class GoogleSearchTest extends BaseTest {


    @BeforeMethod
    public void setupTest(){

        googlePage.goTo("https://google.co.in")
                .waitForPageToLoad();

        awaitUntil(elementIsDisplayed, googlePage.getGoogleSearchComponent());

    }

    @Test(priority = 0)
    public void verifyComponentWithCorrectImage() {

        AssertSnapshot.assertThat(takeWebElementScreenshot(googlePage.getGoogleSearchComponent()))
                .matchesWithSnapshot("GoogleSearchComponent.png");
    }


    @Test(priority = 1)
    public void verifyComponentWithIncorrectImage() {

        AssertSnapshot.assertThat(takeWebElementScreenshot(googlePage.getGoogleSearchComponent()))
                .matchesWithSnapshot("GoogleSearchComponentIncorrect.png.png");
    }
}
