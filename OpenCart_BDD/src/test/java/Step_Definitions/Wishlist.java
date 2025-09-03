package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wishlist {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in browser for wishlist")
	public void home_page_should_be_open_in_browser_for_wishlist() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on wishlist button")
	public void click_on_wishlist_button() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.wishlist();
	}

	@Then("results should be shown for wishlist")
	public void results_should_be_shown_for_wishlist() {
		System.out.println("Wishlist Results shown");
		driver.close();
	}
}
