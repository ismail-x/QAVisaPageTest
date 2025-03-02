package Ismail.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    Select dropdown;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void scrollUntilCertainElement(WebElement findBy){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", findBy);
    }

    public void waitForElementToAppear(By findBy) {

        WebDriverWait tunggu = new WebDriverWait(driver, Duration.ofSeconds(10));
        tunggu.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait tunggu = new WebDriverWait(driver, Duration.ofSeconds(10));
        tunggu.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitForElementToDisappear(WebElement ele) {

        WebDriverWait tunggu = new WebDriverWait(driver, Duration.ofSeconds(10));
        tunggu.until(ExpectedConditions.invisibilityOf(ele));

    }

    public void waitForElementToBeClick(WebElement findBy) {

        WebDriverWait tunggu = new WebDriverWait(driver, Duration.ofSeconds(10));
        tunggu.until(ExpectedConditions.elementToBeClickable(findBy));

    }

    public void selectDropdownValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}
