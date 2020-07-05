package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		//Making changes to the script after R1.1
		String[][] data = GenericMethods.getData("D:\\SelMar29\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToApp":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserId(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickButton":
				Methods.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = Methods.getErrMsg(data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApplication":
				Methods.closeApplicationWindow();
				break;
			}
		}
	}
}
