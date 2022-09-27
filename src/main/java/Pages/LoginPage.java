package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

import java.awt.*;

public class LoginPage {
    private ElementActions elementAction;


    public LoginPage(WebDriver driver) throws AWTException {
        elementAction = new ElementActions(driver);
    }

    private By email_TextField   = By.id("email");
    private By password_TextField = By.id("password");
    private By login_Button       = By.className("signup__submit");


    /**
     * Login Using email and password
     * @param email  user email
     * @param pass   user password
     * ***/
    public LoginPage loginWithValidCredentials(String email , String pass) {

        elementAction.clearTextThenWrite(email_TextField,email);
        elementAction.clearTextThenWrite(password_TextField,pass);
        elementAction.click(login_Button);
        return this ;
    }




}
