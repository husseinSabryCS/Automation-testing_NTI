package tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Longinpage;

public class LoginTests {
    WebDriver driver;
    Longinpage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
       loginPage = new Longinpage(driver);

    }

    @Test
    public void login() {
loginPage.openLoginPage();
loginPage.login("s7s@gmail.com", "123456789");

    }
    @Test
    public void loginByInvalidEmail() {
        loginPage.openLoginPage();
        loginPage.login("invalid@gmail.com", "123456789");


    }
    public void loginByInvalidPassword() {
        loginPage.openLoginPage();
        loginPage.login("invalid@gmail.com", "123456785");

    }
    public void loginByEmptyEmail() {
        loginPage.openLoginPage();
        loginPage.login("", "123456789");

    }
    public void loginByEmptyPassword() {
        loginPage.openLoginPage();
        loginPage.login("s7s@gmail.com", "");

    }
    public void loginByEmptyPasswordAndEmail() {
        loginPage.openLoginPage();
        loginPage.login("", "");
    }
    public void loginBySwabEmailAndPassword() {
        loginPage.openLoginPage();
        loginPage.login("123456789", "S7s@gmail.com");
    }

//    @AfterMethod
//    public void tearDown() {
//
//        driver.quit();
//    }
}
