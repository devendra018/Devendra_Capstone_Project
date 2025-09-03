package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDDT {
	WebDriver driver;
	WebDriverWait wait;
	@Given("login page should be open in default browser")
	public void login_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("click on username button and enter (.*) and (.*) and click signin button$")
	public void click_on_username_button_and_enter_username_and_password_and_click_signin_button(String email1, String password1) {
		OpenCartPOM ocp = new OpenCartPOM(driver);
	    ocp.login(email1,password1);
	}

	@Then("login successfully and open home page")
	public void login_successfully_and_open_home_page() throws InterruptedException {
	   Thread.sleep(2000);
	   driver.close();
	}
}
