import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("dropdown-label")).click();       //Login
        driver.findElement(By.cssSelector(".login-form__link")).click();  //member registration

        driver.findElement(By.cssSelector("#RegisterFormView_RegisterEmail")).sendKeys("yanlismail@mail.com"); //invalid mail
        driver.findElement(By.cssSelector("#RegisterFormView_Password")).sendKeys("1234");                     //invalid password
        driver.findElement(By.cssSelector(".button.bc-blue.register-button-link.submit-button")).click();

        String text = driver.findElement (By.cssSelector("#RegisterFormView_Password-error")).getText();
        System.out.println(text);      //error message


    }
}
