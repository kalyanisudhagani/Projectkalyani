package producttest;


	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import genericlibrary.BaseConfig;
	import pagerepository.CartPage;
	import pagerepository.CheckoutOverviewPage;
	import pagerepository.CheckoutPage;
	import pagerepository.HomePage;

	 @Listeners(listenerlibrary. ListenerImplementation.class)

	 public class Example1Test  extends BaseConfig {
		
		@Test(dataProvider="Details")
		
		public void orderProducts(String FirstName,String LastName, String Zipcode) {

			// Wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
            //.Verify The Page
			Assert.assertEquals(driver.getTitle(), "Swag Labs");
			Reporter.log(" Page Is verified successfully", true);
			

			// Create an object for Home page
			HomePage hpobj = new HomePage(driver);
			
			
			// Use the webElement from POM class

			// Click on the first product
			hpobj.getfirstproduct().click();
		
			
			//Verify The Product Is Added 
			Assert.assertTrue(hpobj.getaddtocartbtn().isDisplayed());
			Reporter.log("Verifed The  1st Product Added successfully", true);
			
			// Click on Add To Cart button
			hpobj.getaddtocartbtn().click();
			
			
			// Click on Back To Products
			hpobj.getbacktoproducts().click();
			
			//.Verify The Page
			Assert.assertEquals(driver.getTitle(), "Swag Labs");
			Reporter.log(" Title Verified successfully", true);


			// Click on the Third product
			hpobj.getthirdproduct().click();
			
			//Verify The Product Is Added 
			Assert.assertTrue(hpobj.getaddtocartbtn1().isDisplayed());
			Reporter.log("Verifed The 3rd Product Added successfully", true);
				
			// Click on Add To Cart button
			hpobj.getaddtocartbtn1().click();
			
		
			// Click on Back To Products
			hpobj.getbacktoproducts().click();
			
			//.Verify The Page
			Assert.assertEquals(driver.getTitle(), "Swag Labs");
			Reporter.log(" Title Verified successfully", true);



			// Click on the Second product
			hpobj.getsecondproduct().click();
			
			//Verify The Product Is Added 
			Assert.assertTrue(hpobj.getaddtocartbtn2().isDisplayed());
			
			
			Reporter.log("Verifed second The Product Added successfully", true);
			
			// Click on Add To Cart button
			hpobj.getaddtocartbtn2().click();
			
		
			// Click on Back To Products
			hpobj.getbacktoproducts().click();
			//.Verify The Page
			Assert.assertEquals(driver.getTitle(), "Swag Labs");
	
			Reporter.log(" Title Verified successfully", true);



			// Click on Cart Icon
			hpobj.getcarticon().click();

			// Create an object for Cart page
			CartPage cpobj = new CartPage(driver);

			// Use the webElement from POM class

			// Click on the CheckOut button
			cpobj.getcheckoutbtn().click();

			// Create an object for CheckOut page
			CheckoutPage chkobj = new CheckoutPage(driver);
			
			// verify the Checkout the page
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
			Reporter.log("CheckoutPage Is Verified successfully", true);


			// Enter the First Name
			chkobj.getfirstname().sendKeys(FirstName);
			// Enter Last Name
			chkobj.getlastname().sendKeys(LastName);
			// Enter ZipCode
			chkobj.getzipcode().sendKeys(Zipcode);
			// Click on Continue button
			chkobj.continuebtn().click();
			Reporter.log("Clicked Continue Button successfully", true);

			
			// verify the Checkout the page
		//	Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

			// Create an object for CheckOut-Overview page
			CheckoutOverviewPage ckovobj = new CheckoutOverviewPage(driver);
			
			

			// Click on Finish button
			ckovobj.getfinishbtn().click();
			
			Assert.assertEquals(ckovobj.getfinishbtn(),true);
			
			Reporter.log("Clicked Finish Button successfully", true);
			
			
			
			//Assert.fail();
			
		
		}
		 

		
		

	}


