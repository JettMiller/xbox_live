package xbox.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		
		WebElement top1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/a"));
		WebElement top2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/a"));
		WebElement top3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/a"));
		WebElement top4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[3]/a"));
		WebElement top5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/a"));
		Assert.assertEquals(top1.getText(), "fumingpuma5803");
		Assert.assertEquals(top2.getText(), "Chrissie");
		Assert.assertEquals(top3.getText(), "WNA3T");
		Assert.assertEquals(top4.getText(), "Senjuu x");
		Assert.assertEquals(top5.getText(), "SpriTe Iight");
	}
	
}
