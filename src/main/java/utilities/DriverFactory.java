package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize){
        if (browserName.equalsIgnoreCase("chrome")){
            System.out.println("Initializing chrome driver" + System.getProperty("os.name"));
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            System.out.println("Initializing edge driver" + System.getProperty("os.name"));
            driver = new EdgeDriver();
        }
        if(maximize){
            System.out.println("Maximizing Window, The window size is: "+ driver.manage().window().getSize());
            driver.manage().window().maximize();
        }
        return driver;
    }
}
