package Step_Definitions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCartPOM {
	WebDriver driver;
	WebDriverWait wait;
	
	
	By myAccountButton = By.xpath("//*[@title='My Account']");
	By registerButton = By.xpath("//*[text()='Register']");
	By loginButton = By.xpath("//*[text()='Login']");
	
	//Register Page Locators
	By firstNameField = By.id("input-firstname");
	By lastNameField = By.id("input-lastname");
	By emailField = By.id("input-email");
	By telephoneField = By.id("input-telephone");
	By passwordField = By.id("input-password");
	By confirmPasswordField = By.id("input-confirm");
	By privacyPolicyCheckbox = By.xpath("//*[@type='checkbox']");
	By continueButton = By.xpath("//*[@value='Continue']");
	
	//Login Page Locators same fields so we can use them
	By forogtPasswordButton = By.xpath("//input[@id='input-password']/following-sibling::a"); 
	By loginBtn = By.xpath("//*[@value='Login']");
	
	//HomePage Locators
	By searchBoxField = By.xpath("//div[@id='search']/input");
	By searchButton = By.xpath("//button[@class=\"btn btn-default btn-lg\"]");
	By accountInfoButton = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='My Account']");
	By orderHistoryButton = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='Order History']");
	By logoutButton = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='Logout']");
	By wishlistButton = By.xpath("//*[starts-with(text(), 'Wish')]/parent::a[@id='wishlist-total']");
	By shoppingCartButton = By.xpath("//*[text()='Shopping Cart']");
	By checkoutButton = By.xpath("//span[text()='Checkout']");
	By cartButton = By.xpath("//*[@id='cart-total']");
	By removeButton = By.xpath("//button[@title='Remove']");
	By homeIcon = By.xpath("//*[text()='Qafox.com']");
	
	//Search and Product Page Locators
	By imgButton = By.xpath("//img[(@alt='MacBook')and(@title='MacBook')]");
	By productAddToWishlistButton = By.xpath("//*[@data-original-title='Add to Wish List']");
	By productAddToCompareButton = By.xpath("//*[@data-original-title='Compare this Product']");
	By productQuantityButton = By.id("input-quantity");
	By productAddToCartButton = By.xpath("//*[text()='Add to Cart']");
	By sortButton = By.id("input-sort");
	
	//Cart Page Locators 
	By quantityUpdateField = By.xpath("//div[@class='input-group btn-block']/input");
	By quanityUpdateButton = By.xpath("//*[@data-original-title='Update']");
	By productRemoveButtom = By.xpath("//*[@data-original-title='Remove']");
	By productCheckoutButton = By.xpath("//a[text()='Checkout']");
	By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']");
	
	//My Account Page Locators
	By modifyAddress = By.xpath("//*[text()='Modify your address book entries']");
	By changePassword = By.xpath("//*[text()='Change your password']");
	By updateAccountInfo = By.xpath("//*[text()='Edit your account information']");
	
	// Add Address Page Locators
	By addAddressButton = By.xpath("//*[text()='New Address']");
	By addressField = By.id("input-address-1");
	By cityField = By.id("input-city");
	By postCodeField = By.id("input-postcode");
	By countrySelect = By.id("input-country");
	By stateSelect = By.id("input-zone");
	By deleteAddress = By.xpath("//*[text()='Delete']");
	
	String path = System.getProperty("user.dir") + "/src/test/resources/testData/excelData.xlsx";
	Map<String, String> loginData = ExcelReader.readKeyValueData(path, "loginData");
	String email = loginData.get("email");
	String pass = loginData.get("password");
	Map<String, String> searchData = ExcelReader.readKeyValueData(path, "expectedData");
	
	public OpenCartPOM(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void register(Map<String, String> registerData) {
		driver.findElement(myAccountButton).click();
		driver.findElement(registerButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(registerData.get("firstname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(registerData.get("lastname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(registerData.get("email"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(telephoneField)).sendKeys(registerData.get("phone"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(registerData.get("password"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(registerData.get("confirmpassword"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyCheckbox)).click();
		driver.findElement(continueButton).click();
		home();
		
	}
	public void login(String username, String password) {
		driver.findElement(myAccountButton).click();
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
		driver.findElement(loginBtn).click();
		home();
	}
	
	public void search(String product) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxField)).sendKeys(product);
		driver.findElement(searchButton).click();
	}
	
	public void addToCart() {
		login(email, pass);
		search(searchData.get("searchvalue"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityButton)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityButton)).sendKeys(searchData.get("quantity"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productAddToCartButton)).click();
	}
	
	public void removeFromCart() {
		login(email, pass);
		wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(productRemoveButtom)).click();
	}
	
	public void wishlist() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistButton)).click();
	}
	
	public void checkout() {
		addToCart();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(productCheckoutButton)).click();
	}
	
	public void addAddress(Map<String, String> expectedData) {
		login(email, pass);
		driver.findElement(myAccountButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(modifyAddress)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addAddressButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(expectedData.get("firstname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(expectedData.get("lastname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(expectedData.get("address"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(expectedData.get("city"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(postCodeField)).sendKeys(expectedData.get("postalcode"));
		WebElement country = driver.findElement(countrySelect);
		Select sel = new Select(country);
		sel.selectByVisibleText(expectedData.get("country"));
		WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(stateSelect));
		Select sel1 = new Select(state);
		sel1.selectByVisibleText(expectedData.get("state"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
	}
	
	
	
	public void changePassword(Map<String, String> expectedData) {
		login(email, pass);
		driver.findElement(myAccountButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(changePassword)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(expectedData.get("password"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(expectedData.get("confirmpass"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
	}
	
	
	public void sortBy() {
		search(searchData.get("product"));
		WebElement sort = driver.findElement(sortButton);
		Select sel = new Select(sort);
		sel.selectByVisibleText("Price (Low > High)");
	}
	
	
	public void logout() {
		login(email, pass);
		home();
		driver.findElement(myAccountButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
	}
	
	public void home() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(homeIcon)).click();
	}
	
	
}
