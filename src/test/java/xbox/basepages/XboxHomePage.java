package xbox.basepages;

import util.Page;
import util.TestCaseBase;
import util.Waiting;

public class XboxHomePage extends Page {
	
	public static String TITLE = "Xbox Leaderboards - Xbox Gamertag";
	
	public XboxHomePage open() {
		String URL = "https://www.xboxgamertag.com/leaderboards";
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	}
	
	public XboxHomePage waitPage() throws InterruptedException {
		Thread.sleep(2000);
		Waiting.implicitly(2);
		return this;
	}
	
}
