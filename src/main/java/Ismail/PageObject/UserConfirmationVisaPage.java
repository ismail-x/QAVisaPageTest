package Ismail.PageObject;

import Ismail.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserConfirmationVisaPage extends AbstractComponent {

    WebDriver driver;

    public UserConfirmationVisaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rotatingDiv")
    WebElement loadingCircle;

    @FindBy(xpath = "//p[contains(text(), 'We have received your visa details')]")
    WebElement confirmationText;

    public String confirmationVisaOrder(){
        waitForElementToDisappear(loadingCircle);
        waitForWebElementToAppear(confirmationText);
        String fullText = confirmationText.getText();
        String cleanText = fullText.replaceAll("\\d+$", "").trim();
        System.out.println(cleanText);
        return cleanText;
    }

}
