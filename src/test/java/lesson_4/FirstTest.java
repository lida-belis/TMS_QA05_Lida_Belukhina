package lesson_4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "D:\\TestSelenium\\src\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://onliner.by");

        driver.quit();
    }
}
