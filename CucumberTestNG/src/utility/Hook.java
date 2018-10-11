package utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	@Before
	public void setUp()
	{
		Drivers.driver = Drivers.initDriver();
	}	
	
	@After
	public void tearDown()
	{
		Drivers.quitDriver();
	}	

}