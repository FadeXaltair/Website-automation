package methods;

import driver.Driver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
// import java.util.Listjava.lang.String[];

import java.io.FileWriter;
import com.opencsv.CSVWriter;

public class home_methods {

  public static void main(String args[]) throws Exception {
    //Instantiating the CSVWriter class
    CSVWriter writer = new CSVWriter(new FileWriter("/home/xs238-hitran/Desktop/Xs Automate/gauge-tests/env_variables/home.csv"));
    //Writing data to a csv file
    String line1[] = {"id", "name", "salary", "start_date", "dept"};
    String line2[] = {"1", "Krishna", "2548", "2012-01-01", "IT"};
    String line3[] = {"2", "Vishnu", "4522", "2013-02-26", "Operations"};
    String line4[] = {"3", "Raja", "3021", "2016-10-10", "HR"};
    // String line5[] = {"4", "Raghav", "6988", "2012-01-01", "IT"};
    //Writing data to the csv file
    List list = new ArrayList();
    list.add(line1);
    list.add(line2);
    list.add(line3);
    list.add(line4);
    // list.add(line5);
    //Writing data to the csv file
    writer.writeAll(list);
    writer.flush();
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("Data entered");
 }


// SELECTION OF ENVIRONMENTAL VARIABLES
private Properties properties;
private final String propertyFilePath= "/home/xs238-hitran/Desktop/Xs Automate/gauge-tests/env_variables/home.properties";
   
public home_methods() {
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

 // Linking validation

public void Link_Validation() throws InterruptedException{
    Driver.webDriver.get("https://www.xenonstack.com/");
    SoftAssert softAssert = new SoftAssert();
    
      List<String> Real_List  = new ArrayList<>();
      List<String> Real_List2  = new ArrayList<>();
        List <WebElement> links =  Driver.webDriver.findElements(By.tagName("a"));
         for (WebElement webElement : links) {
              webElement.getAttribute("href");
              Real_List.add(webElement.getAttribute("href"));
          }

      Driver.webDriver.manage().window().maximize();
     System.out.println(" here is size of link: " + links.size());
     System.out.println(" AAQWQXDSC " + Real_List.size());

     //TITLE ARRAY
     String[] TitleData = properties.getProperty("TitleArray").split(",,, ");
    //  LinksArray 
     String[] data = properties.getProperty("LinkssArray").split(",");
    // LINKS VALIDATIONS

    System.out.println("data length " + data.length);
    System.out.println("Title data length " + TitleData.length);
    System.out.println("real list 1 length " +Real_List.size());
      for (int i = 0; i < data.length; i++) {
          
             //ASSERTIONS
             
        softAssert.assertEquals(data[i], Real_List.get(i), " Link is invalidd ");

              if(data[i].equals(Real_List.get(i))){

           //CHECK WHETHER URL IS OPENING OR NOT.

               Driver.webDriver.get(Real_List.get(i));
               
               Real_List2.add(Driver.webDriver.getTitle());
               
               Thread.sleep(3000);
               //ASSERTIONS
            
               softAssert.assertEquals(TitleData[i], Real_List2.get(i), "Link is working but we did not get the correct title"); 

               Thread.sleep(1000);

               Driver.webDriver.navigate().to("https://www.xenonstack.com/");
             
       } 
       
}
softAssert.assertAll();
}    


// }
// Heading Validations

public void validateAllTheHeadings(){
    Driver.webDriver.get("https://www.xenonstack.com/");
    List<String> Main_heading2  = new ArrayList<>();
    List<String> Main_heading3  = new ArrayList<>();
    List <WebElement> heading2 =  Driver.webDriver.findElements(By.tagName("h2"));
    List <WebElement> heading3 =  Driver.webDriver.findElements(By.tagName("h3"));
    
    // HEADING 2

    for(WebElement webElement : heading2){
      webElement.getAttribute("innerHTML");
      Main_heading2.add( webElement.getAttribute("innerHTML"));
    }

    String[] h2 = properties.getProperty("H2").split(",,, ");

    for (int i = 0; i < Main_heading2.size(); i++) {
      Assert.assertEquals(h2[i], Main_heading2.get(i), "headding2 have the issue");
     }

    //HEADING 3

    for(WebElement webElement : heading3){
      webElement.getAttribute("innerHTML");
      Main_heading3.add( webElement.getAttribute("innerHTML"));
    }

    String[] h3 = properties.getProperty("H3").split(",,, ");


     for (int i = 0; i < Main_heading3.size(); i++) {
      Assert.assertEquals(h3[i], Main_heading3.get(i), "headding3 have the issue");
     }
	}

    // contents validation

	public void verifyAllTheContent(){
        Driver.webDriver.get("https://www.xenonstack.com/");
         List <String> contents = new ArrayList<>();
       List <WebElement> contentData = Driver.webDriver.findElements(By.tagName("p"));
    
       for(WebElement webElement : contentData){
        webElement.getAttribute("innerHTML");
        contents.add(webElement.getAttribute("innerHTML"));
       }
    
       String[] real_Content = properties.getProperty("CONTENTS").split(",,, ");
       
       for (int i = 0; i < real_Content.length; i++) {

        // ASSERTION 
        Assert.assertEquals(real_Content[i], contents.get(i), "Its is not matching up with the page");
       }
     }
     

     // Images validation
     
     public void imagesInTheHomePage(){
        Driver.webDriver.get("https://www.xenonstack.com/");
    
        List <String> All_Images_Attribute = new ArrayList<>();
        String total_count = properties.getProperty("Displayed_Image_count");
    
        String[] All_Images = properties.getProperty("Total_Images").split(",,, ");
      
        List<WebElement> list_Images=Driver.webDriver.findElements(By.tagName("img"));
        System.out.println("No. of Images: "+list_Images.size());
         
        for (WebElement webElement : list_Images) {
          webElement.getAttribute("alt");
          All_Images_Attribute.add(webElement.getAttribute("alt"));
      }
     
        for (int i = 0; i < All_Images.length ; i++) {

        
          Assert.assertEquals(All_Images[i], All_Images_Attribute.get(i) , "Image is missing");
    
        }
        int count =0;
      
        for(WebElement image:list_Images)
        {  
            if(image.isDisplayed())
            {
             count ++;
            }
            
        }
        String actual_count = Integer.toString(count);
        Assert.assertEquals(total_count, actual_count, "Images are not displayed correctly ");
      
        }  
}