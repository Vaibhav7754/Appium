package resource.Features;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/resource/Features",
		glue = {"StepDefinations" }, 
		dryRun = false, 
		tags = "@test3", 
		monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

	public static AppiumDriver<?> driver;

	@BeforeMethod
	public static void Setup() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("VERSION", "9");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		caps.setCapability("autoGrantPermission", true);
		caps.setCapability("noReset", true);
		//caps.setCapability("app", "C:\\Users\\selvaprabhus\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.2.1.apk");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
