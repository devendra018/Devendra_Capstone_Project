package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddress {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in  browser for address")
	public void home_page_should_be_open_in_browser_for_address() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on myaccount and again click myaccount and click modify address and click add addresses and enter fields and save")
	public void click_on_myaccount_and_again_click_myaccount_and_click_modify_address_and_click_add_addresses_and_enter_fields_and_save() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.addAddress("Devendra", "K", "Marathahalli", "Bengaluru", "560032", "India", "Karnataka");
	}

	@Then("address should be added")
	public void address_should_be_added() {
		System.out.println("Address added");
		driver.close();
	}
}
