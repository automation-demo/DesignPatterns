package Selenium.PageComponents;

import Selenium.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    By searchFlight = By.cssSelector("[title='Flights']");
    By linkCount = By.tagName("a");
    public FooterNav(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }


    public void getFlightAttribute()
    {
        System.out.println(findElement(searchFlight).getAttribute("class"));
    }
    public void getLinkCount()
    {
        System.out.println(findElements(linkCount).size());
    }
}