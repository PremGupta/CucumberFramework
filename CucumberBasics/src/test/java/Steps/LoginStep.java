package Steps;

import Base.Baseutil;
import Pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by prem.gupta on 4/17/2017.
 */
public class LoginStep extends Baseutil {

    private Baseutil base;

    public LoginStep(Baseutil base) {
        this.base = base;
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        /*System.out.println("The driver is : "+base.StepInfo);*/
        String message = "Log in to Facebook";

        if (message.contains("Log in to Facebook")) {
            Assert.assertEquals("Login to Facebook text is not displayed", base.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/span")).isDisplayed(), true);
            System.out.println(message);
            //base.driver.close();
        }
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
         base.driver.navigate().to("https://www.facebook.com/");
        //WebDriver driver=new FirefoxDriver();
       // base.driver.get("https://www.facebook.com/");
    }

   /* @And("^I enter the username as admin and password as admin$")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }*/

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        /*base.driver.findElement(By.xpath("//input[@value='Log In']")).click();*/
        LoginPage page=new LoginPage(base.driver);
        page.ClickLogin();
    }

 /*   @And("^I enter the following details for login$")
    public void iEnterThefollowingDetailsForLogin(DataTable table) throws Throwable {
        //for single data
        // And I enter the username as "admin" and password as "adminpassword"

    }*/

    @And("^I enter the following details for login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) throws Throwable {

     /*   java.util.List<java.util.List<String>> data= table.raw();
        System.out.println("The value is : "+data.get(0).get(0));
        System.out.println("The value is : "+data.get(0).get(1));
        System.out.println("The value is : "+data.get(1).get(0).toString());
        System.out.println("The value is : "+data.get(1).get(1).toString());*/

        //INSTEAD OF ABOVE CODE WE CAN WRITE
        java.util.List<User> users =new ArrayList<User>();

        //Store all the users

        LoginPage page=new LoginPage(base.driver);

        for (User user: users) {
            page.Login(user.username, user.password);
        }

        /*for (User user : users) {
            System.out.println("The username is : " + user.username);
            System.out.println("The password is : " + user.password);
            base.driver.findElement(By.name("email")).sendKeys(user.username);
            base.driver.findElement(By.name("pass")).sendKeys(user.password);
        }*/
    }

    @And("^I enter the ([^\"]*) and ([^\"]*) for login$")
    public void iEnterTheUsernameAndPasswordForLogin(String username, String password) throws Throwable {
        System.out.println("\nUsername is : " + username);
        System.out.println("Password is : " + password);
    }

    @Then("^I should see the userform page for error$")
    public void iShouldSeeTheUserformPageForError() throws Throwable {
        String message = "Log in to Facebook";

        if (message.contains("Log in to Facebook")) {
            Assert.assertEquals("Login to Facebook text is not displayed", base.driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed(), true);
            System.out.println(message);
            //base.driver.close();
        }
    }

    //for single data it's good but not for multiple data set
    /*@And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
       System.out.println(" Username is : "+username+ "\n Password is : "+password);
    }*/

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            this.username = userName;
            this.password = passWord;
        }
    }
}
