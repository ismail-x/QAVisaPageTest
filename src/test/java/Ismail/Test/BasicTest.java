package Ismail.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasicTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/visa");
        Actions a = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait tunggu = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //Search Negara Asal
        driver.findElement(By.xpath("(//*[@id='select2--container'])[1]")).click();
        a.sendKeys(driver.findElement(By.cssSelector("[type='search']")), "Japan").build().perform();
        driver.findElement(By.cssSelector("[role='option']")).click();

        //Search Negara Tujuan
        driver.findElement(By.xpath("(//*[@id='select2--container'])[2]")).click();
        a.sendKeys(driver.findElement(By.cssSelector("[type='search']")), "Somalia").build().perform();
        driver.findElement(By.cssSelector("[role='option']")).click();

        //Pemilihan Tanggal
        driver.findElement(By.cssSelector("[name='date']")).click();
        driver.findElement(By.cssSelector("[class='day  active']")).click();

        //Submit
        driver.findElement(By.cssSelector("[type='submit']")).click();

        // Next Page

        tunggu.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='first_name']")));

        a.sendKeys(driver.findElement(By.cssSelector("[name='first_name']")), "Ismail").build().perform();
        a.sendKeys(driver.findElement(By.cssSelector("[name='last_name']")), "Ismail").build().perform();
        a.sendKeys(driver.findElement(By.cssSelector("[name='email']")), "uE8oH@example.com").build().perform();
        a.sendKeys(driver.findElement(By.cssSelector("[name='phone']")), "08123456789").build().perform();

        WebElement numberOfDays = driver.findElement(By.cssSelector("[name='number_of_days']"));
        numberOfDays.clear();
        numberOfDays.sendKeys("90");

        driver.findElement(By.name("date")).click();

        WebElement dateElement = tunggu.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(@class, 'active')]")));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".card-header")));
                Thread.sleep(3000l);
        tunggu.until(ExpectedConditions.elementToBeClickable(dateElement)).click();

        Select dropdown = new Select(driver.findElement(By.xpath("(//*[@id='floatingSelect'])[1]")));
        dropdown.selectByValue("multiple");

        Select dropdown2 = new Select(driver.findElement(By.xpath("(//*[@id='floatingSelect'])[2]")));
        dropdown2.selectByValue("study_visa");

        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Notes']")), "this is a notes").build().perform();

        driver.findElement(By.id("submit")).click();

        //Next Page - Konfirmasi

        tunggu.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".rotatingDiv")));

        WebElement submittedText = tunggu.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'We have received your visa details')]"))
        );
        String fullText = submittedText.getText();

// Remove the number at the end using regex
        String cleanedText = fullText.replaceAll("\\d+$", "").trim();
        System.out.println(cleanedText);
        Assert.assertEquals(cleanedText, "We have received your visa details, and one of our representatives will contact you shortly. Your visa registration number is");

        driver.quit();

    }
}
