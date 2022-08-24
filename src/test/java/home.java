import methods.home_methods;
import com.thoughtworks.gauge.Step;

public class home {

  @Step("Links validation and titles validation")
    public void links() throws InterruptedException{
      home_methods methods = new home_methods();
      methods.Link_Validation();
   }

	@Step("Validate all the headings")
	 public void headings(){
    home_methods headings = new home_methods();
    headings.validateAllTheHeadings();
	 }

	@Step("Verify the contents")
	public void contents(){
   home_methods contents = new home_methods();
   contents.verifyAllTheContent();
 } 

	@Step("Images in the home page")
	public void imagesInTheHomePage() throws InterruptedException{
    home_methods images = new home_methods();
    images.imagesInTheHomePage();  
	}  
  
}






