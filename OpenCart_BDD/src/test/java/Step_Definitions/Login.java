package Step_Definitions;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Login {
	WebDriver driver;
	WebDriverWait wait;
	@Given("Login Page should be opened")
	public void login_page_should_be_opened() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Enter email and password and then click login button")
	public void enter_email_and_password_and_then_click_login_button() {
		OpenCartPOM ocp = new OpenCartPOM(driver);
		ocp.login("devendra7981676@gmail.com", "deva");
	}

	@Then("login successful")
	public void login_successful() {
		System.out.println("Login Successful");
		driver.close();
	}
}
