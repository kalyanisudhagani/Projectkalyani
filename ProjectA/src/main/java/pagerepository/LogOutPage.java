package pagerepository;


	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LogOutPage {

		// 1. WebElement Identification and Declaration

		@FindBy(id = "react-burger-menu-btn")
		private WebElement menubar;

		@FindBy(id = "logout_sidebar_link" )
		private WebElement logout;

		// 2 .WebElement Initialization

		public LogOutPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

		// 3. WebElement Utilization

		public WebElement getmenubar() {
			return menubar;
		}

		public WebElement getlogout() {
			return logout;
		}



}
//"logout_sidebar_link"