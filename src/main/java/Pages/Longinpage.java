package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Longinpage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By loginPageLink = By.xpath("//a[@href=\"/login\"]");
    private By userName = By.xpath("//input[@data-qa=\"login-email\"]");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    // Constructor
    public Longinpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click on the login link
    public void openLoginPage() {
        driver.findElement(loginPageLink).click();
    }

    // Perform login
    public void login(String user, String pass) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        userField.sendKeys(user);
        passField.sendKeys(pass);
        loginBtn.click();
    }
}
