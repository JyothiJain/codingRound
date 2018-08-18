package pages;

import commons.BaseSetup;
import commons.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class FlightBaseSetupTest extends BaseSetup {

    @BeforeMethod
    public void setup() {
        setDriverPath();
        intialize();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
    }


    @Test
    public void testThatResultsAppearForAOneWayJourney() throws FileNotFoundException {
        DataProvider dataProvider = new DataProvider();
        String location = dataProvider.readData("flightBooking.csv");
        String journeylocation[] = location.split(",");
        FlightBooking flightBooking = new FlightBooking();
        flightBooking.forAOneWayJourney(journeylocation[0], journeylocation[1]);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
        //close the browser
        driver.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
