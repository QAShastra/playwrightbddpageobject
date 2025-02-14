package drivermanager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverManager {
    Page page = null;
   //threadLocal object for driver
    public static ThreadLocal<Page> myPage= new ThreadLocal<>();
    public  Page launchBrowser(String browser) {
        if (browser.equals("Chrome")) {
            try (Playwright playwright = Playwright.create()) {
                Browser br = playwright.chromium().launch();
                BrowserContext context = br.newContext();

                myPage.set(context.newPage());
                }
        } else if (browser.equals("Firefox")) {
            try (Playwright playwright = Playwright.create()) {
                Browser br = playwright.firefox().launch();
                BrowserContext context = br.newContext();
                myPage.set(context.newPage());
            }
        }

        //getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized Page getDriver() {
        return myPage.get();
    }

}