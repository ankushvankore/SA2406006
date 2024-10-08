package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A09RediffAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.findElement(By.xpath("/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[3]/td[3]/input[1]")).sendKeys("Ankush Vankore");
		driver.findElement(By.xpath("/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[7]/td[3]/input[1]")).sendKeys("ankushvankore");
		driver.findElement(By.xpath("/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[7]/td[3]/input[2]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Message: " + driver.findElement(By.xpath("/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[5]/td[3]/div[1]/font[1]/b[1]")).getText());
		
		//driver.close();
	}

}
