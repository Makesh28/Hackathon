package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UIpage extends BasePage{
	
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public UIpage(WebDriver driver) {
		
		super(driver);
	}
	
	   //Main Menu Element
		@FindBy(xpath = "//a[@id = 'menu-item-dropdown-2696']")
		WebElement mainMenuBtn;
		
		//Loan Calculator Element
		@FindBy(xpath = "//a[@title = 'Loan Calculator']")
		WebElement loanCalcBtn;
		
		
		//All the elements
		//Loan Amount Text Box
		@FindBy(xpath = "//input[@id = 'loanamount']")
		WebElement loanAmountTextBox;
		
		//Loan Amount Slider
		@FindBy(xpath = "//div[@id = 'loanamountslider']/span")
		WebElement loanAmountSlider;
		
		//Interest Rate Text Box
		@FindBy(xpath = "//input[@id = 'loaninterest']")
		WebElement IntRateTextBox;
		
		//Interest Rate Slider
		@FindBy(xpath = "//div[@id = 'loaninterestslider']/span")
		WebElement IntRateSlider;
		
		//Loan Tenure Text Box
		@FindBy(xpath = "//input[@id = 'loanterm']")
		WebElement LoanTenureTextBox;
			
		//Loan Tenure Slider
		@FindBy(xpath = "//div[@id = 'loantermslider']/span")
		WebElement LoanTenureSlider;
		
		//Fees & Charges Text Box
		@FindBy(xpath = "//input[@id = 'loanfees']")
		WebElement FeesAndChargesTextBox;
		
		//Fees & Charges Slider
		@FindBy(xpath = "//div[@id = 'loanfeesslider']/span")
		WebElement FeesAndChargesSlider;
		
		//EMI Text Box
		@FindBy(xpath = "//input[@id = 'loanemi']")
		WebElement emiTextBox;
		
		//EMI Slider
		@FindBy(xpath = "//div[@id = 'loanemislider']/span")
		WebElement emiSlider;
		
		//LoanTenureYear Button
		@FindBy(xpath = "//input[@id = 'loanyears']")
		WebElement yearBtn;
		
		//LoanTenureMonth Button
		@FindBy(xpath = "//input[@id = 'loanmonths']")
		WebElement monthBtn;
		
		//Element of Loan Amount Calculator
		//Loan Amount Calculator Button
		@FindBy(id = "loan-amount-calc")
		WebElement loanAmountCalcBtn;
		
		
		//Element of Loan Tenure Calculator
		//Loan Amount Calculator Button
		@FindBy(id = "loan-tenure-calc")
		WebElement loanTenureCalcBtn;
		

		public void navigatorForEMICalc() {
			mainMenuBtn.click();
			loanCalcBtn.click();
		}
		public void navigatorForLoanAmountCalc() {
			mainMenuBtn.click();
			loanCalcBtn.click();
			loanAmountCalcBtn.click();
		}
		public void navigatorForLoanTenureCalc() {
			mainMenuBtn.click();
			loanCalcBtn.click();
			loanTenureCalcBtn.click();
		}
		
		//*********************************Actions and Methods For LoanCalculator Page*********************************//
		
		//Clicking on Year and Month
		public void clickYear() {
			js.executeScript("arguments[0].click();", yearBtn);
		}
		public void clickMonth() {
			js.executeScript("arguments[0].click();", monthBtn);
		}
		
		//Methods for Loan Amount
		//Returning the Loan Amount Text Box Web Element
		public WebElement getLoanAmtTextBox() {
			return this.loanAmountTextBox;
		}
		//Returning the Loan Amount Text Box Web Element
		public WebElement getLoanAmtSlider() {
			return this.loanAmountSlider;
		}
		//Sliding the Loan Amount Slider
		public void moveLoanAmtSlider(int x) {
			act.dragAndDropBy(loanAmountSlider, x, 0).build().perform();
		}
		//Returning the value of Loan Amount Text Box Web Element
		public String getLoanAmtTextBoxValue() {
			return js.executeScript("return document.getElementById('loanamount').value").toString();
		}
		
		//Methods for Interest Rate
		//Returning the Interest Rate Text Box Web Element
		public WebElement getIntRateTextBox() {
			return this.IntRateTextBox;
		}
		//Returning the Interest Rate Text Box Web Element
		public WebElement getIntRateSlider() {
			return this.IntRateSlider;
		}
		//Sliding the Interest Rate Slider
		public void moveIntRateSlider(int x) {
			act.dragAndDropBy(IntRateSlider, x, 0).build().perform();
		}
		//Returning the value of Interest Rate Text Box Web Element
		public String getIntRateTextBoxValue() {
			return js.executeScript("return document.getElementById('loaninterest').value").toString();
		}
		
		//Methods for Loan Tenure
		//Returning the Loan Tenure Text Box Web Element
		public WebElement getLoanTenureTextBox() {
			return this.LoanTenureTextBox;
		}
		//Returning the Loan Tenure Text Box Web Element
		public WebElement getLoanTenureSlider() {
			return this.LoanTenureSlider;
		}
		//Sliding the Loan Tenure Slider
		public void moveLoanTenureSlider(int x) {
			act.dragAndDropBy(LoanTenureSlider, x, 0).build().perform();
		}
		//Returning the value of Loan Tenure Text Box Web Element
		public String getLoanTenureTextBoxValue() {
			return js.executeScript("return document.getElementById('loanterm').value").toString();
		}
		
		//Methods for Fees & Charges
		//Returning the Fees & Charges Text Box Web Element
		public WebElement getFeesAndChargesTextBox() {
			return this.FeesAndChargesTextBox;
		}
		//Returning the Fees & Charges Text Box Web Element
		public WebElement getFeesAndChargesSlider() {
			return this.FeesAndChargesSlider;
		}
		//Sliding the Fees & Charges Slider
		public void moveFeesAndChargesSlider(int x) {
			act.dragAndDropBy(FeesAndChargesSlider, x, 0).build().perform();
		}
		//Returning the value of Fees & Charges Text Box Web Element
		public String getFeesAndChargesTextBoxValue() {
			return js.executeScript("return document.getElementById('loanfees').value").toString();
		}
		
		//Methods for EMI
		//Returning the EMI Text Box Web Element
		public WebElement getEMITextBox() {
			return this.emiTextBox;
		}
		//Returning the EMI Text Box Web Element
		public WebElement getEMISlider() {
			return this.emiSlider;
		}
		//Sliding the EMI Slider
		public void moveEMISlider(int x) {
			act.dragAndDropBy(emiSlider, x, 0).build().perform();
		}
		//Returning the value of EMI Text Box Web Element
		public String getEMITextBoxValue() {
			return js.executeScript("return document.getElementById('loanemi').value").toString();
		}

	
}
