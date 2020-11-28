package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;
import pageObjects.SettingPage;


public class ApiDemoTest extends base{
	
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		CmdkillAllNodes();
	}
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException {
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h = new HomePage(driver);
		Preferences p = new Preferences(driver);
		SettingPage s = new SettingPage(driver); 
		h.Preferences.click();
		p.dependencies.click();
		s.wifiCheckbox.click();
		s.wifiSettings.click();
		s.wifiSettingsEditBox.sendKeys(input);
		s.buttons.get(1).click();
	
		service.stop();
	}

}