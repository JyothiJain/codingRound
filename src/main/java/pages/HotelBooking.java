package pages;

import commons.BaseSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by jyothijain on 16/08/18.
 */
public class HotelBooking extends BaseSetup {

    private HotelBookingObjects hotelBookingObjects;

    public HotelBooking() {
        hotelBookingObjects = new HotelBookingObjects();
        PageFactory.initElements(driver, hotelBookingObjects);
    }

    public boolean hotelsearch(String locality) {

        hotelBookingObjects.hotelLink.click();
        hotelBookingObjects.localityTextBox.sendKeys(locality);
        waitFor(5000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(1).click();
        hotelBookingObjects.checkInDate.click();
        driver.findElement(By.id("CheckInDate")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[6]/a")).click();
        waitFor(2000);
        driver.findElement(By.id("CheckOutDate")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[5]/a")).click();
        String actualDays = driver.findElement(By.xpath(".//*[@id='HotelDuration']")).getText();
        String expectedDays = "6 nights";
        Assert.assertEquals(expectedDays, actualDays);
        Select dropdown= new Select(hotelBookingObjects.travellerSelection);
        dropdown.selectByIndex(0);
        hotelBookingObjects.searchHotelButton.click();
        return true;
    }


    private class HotelBookingObjects {

        @FindBy(linkText = "Hotels")
        private WebElement hotelLink;

        @FindBy(id = "Tags")
        private WebElement localityTextBox;


        @FindBy(id = "SearchHotelsButton")
        private WebElement searchButton;

        @FindBy(id = "CheckInDate")
        private WebElement checkInDate;

        @FindBy(id = "CheckOutDate")
        private WebElement checkOutDate;

        @FindBy(id = "travellersOnhome")
        private WebElement travellerSelection;

        @FindBy(id = "SearchHotelsButton")
        private WebElement searchHotelButton;


    }
}

