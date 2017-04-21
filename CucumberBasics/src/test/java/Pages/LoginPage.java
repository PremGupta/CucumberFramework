package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by prem.gupta on 4/20/2017.
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "email")
    public WebElement textUserName;

    @FindBy(how = How.NAME, using = "pass")
    public WebElement textPassword;

    @FindBy(how = How.XPATH, using = "//input[@value='Log In']")
    public WebElement btnLogin;

    public void Login(String userName, String passWord)
    {
        textUserName.sendKeys(userName);
        textPassword.sendKeys(passWord);
    }

    public void ClickLogin()
    {
        btnLogin.click();
    }

}
