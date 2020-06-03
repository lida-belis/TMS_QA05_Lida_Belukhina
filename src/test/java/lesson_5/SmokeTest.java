package lesson_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void Test1() {
//        1.Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт

        System.setProperty("webdriver.chrome.driver", "D:\\TestSelenium\\src\\driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт");

//        Ввести Рост = 183 см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("183");

//        Ввести Вес = 58 кг
        WebElement weight = driver.findElement(By.name("mass"));
        weight.sendKeys("58");

//        Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

//        Проверить, что значение в поле ‘ИМТ’ равно 17.32
        WebElement imt = driver.findElement(By.name("result"));
        String imtValue = imt.getAttribute("value");
        if (!imtValue.equals("17.32")) {
            System.out.println("The value in the field 'IMT' is " + imtValue +" not equal to 17.32");
        }

//        Проверить, что статус равен ’Пониженный вес’
        WebElement status = driver.findElement(By.id("resline"));
        String statusValue = status.getText();
        if (!statusValue.equals("Пониженный вес")) {
            System.out.println("The value in the field is " +statusValue + " not equal to ’Пониженный вес’");
        }


//        Закрыть окно браузера
        driver.quit();
    }
}