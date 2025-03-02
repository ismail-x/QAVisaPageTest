package Ismail.PageObject;

import Ismail.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage extends AbstractComponent {

    WebDriver driver;
    UserConfirmationVisaPage userConfirmationVisaPage;

    public UserInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="[name='first_name']")
    WebElement userFirstName;

    @FindBy(css ="[name='last_name']")
    WebElement userLastName;

    @FindBy(css = "[name='email']")
    WebElement userEmail;

    @FindBy(css = "[name='phone']")
    WebElement userPhoneNumber;

    @FindBy(css = "[name='number_of_days']")
    WebElement userVisaDays;

    @FindBy(name = "date")
    WebElement userDate;

    @FindBy(css =".card-header")
    WebElement scrolling;

    @FindBy(xpath = "(//*[@id='floatingSelect'])[1]")
            WebElement entryType;

    @FindBy(xpath = "(//*[@id='floatingSelect'])[2]")
    WebElement visaType;

    @FindBy(xpath = "//td[contains(@class, 'active')]")
            WebElement calendarClick;

    @FindBy(css = "[placeholder='Notes']")
    WebElement userNotes;

    @FindBy(id = "submit")
    WebElement userSubmit;

    public UserConfirmationVisaPage inputUserInformationPage(String firstName,
                                                        String lastName,
                                                        String email,
                                                        String phoneNumber,
                                                        String visaDays,
                                                        String entry,
                                                        String visa,
                                                        String notes) throws InterruptedException {

        waitForWebElementToAppear(userFirstName);
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        userEmail.sendKeys(email);
        userPhoneNumber.sendKeys(phoneNumber);
        userVisaDays.clear();
        userVisaDays.sendKeys(visaDays);
        userDate.click();
        waitForElementToBeClick(calendarClick);
        scrollUntilCertainElement(scrolling);
        Thread.sleep(2000l);
        waitForElementToBeClick(calendarClick);
        calendarClick.click();

        selectDropdownValue(entryType,entry);
        selectDropdownValue(visaType,visa);

        userNotes.sendKeys(notes);
        userSubmit.click();

        userConfirmationVisaPage = new UserConfirmationVisaPage(driver);
        return userConfirmationVisaPage;
//        return new UserConfirmationVisaPage(driver);
    }
}
