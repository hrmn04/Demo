package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test
	void test_account_Registration() {
		
		logger.info(" ***  Starting TC_001_AccountRegisterationTest   *** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcct();
		hp.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setTelephone(randomeNumber());
		regPage.setPassword("test123");
		regPage.setConfirmPassword("test123");
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	

}
