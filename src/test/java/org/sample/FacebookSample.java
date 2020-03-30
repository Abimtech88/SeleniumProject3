package org.sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookSample extends LibGlobal {
public static void main(String[] args) throws IOException {
	
	LibGlobal g = new LibGlobal();
	WebDriver driver = g.getDriver();
	g.loadUrl("https://www.facebook.com/");
	WebElement user = driver.findElement(By.id("email"));
	g.send(user, "JAva");
	WebElement pass = driver.findElement(By.id("pass"));
	g.send(pass, "1234");
	WebElement clk = driver.findElement(By.xpath("//input[@value='Log In']"));
	g.clickBtn(clk);
	g.screenShot();
	
}
}
