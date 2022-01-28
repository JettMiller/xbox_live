package xbox.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.CustomAssertion;
import util.TestCaseBase;
import xbox.basepages.XboxHomePage;

public class XboxVerify extends TestCaseBase {

	@Test(groups = {"ChromeWin32", "IEWin32"})
	public void open() throws InterruptedException {
		XboxHomePage home = new XboxHomePage();
		CustomAssertion assertion = new CustomAssertion();
		home.open();
		home.waitPage();
		Assert.assertTrue(home.titleIs(home.TITLE));
	}
	
}
