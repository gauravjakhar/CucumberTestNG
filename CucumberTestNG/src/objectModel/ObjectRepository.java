package objectModel;

import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;
import utility.Drivers;

public class ObjectRepository extends Drivers{

	public static class Home_Page{
		public static WebElement likebutton() {return driver.findElement(By.xpath("//div[@class='test']"));}
		public static List<WebElement> share() {return driver.findElements(By.id("share-12345"));}
		public static WebElement logout() {return driver.findElement(By.id("Logout"));}
	}

	public static class Login_Page{
		public static WebElement userName() {return driver.findElement(By.id("username"));}
		public static WebElement password() {return driver.findElement(By.id("password"));}
		public static WebElement ward() {return driver.findElement(By.id("Inpatient Ward"));}
		public static WebElement loginButton() {return driver.findElement(By.id("loginButton"));}
		public static WebElement msg() {return driver.findElement(By.tagName("h4"));}
	}

}