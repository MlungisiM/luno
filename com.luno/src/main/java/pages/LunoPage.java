package pages;

import common.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LunoPage extends DriverHandler {
    //Page Objects
    @FindBy(xpath = "/html/body/luno-auth-app/luno-navigation/mat-sidenav-container/mat-sidenav-content/luno-navigation-top/nav/menu/luno-button/luno-anchor-with-url-button/a/span[1]")
    WebElement signUp;
    @FindBy(xpath = "//*[@id=\"mat-input-1\"]")
    WebElement emailsignUp;
    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    WebElement passwordsignUp;

    @FindBy(xpath = "/html/body/luno-auth-app/luno-navigation/mat-sidenav-container/mat-sidenav-content/main/luno-signup/section/luno-content/mat-card/form/div/mat-card-actions/luno-button/luno-submit-button/button/span[1]")
    WebElement letsGobutton;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    WebElement Captcha;

    WebDriverWait wait;

    //Initialize Page Objects
    public LunoPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterUsername(String usernaname) {
        wait.until(ExpectedConditions.visibilityOf(emailsignUp)).sendKeys(usernaname);
    }

    public void enterPassword(String password) {
        passwordsignUp.sendKeys(password);
    }

    public void clickletsGobutton() {
        letsGobutton.click();
    }
    public void clickCaptchabutton() {
        Captcha.click();
    }

}
