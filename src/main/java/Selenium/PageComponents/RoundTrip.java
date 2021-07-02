package Selenium.PageComponents;

import Selenium.AbstractComponents.AbstractComponent;
import Selenium.AbstractComponents.CheckFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements CheckFlightAvailability {

    By roundTripRadio = By.id("ctl00_mainContent_rbtnl_Trip_1");
    By fromLoc = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }


    @Override
    public void chekAvail(HashMap<String,String> reservationDetails)
    {
        System.out.println("I am inside Round Trip");
        findElement(roundTripRadio).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(searchButton).click();
    }
    public void selectOriginCity(String origin)
    {
        findElement(fromLoc).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
