package pages;

import commons.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by jyothijain on 16/08/18.
 */
public class HotelBooking extends BaseSetup {

   /* private HotelBookingObjects hotelBookingObjects;

    public HotelBooking() {
        hotelBookingObjects = new HotelBookingObjects();
        PageFactory.initElements(driver, hotelBookingObjects);
    }

    /*public void hotelsearch() {

        hotelBookingObjects.hotelLink.click();

        hotelBookingObjects.localityTextBox.sendKeys("Indiranagar, Bangalore");
        waitFor(5000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        Select oSelect = new Select(driver.findElement(By.id("travellersOnhome")));

        oSelect.selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }


    private class HotelBookingObjects {

        @FindBy(linkText = "Hotels")
        private WebElement hotelLink;

        @FindBy(id = "Tags")
        private WebElement localityTextBox;

        @FindBy(id = "SearchHotelsButton")
        private WebElement searchButton;

        @FindBy(id = "travellersOnhome")
        private WebElement travellerSelection;

    }*/
}

