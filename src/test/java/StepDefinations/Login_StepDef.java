package StepDefinations;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.Features.TestRunner;

public class Login_StepDef extends TestRunner {

    private Assertion hardAssert = new Assertion();
    private SoftAssert softAssert = new SoftAssert();

    Logger logger = Logger.getLogger(Login_StepDef.class);

    @When("^I enter username as \"([^\"]*)\"$")
    public void ienterusernameas(String username) throws InterruptedException, MalformedURLException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(
                By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"] | (//*[@label=\"Username\"])[1]"))
                .sendKeys(username);

    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void ienterpasswordas(String password) {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(
                By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"] | (//*[@label=\"Password\"])[1]"))
                .sendKeys(password);

        logger.info("Successfully enter password!");

    }

    @When("^I login$")
    public void ilogin() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@text='LOGIN'] | (//*[@label='LOGIN'])[1]")).click();

        logger.info("Successfully click Login button!");

    }

//    @Then("^I should see Products page with title \"([^\"]*)\"$")
//    public void iShouldSeeProductsPageWithTitle(String title) throws InterruptedException {
//        
//                String products = driver.findElement(By.xpath("//*[@text='PRODUCTS']")).getText();
//
//                softAssert.assertEquals(title, products);
//                softAssert.assertAll();
//            
//        
//    }
    @When("select the product")
    public void select_the_product() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]")).click();
        logger.info("Successfully select the product");

    }

    @Then("go to cart")
    public void gotocart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"))
                .click();
        //android.view.ViewGroup[@content-desc="test-Cart"]/android.view.ViewGroup/android.widget.ImageView
        logger.info("Successfully go to cart!");

    }

    @When("I will remove the product")
    public void i_remove_product() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")).click();

        logger.info("Successfully remove item from the cart");

    }
    
    @When("^checkout the cart$")
    public void checkoutthecart() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")).click();

        logger.info("Successfully clicked on checkout!");

    }

    @When("^I enter user  firstname as \"([^\"]*)\"$")
    public void Ienteruserfirstnameas(String FirstName) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]"))
                .sendKeys(FirstName);

        logger.info("Successfully entererd firstname!");

    }

    @When("^I enter user  lastname as \"([^\"]*)\"$")
    public void Ienteruserlastnameas(String LastName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]")).sendKeys(LastName);

        logger.info("Successfully entered lastname!");

    }

    @When("^I enter my zone pincode as \"([^\"]*)\"$")
    public void Ientermyzonepincodeas(String PostalCode) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]"))
                .sendKeys(PostalCode);

        logger.info("Successfully entererd postal code!");

    }

    @When("^I click on the continue$")
    public void Iclickonthecontinue() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")).click();

        logger.info("Successfully clicked on continue!");

    }

//    @Then("^I should be able to select finish$")
//    public void i_should_be_able_to_select_finish() throws InterruptedException {
//
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")).click();
//
//        logger.info("Successfully clicked on finish!"); 
//        }

    @When("Scroll the products")
    public void scroll_the_products() throws Exception {
        try {
          // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

            Thread.sleep(3000);

            TouchAction<?> touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(611, 1611));
            touchAction.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
            touchAction.moveTo(PointOption.point(773, 473));
            touchAction.release().perform();

        } catch (Exception e) {
            logger.error("Product list is Not Scroll.");

            throw (e);

        }
    }
        @Then("I click on the Finish button")
        public void iclickonthefinishbutton() throws Exception {
            try {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")).click();
                logger.info("Successfully Click the Finesh Button");
            } catch (Exception e) {

                logger.error("Finesh Button element not found.");

                throw (e);
            }
        }
            

    }

