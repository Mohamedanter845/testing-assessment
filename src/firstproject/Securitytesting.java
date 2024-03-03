import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Securitytesting {

    public static void main(String[] args) {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the web browser and navigate to the e-commerce website
        driver.get("https://egyptlaptop.com/");

        // Test for input validation failure (e.g., login with empty credentials)
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(@href,'login')]"));
        loginButton.click();
        WebElement loginForm = driver.findElement(By.id("form-login"));
        WebElement usernameInput = loginForm.findElement(By.id("input-email"));
        WebElement passwordInput = loginForm.findElement(By.id("input-password"));
        WebElement submitButton = loginForm.findElement(By.xpath("//input[@value='Login']"));
        submitButton.click();
        // Check for error message or validation feedback
        
        // Test for SQL injection (e.g., entering SQL commands in input fields)
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("'; DROP TABLE users; --");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        // Verify that the application handles SQL injection securely

        // Test for Cross-Site Scripting (XSS) attack (e.g., injecting JavaScript code)
        WebElement contactUsLink = driver.findElement(By.xpath("//a[contains(@href,'contact')]"));
        contactUsLink.click();
        WebElement messageInput = driver.findElement(By.id("input-enquiry"));
        messageInput.sendKeys("<script>alert('XSS Attack!');</script>");
        WebElement submitMessageButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitMessageButton.click();
        // Verify that the application sanitizes input and prevents XSS attacks

       
        // Close the browser
        driver.quit();
    }
}
