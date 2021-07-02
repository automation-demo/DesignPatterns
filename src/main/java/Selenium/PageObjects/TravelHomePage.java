package Selenium.PageObjects;

import Selenium.AbstractComponents.CheckFlightAvailability;
import Selenium.AbstractComponents.StrategyFactory;
import Selenium.PageComponents.FooterNav;
import Selenium.PageComponents.NavigationBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    By sectionElement = By.id("traveller-home");
    By navBarElement = By.id("buttons");
    WebDriver driver;
    CheckFlightAvailability cfa;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver, navBarElement);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType)
    {
        StrategyFactory sf = new StrategyFactory(driver);
        cfa = sf.createStrategy(strategyType);
        //this.cfa=cfa;
    }
    public void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException {
        cfa.chekAvail(reservationDetails);
    }
    public void getTitle()
    {
        System.out.println(driver.getTitle());
    }
}
