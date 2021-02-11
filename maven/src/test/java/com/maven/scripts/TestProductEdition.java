package com.maven.scripts;

import org.testng.annotations.Test;

import com.manevn.generics.BaseTest;
import com.manevn.generics.FWUtils;
import com.maven.pages.EnterTimeTrackPage;
import com.maven.pages.LicensesPage;
import com.maven.pages.LoginPage;

public class TestProductEdition extends BaseTest{

	@Test
	public void TestValidProductEdition() {
		String un = FWUtils.Read_XL_Data(Read_XL_data, "CheckProductEdition", 1, 0);
		String pw = FWUtils.Read_XL_Data(Read_XL_data, "CheckProductEdition", 1, 1);
		String ExpectedTitleEtp = FWUtils.Read_XL_Data(Read_XL_data, "CheckProductEdition", 1, 2);
		String ExpectedTitleLcp = FWUtils.Read_XL_Data(Read_XL_data, "CheckProductEdition", 1, 3);
		String ExoecetdProductedition = FWUtils.Read_XL_Data(Read_XL_data, "CheckProductEdition", 1, 4);
		
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(un);
		lp.SetPassword(pw);
		lp.ClickOnLogInButton();
		FWUtils.VerifyPageTitle(driver, ExpectedTitleEtp);
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.ClickOnSettings();
		etp.ClickOnLicenses();
		FWUtils.VerifyPageTitle(driver, ExpectedTitleLcp);
		LicensesPage lcp = new LicensesPage(driver);
		lcp.verifyProductEdition(ExoecetdProductedition);
		
		

	}

}
