package Selenium.PageComponents;

import Selenium.AbstractComponents.AbstractComponent;
import Selenium.AbstractComponents.CheckFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements CheckFlightAvailability {


    private By multiTripRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By multiTripPopup = By.id("MultiCityModelAlert");
    private By fromLoc = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By fromLoc2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void chekAvail(HashMap<String,String> reservationDetails) throws InterruptedException {

        makeStateReady(s->selectOriginCity1(reservationDetails.get("origin")));
        //selectOriginCity1(origin);
        Thread.sleep(3000);
        selectDestinationCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("origin2"));
        findElement(searchButton).click();
    }

    public void selectOriginCity1(String origin) {
        findElement(fromLoc).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }
    public void selectOriginCity2(String origin) {
        findElement(fromLoc2).click();
        findElement(By.xpath("(//a[@value='" + origin + "'])[3]")).click();
    }
    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("I am inside MultiTrip");
        findElement(multiTripRadio).click();
        //Thread.sleep(3000);
        findElement(multiTripPopup).click();
        waitForElementToDisappear(multiTripPopup);
        consumer.accept(this);
        System.out.println("I am done");
    }
}