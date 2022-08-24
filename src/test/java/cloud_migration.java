import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import java.lang.NullPointerException;
import org.testng.Assert;
// import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class cloud_migration {
     // SELECTION OF ENVIRONMENTAL VARIABLES
     private Properties properties;
     private final String propertyFilePath= "/home/xs238-hitran/Desktop/Xs Automate/gauge-tests/env_variables/cloud_migration.properties";
        
     public cloud_migration() {
     BufferedReader reader;
     
     try {
     reader = new BufferedReader(new FileReader(propertyFilePath));
     properties = new Properties();
     try {
     properties.load(reader);
     reader.close();
     }
         catch (IOException e) {
     e.printStackTrace();
     }
     }
        catch (FileNotFoundException e) {
     e.printStackTrace();
     throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
     }
     }

	@Step("Links validation and titles validation for cloud migration page")
	public void linksValidationAndTitlesValidationForCloudMigrationPage(){
        Driver.webDriver.get("https://www.xenonstack.com/services/cloud-migration/");
        int count =0;
        int title =0 ;
        List<String> Real_List  = new ArrayList<>();
        List<String> Real_List2  = new ArrayList<>();
        String invalidLink = null;
          List <WebElement> links =  Driver.webDriver.findElements(By.tagName("a"));
           for (WebElement webElement : links) {
                webElement.getAttribute("href");
                Real_List.add(webElement.getAttribute("href"));
            }
            for (int i = 0; i < Real_List.size(); i++) {
                if(Real_List.get(i) == null){
                    System.out.println("url is null");
                }else{
                    Driver.webDriver.get(Real_List.get(i));
                System.out.println(Driver.webDriver.getTitle() + ",,,");
                count++;
                title++;
                }
                
            }
            System.out.println("Total links are : " + count);
            System.out.println("total titles are : " + title );
	}

	@Step("Validate all the headings for cloud migration page")
	public void validateAllTheHeadingsForCloudMigrationPage(){
		
	}

	@Step("Verify the contents for cloud migration page")
	public void verifyTheContentsForCloudMigrationPage(){
		
	}
}
