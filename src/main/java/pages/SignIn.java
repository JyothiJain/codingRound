package pages;

import commons.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jyothijain on 16/08/18.
 */
public class SignIn extends BaseSetup {

    private SignInPageObjects signInPageObjects;

    public SignIn() {

        signInPageObjects = new SignInPageObjects();
        PageFactory.initElements(driver, signInPageObjects);
    }


    /*LoginMethod*/
    public boolean signIn(String emailId, String password) {
        signInPageObjects.emailId.sendKeys(emailId);
        signInPageObjects.password.sendKeys(password);
        signInPageObjects.signInButton.click();
        return true;
    }

    private class SignInPageObjects {
        @CacheLookup
        @FindBy(id = "email")
        private WebElement emailId;

        @CacheLookup
        @FindBy(id = "password")
        private WebElement password;

        @CacheLookup
        @FindBy(id = "signInButton")
        private WebElement signInButton;
    }


}
