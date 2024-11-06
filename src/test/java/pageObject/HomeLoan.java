package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLoan extends BasePage {
	
		public HomeLoan(WebDriver driver)
		{
		super(driver);
		}
		
	    //Main Menu Element
		@FindBy(xpath = "//a[@id = 'menu-item-dropdown-2696']")
		WebElement mainMenuBtn;
		
		//Home Loan EMI Calculator
		@FindBy(xpath = "//a[@title = 'Home Loan EMI Calculator']")
		WebElement homeLoanEmiCalcBtn;
		
		//rows
		@FindBy(xpath = "//table[@class =  'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']")
		List<WebElement> rows;
		
		//Columns
		@FindBy(xpath = "//table[@class = 'noextras']/tbody/tr/th")
		List<WebElement> cols;
		
		
		//Navigator for the page
		public void navigator() {
			mainMenuBtn.click();
			homeLoanEmiCalcBtn.click();
		}

		//Returning The Whole Year Table in array
		public String[][] getTableData() {
			String[][] datas = new String[rows.size()][cols.size()];
			for(int i = 0; i < rows.size(); i++) {
				for(int j = 0; j < cols.size(); j++) {
					datas[i][j] = driver.findElement(By.xpath("//table[@class = 'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']"
									+ "["+(i+1)+"]/td["+(j+1)+"]")).getText();
				}
			}
			return datas;
		}
		
		
		//Scrolls to the displayed table
		public void scrollToTable() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", rows.get(0));
		}

}
