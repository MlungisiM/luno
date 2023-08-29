package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverHandler {

    public static WebDriver driver;
    static Properties prop = null;

    //Load config.properties file
    public DriverHandler() {

        prop = new Properties();

        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/config.properties");
            prop.load(propFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProp() {
        return prop;
    }

    //Initialize driver and start browser
    public void startBrowser() {

        String browserName = prop.getProperty("browser");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if ("chrome".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else
            System.out.print("unable to start " + browserName + " browser");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("url");

    }

    //Tear down method - return driver into its initial state
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
