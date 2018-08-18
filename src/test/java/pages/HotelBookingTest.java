package pages;

import commons.BaseSetup;
import commons.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class HotelBookingTest extends BaseSetup {


    @BeforeMethod
    public void setup() {
        setDriverPath();
        intialize();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() throws FileNotFoundException {
        DataProvider dataProvider = new DataProvider();
        String locality = dataProvider.readData("hotelBooking.csv");
        HotelBooking hotelBooking = new HotelBooking();
        hotelBooking.hotelsearch(locality);


    }

}
