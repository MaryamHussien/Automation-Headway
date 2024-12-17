package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, String headless, boolean maximize){
        if(headless.equalsIgnoreCase("headless")){
            if (browserName.equalsIgnoreCase("chrome")){
                System.out.println("Initializing chrome driver" + System.getProperty("os.name"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                //chromeOptions.addArguments("--no-sandbox");
                //chromeOptions.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
            }
            else if(browserName.equalsIgnoreCase("edge")){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                System.out.println("Initializing edge driver" + System.getProperty("os.name"));
                driver = new EdgeDriver(edgeOptions);
            }
        }
        else{
            if (browserName.equalsIgnoreCase("chrome")){
                System.out.println("Initializing chrome driver" + System.getProperty("os.name"));
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("edge")){
                System.out.println("Initializing edge driver" + System.getProperty("os.name"));
                driver = new EdgeDriver();
            }
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if(maximize){
            System.out.println("Maximizing Window, The window size is: "+ driver.manage().window().getSize());
            driver.manage().window().maximize();
        }
        return driver;
    }
}
