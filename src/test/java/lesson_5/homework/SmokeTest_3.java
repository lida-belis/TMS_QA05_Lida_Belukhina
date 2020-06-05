package lesson_5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_3 extends BaseTest{

    private String URL = "https://healthunify.com/bmicalculator/";

    @Test
    public void TestBMICalculator() {
        String weightValue = "40";
        String heightValue = "158";

        String expectedSIUnits = "16.02";
        String expectedUSUnits = "16.29";
        String expectedUKUnits = "101.73";
        String expectedStatus = "Your category is Underweight";

//    1. Открыть сайт https://healthunify.com/bmicalculator/
        driver.get(URL);

//    2. Ввести Weight 40 kg
        WebElement weight = driver.findElement(By.name("wg"));
        weight.sendKeys(weightValue);

//    3. Ввести Height 158 cm
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys(heightValue);

//    4. Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

//    5. Проверить значение в поле 'SI Units’ 16.02
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), expectedSIUnits);

//    6. Проверить значение в поле 'US Units’ 16.29
        WebElement usUnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUnits.getAttribute("value"), expectedUSUnits);

//    7. Проверить значение в поле ’UK Units’ 101.73
        WebElement ukUnits = driver.findElement(By.name("uk"));
        Assert.assertEquals(ukUnits.getAttribute("value"), expectedUKUnits);

//    8. Проверить статус c "Your category is Underweight"
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), expectedStatus);
    }
}
