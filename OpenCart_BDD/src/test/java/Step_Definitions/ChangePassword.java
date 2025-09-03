package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePassword {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in browser for password change")
	public void home_page_should_be_open_in_browser_for_password_change() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on my account and again click on myaccount and click change password and enter fields and click save")
	public void click_on_my_account_and_again_click_on_myaccount_and_click_change_password_and_enter_fields_and_click_save() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.changePassword("deva", "deva");
	}

	@Then("password should be updated")
	public void password_should_be_updated() {
		System.out.println("Password changed");
		driver.close();
	}
}
