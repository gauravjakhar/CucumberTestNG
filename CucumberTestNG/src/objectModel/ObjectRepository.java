package objectModel;

import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;
import utility.Drivers;

public class ObjectRepository {

	public static class Home_Page{
		public static WebElement likebutton() {return Drivers.driver.findElement(By.xpath("//div[@class='test']"));}
		public static List<WebElement> share() {return Drivers.driver.findElements(By.id("share-12345"));}
		public static WebElement logout() {return Drivers.driver.findElement(By.id("Logout"));}
	}

	public static class Login_Page{
		public static WebElement userName() {return Drivers.driver.findElement(By.id("username"));}
		public static WebElement password() {return Drivers.driver.findElement(By.id("password"));}
		public static WebElement ward() {return Drivers.driver.findElement(By.id("Inpatient Ward"));}
		public static WebElement loginButton() {return Drivers.driver.findElement(By.id("loginButton"));}
		public static WebElement msg() {return Drivers.driver.findElement(By.tagName("h4"));}
	}

}