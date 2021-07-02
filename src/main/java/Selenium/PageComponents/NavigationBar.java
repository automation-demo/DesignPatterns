package Selenium.PageComponents;

import Selenium.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By searchFlight = By.cssSelector("[title='Flights']");

    public NavigationBar(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }


    public void getFlightAttribute()
    {
        System.out.println(findElement(searchFlight).getAttribute("class"));
    }
}
