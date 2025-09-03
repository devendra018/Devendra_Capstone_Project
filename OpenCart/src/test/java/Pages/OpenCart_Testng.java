package Pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OpenCart_Testng {
	WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		  driver = new ChromeDriver();
		  driver.get("https://tutorialsninja.com/demo/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
  @Test (priority =1)
  public void register() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.register("Devendra", "K", "devendra79816@gmail.com", "1234567890", "deva", "deva");
  }
  
  @Test (priority =2)
  public void login() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.login("devendra79816@gmail.com", "deva");
  }
  
  @Test(priority =3)
  public void search() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.search("macbook");
  }
  
  @Test(priority =4)
  public void sortByPrice() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.sortBy();
  }
  
  @Test(priority =5)
  public void addToCart() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.addToCart("2");
  }
  
  @Test(priority =6)
  public void removeFromCart() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.removeFromCart();
  }
  
  @Test(priority =7)
  public void wishlist() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.wishlist();
  }
  
  @Test(priority =8)
  public void checkout() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.checkout();
  }
  
  @Test(priority =9)
  public void addAddress() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.addAddress("Devendra", "K", "Marathahalli", "Bengaluru", "560032", "India", "Karnataka");
  }
  
  @Test(priority =10)
  public void changePassword() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.changePassword("devendra", "devendra");
  }
  
  @Test(priority =11)
  public void logout() {
	  OpenCartPOM ocp = new OpenCartPOM(driver);
	  ocp.logout();
  }
  

  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}