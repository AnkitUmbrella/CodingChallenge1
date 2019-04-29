package Naveen.NaveenCodingChallenge1.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//@author : Ankit Lohia

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Naveen.NaveenCodingChallenge1.base.TestBaseChallenge;



public class Homepage extends TestBaseChallenge {

	
	
	//PageFactory Elements or Object repo define for this class
	
	@FindBy(id="search-input-location") //InputText
	WebElement Inputtext;
	
	
	
	@FindBy(id="search-submit") //Searchbutton
	WebElement Searchbutton;
	
	
	
	@FindBy(xpath="//a[@class='listing-results-price text-price']") //ListViewPrice
	List<WebElement> ListViewPrice;
	

	@FindBy(xpath="//h4[@class='ui-agent__name']")
	WebElement Agentname;
	
	
	
	////h1[@class='bottom-half'] firstname
	////h1[@class='bottom-half']/b[2] //second name
	@FindBy(xpath="//h1[@class='bottom-half']")
	WebElement DetailPageAgentname1;

	
	@FindBy(xpath="//h1[@class='bottom-half']/b[2]")
	WebElement DetailPageAgentname2;
	
	
   //Create Constructor of this class
	//Initializing the Page Objects
   public Homepage() {
	   PageFactory.initElements(driver, this);
	      
	   
   }

   
   //Actions
   public boolean ValidateInputText() {
	   return Inputtext.isDisplayed();
	 
   }
   
   
   public boolean ValidateSearchButton() {
	   return Searchbutton.isDisplayed();
	 
   }
   
   
   
   public void Inputdata(String Location) {
	   Inputtext.sendKeys(Location);
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   WebElement test= driver.findElement(By.linkText(Location));
	   test.click();
   }
   
   public void Searchclick() {
	   Searchbutton.click();
   }
   
   
   
   
   public void GetList() throws InterruptedException {
	   ListViewPrice.size();
	   ArrayList<Integer> al = new ArrayList<Integer>();
	   for(int i=0; i<ListViewPrice.size(); i++) {
		   
		   String data= ListViewPrice.get(i).getText();
		   Thread.sleep(1000);
		   data= data.replaceAll("[^0-9]", ""); // to replace junk values
            System.out.println(data);
            al.add(Integer.parseInt(data)); //parse string into int value

	   }
	   
	   Thread.sleep(2000);
	//   Collections.sort(al);
	   Collections.sort(al, Collections.reverseOrder());
	   System.out.println("Sorted Properties Price is " +al);
	   
	      
   }
   
   
   
   public void fifthpropclick() throws InterruptedException {
	   ListViewPrice.size();
	   for(int i=0; i<ListViewPrice.size(); i++) {
		    Thread.sleep(2000);
		   ListViewPrice.get(4).click();
		   
	   }	   

   }   
	   
  public String agentclick() {
		   String name= Agentname.getText();
		   Agentname.click();
		   return name;
	   }
	   
  
  public void DetailPageName() {
	  String Fname= (DetailPageAgentname1).getText();
	  String Lname= DetailPageAgentname2.getText();
	  String expectedname= (Fname+","+Lname);
	  
	  System.out.println(expectedname);
	// return expectedname;
	
  }
  
  
   }
   
   



