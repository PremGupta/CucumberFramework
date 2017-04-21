package Steps;

import Base.Baseutil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.plaf.basic.BasicEditorPaneUI;

/**
 * Created by prem.gupta on 4/18/2017.
 */
public class Hooks extends Baseutil{

    private Baseutil base;
    public Hooks(Baseutil base) {
        this.base = base;
    }
    @Before
    public void InitializeTest() {
        System.out.println("Opening the browser : Firefox");

       /* //passing a dummmy webdriver instance
        base.StepInfo = "FirefoxDriver";*/

        System.setProperty("webdriver.firefox.marionette", "C:\\Users\\prem.gupta\\Downloads\\geckodriver.exe");
        base.driver=new FirefoxDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed())
            //take screenshot code
            System.out.println("Closing the browser : Firefox");
        //base.driver.close();
    }
}
