package weather.com;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Weather {
	public static void main(String[] args) {
		
		//1. Setup of ndtv
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ndtv.com/");
		
		
		//2. Reaching to the weather Section
		driver.findElement(By.id("h_sub_menu")).click();
		driver.findElement(By.xpath("//*[@id=\"subnav\"]/div/div/div/div/div/a[5]")).click();
		
		//3. Selection of City
		WebElement workingCheckBox=driver.findElement(By.xpath("//*[@id=\"Kanpur\"]"));
		workingCheckBox.click();
		
		//4 & 5.  Validating that the corresponding city is available on the map with temperature information
		boolean tempStatus = driver.findElement(By.className("tempRedText")).isDisplayed();
		boolean mapstatus = driver.findElement(By.className("cityText")).isDisplayed();
		if(mapstatus == true && tempStatus == true) {
			System.out.println("City is present with temperature on map");
		}
		else {
			System.out.println("City is not present on map");
		}
		
		
		//5. Validate that selecting any city on the map reveals the weather details
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the temperature: ");
		String temperatureValue = sc.next();
		
		String TxtBoxContent = driver.findElement(By.className("tempRedText")).getText();
		TxtBoxContent = TxtBoxContent.substring(0,2);
		if(TxtBoxContent.equals(temperatureValue)) {
			System.out.println("yes your temperature is correct");
		}
		else {
			System.out.println("No wrong temperature u put");
		}
		System.out.println("Printing " + TxtBoxContent);
		
	}
}

