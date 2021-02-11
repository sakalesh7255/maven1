package com.maven.script;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {
	
	@Test
	public void testbrowser( ) {
		Reporter.log("browser is opened" , true);
	}

}
