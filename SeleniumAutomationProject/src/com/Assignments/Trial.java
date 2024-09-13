package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://echoecho.com/htmlforms09.htm");
		
		//driver.findElement(By.linkText("radio buttons")).click();
		
		WebElement rediobutton1=driver.findElement(By.xpath("//form [@action='dummy']//input[@value='Milk']"));
		System.out.println("Befor clicking");
		System.out.println("Milk is selected : " +rediobutton1.isSelected());
		System.out.println("Milk is Displayed : " +rediobutton1.isDisplayed());
		System.out.println("Milk is Displayed : " +rediobutton1.isEnabled());
		
		
		if(rediobutton1.isSelected() == false) {
			rediobutton1.click();
		}
		System.out.println("After clicking");
		System.out.println("Milk is selected : " +rediobutton1.isSelected());
		System.out.println("Milk is Displayed : " +rediobutton1.isDisplayed());
		System.out.println("Milk is Displayed : " +rediobutton1.isEnabled());


	}

}
