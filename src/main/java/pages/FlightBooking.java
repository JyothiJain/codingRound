package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by jyothijain on 16/08/18.
 */
public class FlightBooking extends Login {

    private FlightBookingObjects flightBookingObjects;

    public FlightBooking() {
        flightBookingObjects = new FlightBookingObjects();
        PageFactory.initElements(driver, flightBookingObjects);
    }


    /*LoginMethod*/
    public boolean forAOneWayJourney(String fromLocation, String toLocation) {
        flightBookingObjects.oneWay.click();
        flightBookingObjects.fromLocation.click();
        flightBookingObjects.fromLocation.sendKeys(fromLocation);
        waitFor(5000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        flightBookingObjects.toLocation.click();
        flightBookingObjects.toLocation.sendKeys(toLocation);
        waitFor(5000);
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
        flightBookingObjects.searchBtn.click();
        waitFor(5000);
        return true;
    }

    private class FlightBookingObjects {

        @CacheLookup
        @FindBy(id = "OneWay")
        private WebElement oneWay;

        @CacheLookup
        @FindBy(id = "FromTag")
        private WebElement fromLocation;

        @CacheLookup
        @FindBy(id = "ToTag")
        private WebElement toLocation;

        @CacheLookup
        @FindBy(id = "SearchBtn")
        private WebElement searchBtn;


    }
}
