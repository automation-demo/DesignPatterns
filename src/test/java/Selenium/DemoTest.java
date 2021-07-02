package Selenium;

import Selenium.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends Selenium.BaseTest {

    WebDriver driver;
    TravelHomePage th;

    @BeforeTest
    public  void setUp()
    {
        driver = initializeDriver();
        th = new TravelHomePage(driver);
    }
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails) throws InterruptedException {

        th.goTo();
        th.getFooterNav().getFlightAttribute();
        th.getNavigationBar().getFlightAttribute();
        th.getFooterNav().getLinkCount();

        //th.setBookingStrategy(new RoundTrip(driver,sectionElement));
        //th.setBookingStrategy(new MultiTrip(driver,sectionElement));
        th.setBookingStrategy("multitrip");

        th.checkAvail(reservationDetails);
	System.out.println("Hello World");
    }

    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
    @DataProvider
    public  Object[][] getData() throws IOException {
        /*HashMap<String, String> reservationDetails = new HashMap<String, String>();
        reservationDetails.put("origin1","MAA");
        reservationDetails.put("destination","HYD");
        reservationDetails.put("origin2","DEL");

        HashMap<String, String> reservationDetails1 = new HashMap<String, String>();
        reservationDetails1.put("origin1","BLR");
        reservationDetails1.put("destination","DEL");
        reservationDetails1.put("origin2","MAA");

        List<HashMap<String, String>> l = new ArrayList();
        l.add(reservationDetails);
        l.add(reservationDetails1);


        return new Object[][]
                {
                    //{reservationDetails}, {reservationDetails1}
                        {l.get(0)}, {l.get(1)}
                };*/
        List<HashMap<String,String>> l = getJsonData("C:\\Users\\APOORV\\IdeaProjects\\DemoDesignPatterns\\src\\main\\java\\Selenium\\DataLoads\\reservationDetails.json");
        return new Object[][]
                {
                        //{reservationDetails}, {reservationDetails1}
                        {l.get(0)}, {l.get(1)}
                };
    }
}
