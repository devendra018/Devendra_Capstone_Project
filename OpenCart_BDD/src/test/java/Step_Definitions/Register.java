package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;
	WebDriverWait wait;
	@Given("Register Page should be opened")
	public void register_page_should_be_opened() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Enter Data in all fields and click continue")
	public void enter_data_in_all_fields_and_click_continue() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.register("Devendra", "K", "devendra7981676@gmail.com", "1234567890", "deva", "deva");
	}

	@Then("Account should be created")
	public void account_should_be_created() {
		System.out.println("Registration Successful");
		driver.close();
	}

}
