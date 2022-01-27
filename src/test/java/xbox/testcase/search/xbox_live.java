package xbox.testcase.search;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class xbox_live { 
	
	private ChromeDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Browser");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.xboxgamertag.com/leaderboards");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser Session...");
		if(driver != null) {
			  driver.quit();
		 }
	}

	@Test
	public void top5() {
		System.out.println("Validating the Top 5 users");
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
	@Test
	public void recentgames() throws InterruptedException {
		System.out.println("Validating first four games of BlazingArrows24");
		WebElement search = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/input"));
		search.sendKeys("BlazingArrows24");
		Thread.sleep(500);
		WebElement sbutton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/button"));
		Thread.sleep(1000);
		sbutton.click();
		Thread.sleep(500);
		WebElement game1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div[1]/h3/a"));
		WebElement game2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/h3/a"));
		WebElement game3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/h3/a"));
		WebElement game4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div[1]/h3/a"));
		Assert.assertEquals(game1.getText(), "League of Legends");
		Assert.assertEquals(game2.getText(), "Fortnite");
		Assert.assertEquals(game3.getText(), "DARK SOULS™ II");
		Assert.assertEquals(game4.getText(), "Skyrim");
	}
}
