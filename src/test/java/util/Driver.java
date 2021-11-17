package util;

import java.util.concurrent.TimeUnit;

import hitoriaDeUsuario.page.AutomationPracticeHomePage;
import hitoriaDeUsuario.page.CreateAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {

    public static WebDriver driver;
    public static AutomationPracticeHomePage automationPracticeHomePage;
    public static CreateAccountPage createAccountPage;


    public WebDriver getDriver() {
        try {

            if (null == driver) {
                String ruta = System.getProperty("user.dir") + "/src/main/resources/chromedriver";
                System.setProperty("webdriver.chrome.driver", ruta);
                // CHROME OPTIONS
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

        } catch (Exception e){
            System.out.println("Unable to load browser: " + e.getMessage());
        } finally {
            driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
            automationPracticeHomePage= PageFactory.initElements(driver, AutomationPracticeHomePage.class);
            createAccountPage= PageFactory.initElements(driver,CreateAccountPage.class);
        }
        return driver;
    }

}
