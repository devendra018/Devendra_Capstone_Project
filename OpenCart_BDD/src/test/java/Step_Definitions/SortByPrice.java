package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortByPrice {
	WebDriver driver;
	WebDriverWait wait;
	@Given("search page should be open in browser")
	public void search_page_should_be_open_in_browser() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on search button and perform search and click on sort by price low to high")
	public void click_on_search_button_and_perform_search_and_click_on_sort_by_price_low_to_high() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.sortBy();
	}

	@Then("sort results should be shown")
	public void sort_results_should_be_shown() {
		System.out.println("Sort By Price Functionality");
		driver.close();
	}
}
