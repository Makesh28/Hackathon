package pageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarLoan extends BasePage{
	
	public CarLoan(WebDriver driver)
	{
		super(driver);
	}
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	//EMI Calculator Element
	@FindBy(xpath = "//a[@title = 'EMI Calculator']")
	WebElement emiCalcBtn;
	
	//Car Loan Element
	@FindBy(id = "car-loan")
	WebElement carLoan;
	
	//Car Loan Amount Text Box
	@FindBy(id = "loanamount")
	WebElement carLoanAmtTextBox;
	
	//Loan Interest Text Box
	@FindBy(id = "loaninterest")
	WebElement intRateTextBox;
	
	//Loan Tenure Slider
	@FindBy(xpath = "//*[@id='loantermslider']/span")
	WebElement loanTenSlider;
	
	//Loan Tenure TextBox
	@FindBy(xpath = "//input[@id='loanterm']")
	WebElement loanTenTxtBox;
	
	//Loan Tenure Year Button
	@FindBy(xpath = "//label[@class = 'btn btn-secondary active']/input[@id = 'loanyears']")
	WebElement year;
	
	//Year 2024 in the table
	@FindBy(xpath = "//td[@id = 'year2024']")
	WebElement year2024;
	
	//Year 2025 in the table
	@FindBy(xpath = "//td[@id = 'year2025']")
	WebElement year2025;
	
	//Months of 2024
	@FindBy(xpath = "//tr[@id = 'monthyear2024']/td/div/table/tbody/tr")
	List<WebElement> months2024;
		
	//Months of 2025
	@FindBy(xpath = "//tr[@id = 'monthyear2025']/td/div/table/tbody/tr")
	List<WebElement> months2025;
	
	
	//Navigator for the page
	public void navigator() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(emiCalcBtn)).click();
	}
	
	//Clicking on the car loan element
	public void clickCarLoan() {
		//carLoan.sendKeys(Keys.RETURN);
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(carLoan)).click();
	}
	
	//Sending value to the Loan Amount Text Box
	public void setLoanAmt(String amt) {
		carLoanAmtTextBox.clear();
		carLoanAmtTextBox.sendKeys(amt);
	}
	
	//Sending value to the Loan Interest Text Box
	public void setInterest(String interest) {
		js.executeScript("arguments[0].value=\""+interest+"\"", intRateTextBox);
	}
	
	//Sliding the Loan Tenure Slider
	public void moveLoanTenureSlider(int x) {
		Actions act = new Actions(driver);
		act.moveToElement(loanTenSlider);
		act.perform();
		act.dragAndDropBy(loanTenSlider,x,0).build().perform();
//		loanTenTxtBox.clear();
//		js.executeScript("arguments[0].value='';", loanTenTxtBox);
//		loanTenTxtBox.sendKeys(x);

	}
	//Clicking on Loan Tenure Year Button
	public void clickOnYear() {
		js.executeScript("arguments[0].click();", year);
	
	}
	//Scrolling to the Table Element
	public void scrollToTable() {
		Actions act = new Actions(driver);
		act.moveToElement(year2024).perform();
	}
	
	//Clicking on 2024 and 2025
		public void clickOnYears() {
			js.executeScript("arguments[0].click();", year2024);
			js.executeScript("arguments[0].click();", year2025);	
			
		}
		
	//Printing the EMI Payment Table
		public void printTheEMIPaymentTable() {
			int cols = 3;
			
			//Printing the row of year 2024
			for(int j = 0; j < cols; j++) {
				WebElement element=driver.findElement(By.xpath("//tbody/tr[@class = "
								+ "'row no-margin yearlypaymentdetails'][1]/"
								+ "td["+(j + 1)+"]\t"));
				System.out.print(element.getText());
			}
			//Moving the cursor to next line
			System.out.println(); 
			
			//Printing the rows of months under year 2024
			for(int i = 0; i < months2024.size(); i++) {
				for(int j = 0; j < cols; j++) {
					WebElement element=driver.findElement(By.xpath("//tr[@id = "
									+ "'monthyear2024']/td/div/table/tbody/tr["+(i+1)+"]/"
									+ "td["+(j+1)+"]\t"));
					System.out.print(element.getText());
				}
				//Moving the cursor to next line
				System.out.println();
			}
			//Printing the row of year 2025
			for(int j = 0; j < cols; j++) {
				WebElement element=driver.findElement(By.xpath("//tbody/tr[@class = "
								+ "'row no-margin yearlypaymentdetails'][2]/td["+(j + 1)+"]"
								+ "\t"));
				System.out.print(element.getText());
			}
			
			//Moving the cursor to next line
			System.out.println(); 
			
			//Printing the rows of months under year 2025
			for(int i = 0; i < months2025.size(); i++) {
				for(int j = 0; j < cols; j++) {
					WebElement element=driver.findElement(By.xpath("//tr[@id = 'monthyear2025']/td/div/table/tbody/tr["
								+(i+1)+"]/td["+(j+1)+"]\t"));
					System.out.print(element.getText());
				}
				//Moving the cursor to next line
				System.out.println();
			}
			Actions act = new Actions(driver);
			act.moveToElement(year2025);
			act.perform();
		}
		
		 

		 public String[][] getEMIPaymentTableData() {
		     int cols = 3;
		     List<String[]> data = new ArrayList<>();

		     // Get data for year 2024
		     String[] year2024 = new String[cols];
		     for (int j = 0; j < cols; j++) {
		         WebElement element = driver.findElement(By.xpath("//tbody/tr[@class='row no-margin yearlypaymentdetails'][1]/td[" + (j + 1) + "]"));
		         year2024[j] = element.getText();
		     }
		     data.add(year2024);

		     for (int i = 0; i < months2024.size(); i++) {
		         String[] month = new String[cols];
		         for (int j = 0; j < cols; j++) {
		             WebElement element = driver.findElement(By.xpath("//tr[@id='monthyear2024']/td/div/table/tbody/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"));
		             month[j] = element.getText();
		         }
		         data.add(month);
		     }

		     // Get data for year 2025
		     String[] year2025 = new String[cols];
		     for (int j = 0; j < cols; j++) {
		         WebElement element = driver.findElement(By.xpath("//tbody/tr[@class='row no-margin yearlypaymentdetails'][2]/td[" + (j + 1) + "]"));
		         year2025[j] = element.getText();
		     }
		     data.add(year2025);

		     for (int i = 0; i < months2025.size(); i++) {
		         String[] month = new String[cols];
		         for (int j = 0; j < cols; j++) {
		             WebElement element = driver.findElement(By.xpath("//tr[@id='monthyear2025']/td/div/table/tbody/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"));
		             month[j] = element.getText();
		         }
		         data.add(month);
		     }

		     String[][] dataArray = new String[data.size()][cols];
		     for (int i = 0; i < data.size(); i++) {
		         dataArray[i] = data.get(i);
		     }
		     return dataArray;
		 }

}


