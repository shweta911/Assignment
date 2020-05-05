package Testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Demo {

	public static void main(String [] args)
	{
		int i =0;
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32");
	//	while (i < 10)
		//{
		//driver.get("https://www.youtube.com/watch?v=NOdPHphoYog");
		driver.get("https://www.youtube.com/watch?v=FED7r3AWZVM");
		driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[23]/div[2]/div[1]/a[2]")).click();
		// i++;
		driver.close();
		//}
}
}