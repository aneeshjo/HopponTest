import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Hoppon_SignIn/Login_Hoppon_TC3'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('SHOP BY PROMOS', false)

WebUI.click(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/a_shop by promos'))

WebDriver driver1 = DriverFactory.getWebDriver()

String selector = 'div.col-md-12.col-sm-12.col-xs-12'

ArrayList items = driver1.findElements(By.cssSelector(selector))

ArrayList list1 = new ArrayList()

List<WebElement> categoryList =driver1.findElements(By.xpath("//*[@class='btn btn-category indsutryimage']"))

System.out.println(categoryList.size())

//for (WebElement CL:categoryList) {
//	CL.click()
//	WebUI.delay(7)
//}

categoryList[14].click()


List<WebElement> dropDownList =driver1.findElements(By.xpath("//select[@id='promosfilterstore']/option"))

System.out.println(dropDownList.size())

for(WebElement dDL:dropDownList) {
	dDL.click()
	WebUI.delay(4)
	List<WebElement> todaysPromoListOne= driver1.findElements(By.xpath("//div[@id='outputsort']/div/div"))
	
	
	if(todaysPromoListOne.size()==0) {
		WebUI.verifyTextPresent("NO PROMOS FOUND IN THIS STORE.", false)
	}
	WebUI.delay(4)
	System.out.println(todaysPromoListOne.size())
}

categoryList[16].click()


List<WebElement> dropDownList1 =driver1.findElements(By.xpath("//select[@id='promosfilterstore']/option"))

System.out.println(dropDownList1.size())

for(WebElement dDL:dropDownList1) {
	dDL.click()
	WebUI.delay(4)
	List<WebElement> todaysPromoListOne= driver1.findElements(By.xpath("//div[@id='outputsort']/div/div"))
	
	
	if(todaysPromoListOne.size()==0) {
		WebUI.verifyTextPresent("NO PROMOS FOUND IN THIS STORE.", false)
	}
	
	WebUI.delay(4)
	System.out.println(todaysPromoListOne.size())
}

