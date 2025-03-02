package Ismail.Test;


import Ismail.PageObject.UserConfirmationVisaPage;
import Ismail.PageObject.UserInformationPage;
import Ismail.TestComponents.BaseTest;
import Ismail.TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class FinishedTest extends BaseTest {

    @Test(dataProvider = "getData", retryAnalyzer = Retry .class)
    public void CompletePositiveTest(HashMap<String, String> input) throws InterruptedException {

//        landingPage.submitCountry("negaraAsal","NegaraTujuan");
        landingPage.submitCountry(input.get("negaraAsal"), input.get("negaraTujuan"));
        landingPage.calendarSubmit();

        //User Submit Negara
        UserInformationPage userInformationPage = landingPage.landingPageSubmitted();

        // Next Page
        //User Submit Data

        UserConfirmationVisaPage userConfirmationVisaPage = userInformationPage.inputUserInformationPage(
                input.get("firstName"),
                input.get("lastName"),
                input.get("email"),
                input.get("phoneNumber"),
                input.get("visaDays"),
                input.get("entry"),
                input.get("visa"),
                input.get("notes")
        );

        //Next Page - Konfirmasi
        // Confirmation page verification

        String actualConfirmationText = userConfirmationVisaPage.confirmationVisaOrder();
        String expectedText = (input.get("expectedText"));
        Assert.assertEquals(actualConfirmationText, expectedText);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Ismail//Data//UserInput.json");

        return new Object[][] {
                {data.get(0)},
        };
    }
}
