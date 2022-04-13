import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.setText(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'), 
    '670571')

WebUI.clearText(findTestObject('Hoppon/SignIn/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'))

WebDriver driver = DriverFactory.getWebDriver()

ArrayList list1 = new ArrayList()

List<WebElement> suggestionList = driver.findElements(By.xpath('//input[@id=\'location-input\']'))

for (WebElement sl : suggestionList) {
    sl.click()

    sl.sendKeys('Kazhakkoottam, Kerala, India')

    sl.sendKeys(Keys.ARROW_DOWN)

    sl.sendKeys(Keys.ENTER)

    WebUI.delay(4)
}

WebUI.click(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/a_shop by promos'))

List<WebElement> promoList = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div/div'))

System.out.println(promoList.size())

for(int i=0;i<promoList.size();i++) {
	String name=promoList[i].getText()
	list1.add(name)
}

for(String item:list1) {
	System.out.println(item)
}

WebUI.click(findTestObject("Object Repository/Shop_By_Promo/PromoFilter/Page_Promos - Hoppon/span_By Nearest Shops"))

List<WebElement> nearByShop = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div/div'))

ArrayList nearByShopList = new ArrayList()

WebUI.click(findTestObject('Object Repository/Shop_By_Promo/PromoFilter/Page_Promos - Hoppon/i_By Nearest Shops_fa fa-industry'))

List<WebElement> nearByShopIcon = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div/div'))

System.out.println(nearByShopIcon.size())

WebUI.click(findTestObject('Object Repository/Shop_By_Promo/PromoFilter/Page_Promos - Hoppon/span_By Expiry Date'))

List<WebElement> byExpiryDate = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div/div'))

WebUI.click(findTestObject('Object Repository/Shop_By_Promo/PromoFilter/Page_Promos - Hoppon/span_By Shops - Asc'))

WebUI.click(findTestObject('Object Repository/Shop_By_Promo/PromoFilter/Page_Promos - Hoppon/span_By Shops - Desc'))



