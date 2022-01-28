package xbox.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	@Test(groups = {"ChromeWin32", "IEWin32"})
	public void top5gt() throws InterruptedException, FileNotFoundException {
		XboxHomePage home = new XboxHomePage();
		home.open();
		home.waitPage();
		
		String user1;
		String user2;
		String user3;
		String user4;
		String user5;

		Scanner sc = new Scanner(new File("..\\XboxAssignment\\src\\test\\java\\xbox\\testcases\\top5gt"));
		sc.useDelimiter(",");
		user1 = sc.next();
		user2 = sc.next();
		user3 = sc.next();
		user4 = sc.next();
		user5 = sc.next();
		
		System.out.println("Validating the Top 5 users");
		WebElement top1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/a"));
		WebElement top2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/a"));
		WebElement top3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/a"));
		WebElement top4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[3]/a"));
		WebElement top5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/a"));
		Assert.assertEquals(top1.getText(), user1);
		Assert.assertEquals(top2.getText(), user2);
		Assert.assertEquals(top3.getText(), user3);
		Assert.assertEquals(top4.getText(), user4);
		Assert.assertEquals(top5.getText(), user5);
	}
	@Test(groups = {"ChromeWin32", "IEWin32"})
	public void gtsearch() throws InterruptedException, FileNotFoundException {
		XboxHomePage home = new XboxHomePage();
		CustomAssertion assertion = new CustomAssertion();
		home.open();
		home.waitPage();
		String user;
		String game1;
		String game2;
		String game3;
		String game4;
		
		Scanner sc = new Scanner(new File("..\\XboxAssignment\\src\\test\\java\\xbox\\testcases\\top4g"));
		sc.useDelimiter(",");
		user = sc.next();
		game1  = sc.next();
		game2  = sc.next();
		game3  = sc.next();
		game4  = sc.next();
		
		System.out.println("Validating first four games of " + user);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/input"));
		search.sendKeys(user);
		Thread.sleep(500);
		WebElement sbutton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/button"));
		Thread.sleep(1000);
		sbutton.click();
		Thread.sleep(500);
		WebElement rgame1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div[1]/h3/a"));
		WebElement rgame2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/h3/a"));
		WebElement rgame3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/h3/a"));
		WebElement rgame4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div[1]/h3/a"));
		Assert.assertEquals(rgame1.getText(), game1);
		Assert.assertEquals(rgame2.getText(), game2);
		Assert.assertEquals(rgame3.getText(), game3);
		Assert.assertEquals(rgame4.getText(), game4);
	}
}