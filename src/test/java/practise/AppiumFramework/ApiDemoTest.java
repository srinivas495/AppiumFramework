package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;


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
		
		h.Preferences.click();
		p.dependencies.click();
		driver.findElementById("android:id/checkbox").click();
	    driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	    driver.findElementByClassName("android.widget.EditText").sendKeys(input);     
		p.buttons.get(1).click();
		
		service.stop();
	}

}
