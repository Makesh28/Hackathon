package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//features/"},
					//features= {".//features/F1_CarLoan.feature",".//features/F3_EMICalcUI.feature",".//features/LoanAmtCalcUI.feature",".//Features/LoanTenUI.feature"},
		            //features= {".//features/F1_CarLoan.feature",".//features/F3_HomeLoan.feature"},
					//features= {".//features/F1_CarLoan.feature"},
					//features= {".//Features/F2_HomeLoan.feature"},
		            //features= {".//Features/F5_LoanTenUI.feature"},
					//features= {"@target/rerun.txt"},
					glue={"StepDefenition", "Hooks"},
					plugin= {"pretty", "html:reports/myreport.html", 
							  //"rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
					//tags="@smoke"  // this will execute scenarios tagged with @smoke
					//tags="@regression"
					//tags="@smoke and @regression" //Scenarios tagged with both @smoke and @regression
					//tags="@smoke and not @regression" //Scenarios tagged with @smoke but not tagged with @regression
					//tags="@smoke or @regression" //Scenarios tagged with either @smoke or @regression
		)
public class TestRun {

}
