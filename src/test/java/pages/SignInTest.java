package pages;

import commons.DataProvider;
import commons.BaseSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class SignInTest extends BaseSetup {


    @BeforeMethod
    public void setup() {
        setDriverPath();
        intialize();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
    }


    @Test(priority = 1)
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("signInButton")).click();
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }


    @Test(priority = 2)
    public void successfulLogin() throws FileNotFoundException {
        DataProvider dataProvider = new DataProvider();
        String credentials = dataProvider.readData("login.csv");
        String userCred[] = credentials.split(",");
        Login login = new Login();
        login.signin();
        driver.switchTo().frame("modal_window");
        SignIn signIn = new SignIn();
        signIn.signin(userCred[0], userCred[1]);
        waitFor(5000);
        String profileName = driver.findElement(By.id("userAccountLink")).getAttribute("title");
        Assert.assertEquals("jyothi92.jain@gmail.com", profileName);
        driver.quit();

    }

}
