package seleniumTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    final String URL = "https://duckduckgo.com//";

    @Test
    public void testSearchGoogle(){
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();

        driver.quit();
    }
}
