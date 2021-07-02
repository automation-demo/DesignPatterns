package Selenium.AbstractComponents;


import Selenium.PageComponents.MultiTrip;
import Selenium.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {
    By sectionElement = By.id("flightSearchContainer");
    WebDriver driver;

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public CheckFlightAvailability createStrategy(String strategyType)
    {
        if(strategyType.equalsIgnoreCase("multitrip"))
        {
            return new MultiTrip(driver, sectionElement);
        }
        if(strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
