package pageObjects;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage {
	public SettingPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id ="android:id/checkbox")
	public WebElement wifiCheckbox;
	
	@AndroidFindBy(xpath ="(//android.widget.RelativeLayout)[2]")
	public WebElement wifiSettings;

	@AndroidFindBy(className="android.widget.EditText")
	public WebElement wifiSettingsEditBox;
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> buttons;

}
