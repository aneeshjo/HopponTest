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


WebUI.verifyElementClickable(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/figure_'))

WebUI.verifyElementClickable(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/i_Sign in_fa fa-arrow-left'))

WebUI.verifyElementClickable(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/i_Sign in_fa fa-arrow-right arrowmove'))

WebUI.verifyElementClickable(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/i_Sign in_fa fa-cart-plus fa-stack-1x fa-inverse shopping-cart gtaglink'))

WebUI.verifyElementClickable(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/i_Sign in_fa fa-question fa-stack-1x enquirepopup'))

String todayPromos= "//div[@id='outputsort']/div/div"

List<WebElement> todaysPromoList= driver1.findElements(By.xpath(todayPromos))

System.out.println(todaysPromoList.size())

String beforeNavigation=WebUI.getUrl()

System.out.println(beforeNavigation)

//for (WebElement tPL:todaysPromoList) {
//	tPL.click()
//	
//	WebUI.waitForPageLoad(8)
//	
//	String currentURL=WebUI.getUrl()
//	
//	if(beforeNavigation!=currentURL) {
//		WebUI.navigateToUrl(beforeNavigation)
//	}
//	
//	WebUI.waitForPageLoad(8)
//	
//}

for(int i=0;i<todaysPromoList.size();i++) {
	System.out.println(todaysPromoList[i].getText())
	
}

//for(int i=0;i<todaysPromoList.size();i++) {
//		
//}
todaysPromoList[3].click()
WebUI.delay(10)
WebUI.navigateToUrl(beforeNavigation)
WebUI.delay(10)

List<WebElement> dropDownList =driver1.findElements(By.xpath("//select[@id='promosfilterstore']/option"))

System.out.println(dropDownList.size())

for(WebElement dDL:dropDownList) {
	dDL.click()
	WebUI.delay(4)
	List<WebElement> todaysPromoListOne= driver1.findElements(By.xpath(todayPromos))
	if(todaysPromoListOne.size()==0) {
		WebUI.verifyTextPresent("NO PROMOS FOUND IN THIS STORE.", false)
	}
	
	WebUI.delay(4)
}


