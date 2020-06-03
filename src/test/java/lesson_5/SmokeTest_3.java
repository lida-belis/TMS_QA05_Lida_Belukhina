package lesson_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmokeTest_3 {

    @Test
    public void TestBMICalculator() {
//    1. Открыть сайт https://healthunify.com/bmicalculator/
        System.setProperty("webdriver.chrome.driver", "D:\\TestSelenium\\src\\driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

//    2. Ввести Weight 40 kg
        WebElement weight = driver.findElement(By.name("wg"));
        weight.sendKeys("40");

//    3. Ввести Height 158 cm
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("158");

//    4. Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

//    5. Проверить значение в поле 'SI Units’ 16.02
        WebElement siUnits = driver.findElement(By.name("si"));
        String siUnitsValue = siUnits.getAttribute("value");
        if (!siUnitsValue.equals("16.02")) {
            System.out.println("The value in the field 'SI Units' is " + siUnitsValue + " not equal to 16.02");
        }

//    6. Проверить значение в поле 'US Units’ 16.29
        WebElement usUnits = driver.findElement(By.name("us"));
        String usUnitsValue = usUnits.getAttribute("value");
        if (!usUnitsValue.equals("16.29")) {
            System.out.println("The value in the field 'US Units’ is " + usUnitsValue + " not equal to 16.29");
        }

//    7. Проверить значение в поле ’UK Units’ 101.73
        WebElement ukUnits = driver.findElement(By.name("uk"));
        String ukUnitsValue = ukUnits.getAttribute("value");
        if (!ukUnitsValue.equals("101.73")) {
            System.out.println("The value in the field 'UK Units’ is " + ukUnitsValue + " not equal to 101.73");
        }

//    8. Проверить статус c "Your category is Underweight"
        WebElement status = driver.findElement(By.name("desc"));
        String statusValue = status.getAttribute("value");
        if (!statusValue.equals("Your category is Underweight")) {
            System.out.println("The value in the field is " + siUnitsValue + " not equal to the status 'Your category is Underweight'");
        }

//    9. Закрыть окно браузера
        driver.quit();
    }
}
