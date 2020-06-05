package lesson_5;

import lesson_5.homework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_2 extends BaseTest {

    private String URL = "https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф";

    @Test
    private void test1() {
        String sex = "женский";
        String creatinineValue = "80";
        String ageValue = "38";
        String weightValue = "55";
        String heightValue = "163";

        String expectedMDRD = "MDRD: 74 (мл/мин/1,73кв.м)";
        String expectedMDRD1 = "ХБП: 2 стадия (при наличии почечного повреждения)";
        String expectedCG = "Cockroft-Gault: 70 (мл/мин)";
        String expectedBSA = "Поверхность тела:1.58 (кв.м)";

//        Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф
        driver.get(URL);

//        Выбрать женский пол из выпадающего списка
        WebElement dropDown = driver.findElement(By.id("oSex"));
        Select sDropDown = new Select(dropDown);
        sDropDown.selectByVisibleText(sex);

//        Ввеcти Креатенин = 80
        WebElement creatinine = driver.findElement(By.id("oCr"));
        creatinine.sendKeys(creatinineValue);

//        Ввести Возраст = 38 годам
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys(ageValue);

//        Ввести Вес = 55 кг
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys(weightValue);

//        Ввести Рост = 163 см
        WebElement height = driver.findElement((By.id("oHeight")));
        height.sendKeys(heightValue);

//        Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[value='Рассчитать']\n"));
        calculate.click();

//        Проверить результаты: ‘MDRD: 74 (мл/мин/1,73кв.м)’
        WebElement mdrd = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(mdrd.getText(), expectedMDRD);

//        Проверить результаты: ‘ХБП: 2 стадия (при наличии почечного повреждения)’
        WebElement xbp = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(xbp.getText(), expectedMDRD1);

//        Проверить результаты: ‘Cockroft-Gault: 70 (мл/мин)’
        WebElement cockroftGault = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(cockroftGault.getText(), expectedCG);

//        Проверить результаты: ‘Поверхность тела:1.58 (кв.м)’
        WebElement bodySurface = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(bodySurface.getText(), expectedBSA);
    }
}
