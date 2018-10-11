package stepdefinition;

import utility.Drivers;
import objectModel.LoginMethods;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

public class Steps {
	
	private static WebDriver driver = Drivers.driver;
     
	@When("^enter username$")
	public void enter_username() throws Throwable {
		LoginMethods.enterUsername();
	}
 
	@When("^enter password$")
	public void enter_password() throws Throwable {
		LoginMethods.enterPassword();
	}
 
	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {		   
	   Assert.assertTrue(LoginMethods.verifyMessage());
	}

	@Given("^Open Application and Enter url as \"([^\"]*)\"$")
	public void openApplicationAndEnterUrlAs(String arg1) throws Throwable {
		driver.get(arg1);
	}
}