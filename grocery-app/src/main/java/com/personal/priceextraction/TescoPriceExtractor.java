package com.personal.priceextraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TescoPriceExtractor implements CommandLineRunner {
     
	@Override
	public void run(String... args) throws Exception {
		 WebDriver driver = new EdgeDriver();
		 System.out.println("SELENIUM --------------");
		 
	     try {
	         driver.get("https://www.tesco.com/groceries/en-GB/products/261384030");
	         String price = driver.findElement(By.xpath("//*[@id=\"asparagus-root\"]/div/div[2]/main/div/div/div[2]/div/section[2]/div[2]/div[1]/div/div/div[1]/p")).getText();
			 System.out.println("SELENIUM --------------" + price);

	     } finally {
	         driver.quit();
	     }
		
	}
	
}
