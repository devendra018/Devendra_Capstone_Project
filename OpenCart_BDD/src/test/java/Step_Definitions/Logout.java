package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in browser for logout")
	public void home_page_should_be_open_in_browser_for_logout() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on myaccount and click on logout button")
	public void click_on_myaccount_and_click_on_logout_button() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.logout();
	}

	@Then("user should be logged out")
	public void user_should_be_logged_out() {
		System.out.println("User Logged out");
		driver.close();
	}
}
