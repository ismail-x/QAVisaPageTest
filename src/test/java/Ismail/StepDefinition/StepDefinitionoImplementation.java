package Ismail.StepDefinition;

import Ismail.PageObject.LandingPage;
import Ismail.PageObject.UserConfirmationVisaPage;
import Ismail.PageObject.UserInformationPage;
import Ismail.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionoImplementation extends BaseTest {

    public LandingPage landingPage;
    public UserInformationPage userInformationPage;
    private UserConfirmationVisaPage userConfirmationVisaPage;

    @Given("I am landed on visa page")
    public void I_am_landed_on_visa_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Inserting from country (.+) and to country (.+) and current date$")
    public void Inserting_from_country_and_to_country_and_current_date(String negaraAsal, String negaraTujuan) throws IOException {
        landingPage.submitCountry(negaraAsal, negaraTujuan);
        landingPage.calendarSubmit();
        userInformationPage = landingPage.landingPageSubmitted();
    }

    // PAKE INI KALO MAU POSITIVE TEST CASE
//    @Given("^Enter first name (.+) and last name (.+) and Enter email (.+) and phone number (\\d+) and with duration (\\d+) and entry type (.+) and Select visa type (.+) and Add notes (.+)$")
//    public void enter_user_information_and_submit_visa_details(
//            String firstName, String lastName, String email, String phoneNumber, String visaDays, String entry, String visa, String notes) throws InterruptedException {
//        userConfirmationVisaPage = userInformationPage.inputUserInformationPage(
//                firstName,
//                lastName,
//                email,
//                phoneNumber,
//                visaDays,
//                entry,
//                visa,
//                notes
//        );
//    }

    //PAKE INI KALO MAU NEGATIVE TEST CASE
    @Given("^Enter first name (.+) and last name (.+) and Enter email (.+) and phone number (.+) and with duration (.+) and entry type (.+) and Select visa type (.+) and Add notes (.+)$")
    public void enter_user_information_and_submit_visa_details(
            String firstName, String lastName, String email, String phoneNumber, String visaDays, String entry, String visa, String notes) throws InterruptedException {
        userConfirmationVisaPage = userInformationPage.inputUserInformationPage(
                firstName,
                lastName,
                email,
                phoneNumber,
                visaDays,
                entry,
                visa,
                notes
        );
    }

    @Then("^I should see the confirmation message (.+)$")
    public void Confirmation_page(String expectedText) {
        String actualConfirmationText = userConfirmationVisaPage.confirmationVisaOrder();
        Assert.assertEquals(actualConfirmationText, expectedText, "Confirmation message does not match expected text.");
    }
}