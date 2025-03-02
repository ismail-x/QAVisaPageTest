package Ismail.PageObject;

import Ismail.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver) {

        super(driver); //this is for AbstractComponent.java

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(id="userEmail")
//    WebElement userEmail;

    @FindBy(xpath = "(//*[@id='select2--container'])[1]")
    WebElement fromCountry;

    @FindBy(css = "[type='search']")
    WebElement inputFromCountry;

    @FindBy(css = "[role='option']")
    WebElement clickFromCountry;

    @FindBy(xpath = "(//*[@id='select2--container'])[2]")
    WebElement goToCountry;

    @FindBy(css = "[type='search']")
    WebElement inputGoToCountry;

    @FindBy(css = "[role='option']")
    WebElement clickGoToCountry;

    @FindBy(css = "[name='date']")
    WebElement clickCalendar;

    @FindBy(css ="[class='day  active']")
    WebElement chooseDate;

    @FindBy(css = "[type='submit']")
    WebElement submitLandingPage;

    public void submitCountry(String negaraAsal, String negaraTujuan){
        //Negara Asal
        fromCountry.click();
        inputFromCountry.sendKeys(negaraAsal);
        clickFromCountry.click();
        //Negara Tujuan
        goToCountry.click();
        inputGoToCountry.sendKeys(negaraTujuan);
        clickGoToCountry.click();
    }

    public void calendarSubmit(){
        //Pemilihan Tanggal
        clickCalendar.click();
        chooseDate.click();
    }

    public UserInformationPage landingPageSubmitted(){
        submitLandingPage.click();
        UserInformationPage userInformationPage = new UserInformationPage(driver);
        return userInformationPage;
    }

    public void goTo (){

        driver.get("https://www.phptravels.net/visa");
    }

}
