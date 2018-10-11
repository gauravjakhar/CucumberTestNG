package objectModel;

import objectModel.ObjectRepository.*;

public class LoginMethods {
	
	public static void enterUsername() {
		Login_Page.userName().sendKeys("Admin");
	}
	
	public static void enterPassword() {
		Login_Page.password().sendKeys("Admin123");
		Login_Page.loginButton().click();
	}
	
	public static boolean verifyMessage() {
		return Login_Page.msg().getText().contains("Logged");
	}
	
}
