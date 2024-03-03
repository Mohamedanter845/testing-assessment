import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Productsearch {

    public static void main(String[] args) {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\firstproject");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the web browser and navigate to the e-commerce website
        driver.get("https://egyptlaptop.com/");

        // Enter a keyword in the search bar
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("laptop");

        // Click the search button
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        // Verify that the search results page displays relevant products
        WebElement searchResults = driver.findElement(By.xpath("//div[@class='products']"));
        if (searchResults.isDisplayed()) {
            System.out.println("Search results displayed. Test Passed!");
        } else {
            System.out.println("Search results not displayed. Test Failed!");
        }

        // Close the browser
        driver.quit();
    }
}
