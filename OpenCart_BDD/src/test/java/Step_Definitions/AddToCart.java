package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in  browser for cart")
	public void home_page_should_be_open_in_browser_for_cart() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on search button and search product and then add to cart")
	public void click_on_search_button_and_search_product_and_then_add_to_cart() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.addToCart("2");
	}

	@Then("product should add to cart")
	public void product_should_add_to_cart() {
		System.out.println("Item added to cart");
		driver.close();
	}
}
