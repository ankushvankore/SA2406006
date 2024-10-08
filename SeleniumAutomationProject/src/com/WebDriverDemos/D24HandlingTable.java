package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D24HandlingTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		//List<WebElement>headers = driver.findElements(By.xpath("/html/body/div[2]/div[4]/table/thead/tr/th"));
		List<WebElement>headers = driver.findElements(By.tagName("th"));
		for(WebElement h : headers)
			System.out.println(h.getText());
		
		List<WebElement>allRows = driver.findElements(By.xpath("/html/body/div[2]/div[4]/table/tbody/tr"));
		System.out.println("Total rows: " + allRows.size());
		
		Random rnd = new Random();
		//int n = rnd.nextInt(6);	//This will generage a random number in the range of 0 to 5
		int n = rnd.nextInt(allRows.size());
		System.out.println(n);
		
		System.out.println(allRows.get(n).getText());
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[4]/table/tbody/tr[" + (n+1) + "]")).getText());
		
		List<WebElement>currentPrice = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		double[] cpArray = new double[currentPrice.size()];
		
		for(int i = 0; i < cpArray.length; i++)
		{
			//String cp = currentPrice.get(i).getText();
			//cp = cp.replace(",", "");
			//cpArray[i] = Double.parseDouble(cp);
			cpArray[i] = Double.parseDouble(currentPrice.get(i).getText().replace(",", ""));
			System.out.println(cpArray[i]);
		}
		
		
		driver.close();
	}

}
