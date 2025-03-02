package Ismail.TestComponents;

import Ismail.PageObject.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;


    public WebDriver initializeDriver() throws IOException {

        //properties class

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                +"//src//main//java//Ismail//Resources//GlobalData.properties");
        prop.load(file);

        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty(("browser"));
        String headlessMode = System.getProperty("headless", "false"); // Default to false

        if(browserName.equalsIgnoreCase("chrome")){

            ChromeOptions options = new ChromeOptions();

            if (headlessMode.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")){
            //firefox browser driver setting
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            //Edge browser driver setting
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

        //read JSON to String
        String jsonContent = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

        //String to HashMap with Jackson DataBind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {

        String screenshotPath = null;
        try{
            //take screenshot and save it in a file
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //copy the file to the required path
            File destinationFile = new File(System.getProperty("user.dir")+"/reports/"+TestCaseName+"_image_" + ".png");
            FileHandler.copy(sourceFile, destinationFile);
            String[] relatvePath = destinationFile.toString().split("reports");
            screenshotPath = ".//" + relatvePath[1];
        }
        catch(Exception e){
            System.out.println("Failure to take screenshot "+e);
        }
        return screenshotPath;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {

        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
