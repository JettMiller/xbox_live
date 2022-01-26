package util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
		System.
		System.out.println("Closing the browser Session...");
		if(driver != null) {
			  driver.quit();
		 }
	}

	@Test
	public void top5() {
		String[] topUsers;
		try {
			Scanner sc = new Scanner(new File("top5gt.txt"));
			sc.useDelimiter(",");
			int i = 0;
			while(sc.hasNext()) {
				topUsers[i] = sc.next();
				i += 1;
			}
		}
		
		System.out.println("Validating the Top 5 users");
		WebElement top1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/a"));
		WebElement top2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/a"));
		WebElement top3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/a"));
		WebElement top4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[3]/a"));
		WebElement top5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/a"));
		Assert.assertEquals(top1.getText(), topUsers[0]);
		Assert.assertEquals(top2.getText(), topUsers[1]);
		Assert.assertEquals(top3.getText(), topUsers[2]);
		Assert.assertEquals(top4.getText(), topUsers[3]);
		Assert.assertEquals(top5.getText(), topUsers[4]);
	}
	@Test
	public void recentgames() throws InterruptedException {
		String[] topGames;
		try {
			Scanner sc = new Scanner(new File("top4g.txt"));
			sc.useDelimiter(",");
			int i = 0;
			while(sc.hasNext()) {
				topGames[i] = sc.next();
				i += 1;
			}
		}
		System.out.println("Validating first four games of Selected User");
		WebElement search = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/input"));
		search.sendKeys(topGames[0]);
		Thread.sleep(500);
		WebElement sbutton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/button"));
		Thread.sleep(1000);
		sbutton.click();
		Thread.sleep(500);
		WebElement game1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div[1]/h3/a"));
		WebElement game2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/h3/a"));
		WebElement game3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/h3/a"));
		WebElement game4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div[1]/h3/a"));
		Assert.assertEquals(game1.getText(), topGames[1]);
		Assert.assertEquals(game2.getText(), topGames[2];
		Assert.assertEquals(game3.getText(), topGames[3]);
		Assert.assertEquals(game4.getText(), topGames[4]);
	}
}
