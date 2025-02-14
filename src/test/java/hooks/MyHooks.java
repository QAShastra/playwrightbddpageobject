package hooks;

import com.microsoft.playwright.Page;
import drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class MyHooks {
    DriverManager driverManager =null;
    Page page = null;
    @Before
    public void setup() {
        System.out.println("This is setup method");
        driverManager = new DriverManager();
        page =driverManager.launchBrowser("Chrome");
    }

    @After
    public void tearDown() {
        System.out.println("This is tearDown method");
        page.close();
    }
}
