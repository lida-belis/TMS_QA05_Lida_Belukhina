package lesson_5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_4 extends BaseTest {

    private String URL = "https://healthunify.com/bmicalculator/";

    @Test
    private void test1() {
        String weightValue = "70";
        String massUnit = "pounds";
        String heightValue_1 = "5";
        String heightValue_2 = "6";

        String expectedSIUnits = "11.27";
        String expectedUSUnits = "11.46";
        String expectedUKUnits = "71.58";
        String expectedStatus = "Your category is Normal";

// 1) Открыть сайт https://healthunify.com/bmicalculator/
        driver.get(URL);

// 2) Ввести Weight 70 pounds
        WebElement dropDown = driver.findElement(By.name("opt1"));
        Select sDropDown = new Select(dropDown);
        sDropDown.selectByVisibleText(massUnit);
        WebElement weight = driver.findElement(By.name("wg"));
        weight.clear();
        weight.sendKeys(weightValue);

// 3) Ввести Height 5’ 6’’
        WebElement height_1 = driver.findElement(By.name("opt2"));
        Select sHeight_1 = new Select(height_1);
        sHeight_1.selectByValue(heightValue_1);

        WebElement height_2 = driver.findElement(By.name("opt3"));
        Select sHeight_2 = new Select(height_2);
        sHeight_2.selectByValue(heightValue_2);

// 4) Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

// 5) Проверить значение в поле 'SI Units’ 11.27
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), expectedSIUnits);

// 6) Проверить значение в поле 'US Units’ 11.46
        WebElement usUnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUnits.getAttribute("value"), expectedUSUnits);

// 7) Проверить значение в поле ’UK Units’ 71.58
        WebElement ukUnits = driver.findElement(By.name("uk"));
        Assert.assertEquals(ukUnits.getAttribute("value"), expectedUKUnits);

// 8) Проверить статус 'Your category is Normal'
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), expectedStatus);
    }
}
