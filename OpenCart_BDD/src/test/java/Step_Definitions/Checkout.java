package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in browser for checkout")
	public void home_page_should_be_open_in_browser_for_checkout() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on checkout cart button")
	public void click_on_checkout_cart_button() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.checkout();
	}

	@Then("results should be shown for checkout")
	public void results_should_be_shown_for_checkout() {
		System.out.println("Checkout Page results shown");
		driver.close();
	}
}
