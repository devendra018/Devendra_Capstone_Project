package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveFromCart {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in browser for remove cart")
	public void home_page_should_be_open_in_browser_for_remove_cart() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on cart remove product from cart")
	public void click_on_cart_remove_product_from_cart() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.removeFromCart();
	}

	@Then("product should removed from cart")
	public void product_should_removed_from_cart() {
		System.out.println("Item removed from cart");
		driver.close();
	}
}
