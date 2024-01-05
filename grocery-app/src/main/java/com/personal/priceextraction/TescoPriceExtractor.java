package com.personal.priceextraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.CommandLineRunner;

public class TescoPriceExtractor implements CommandLineRunner {
     
	@Override
	public void run(String... args) throws Exception {
		 WebDriver driver = new EdgeDriver();
		 
	     try {
	         driver.get("https://www.tesco.com/groceries/en-GB/products/253034146");
	         driver.findElement(By.xpath("//*[@id=\"asparagus-root\"]/div/div[2]/main/div/div/div[2]/div/section[2]/div[2]/div[1]/div/div/div[1]/p"));
	     } finally {
	         driver.quit();
	     }
		
	}
	
}
