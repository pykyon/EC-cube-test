import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverTest;

/**
 * このプログラムはハンズオンに必要なプログラムが適切にインストールされたかをチェックするプログラムです。
 * このファイルをInteillJ IDEA上から、右クリック>'Run EnvironmentCheckTest' によりJUnitとして実行し、
 * JUnitのテストが成功すれば、インストールは正常に完了しています。
 */
public class EnvironmentCheckTest extends ChromeDriverTest {
    @Test
    public void checkThatInstalledSuccessfully() {
        File html = new File("introWork/introWork1.html");
        String url = html.toURI().toString();
        driver.get(url);        
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("TestUser");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("pass");
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        driver.switchTo().alert().accept();
    }
}
