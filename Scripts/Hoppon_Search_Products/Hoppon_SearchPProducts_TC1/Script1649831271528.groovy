import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.setText(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'), 
    '670571')

WebUI.clearText(findTestObject('Hoppon/SignIn/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> suggestionList = driver.findElements(By.xpath('//input[@id=\'location-input\']'))

for (WebElement sl : suggestionList) {
    sl.click()

    sl.sendKeys('Kazhakkoottam, Kerala, India')

    sl.sendKeys(Keys.ARROW_DOWN)

    sl.sendKeys(Keys.ENTER)
}

WebUI.delay(3)

List<WebElement> shopList = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div'))

System.out.println(shopList.size())

(shopList[1]).click()

WebUI.comment('Search With blank data')

WebUI.setText(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/input_Product Categories_search_store_prd'), 
    '')

WebUI.click(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/img'))

WebElement butt = driver.findElement(By.xpath('(//button[@name=\'\'])[4]'))

WebUI.delay(3)

butt.click()

WebUI.comment('Search With Full Keyword')

WebUI.setText(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/input_Product Categories_search_store_prd'), 
    'pepsi')

String wordInput = WebUI.getAttribute(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/input_Product Categories_search_store_prd'), 
    'value')

System.out.println(wordInput)

WebUI.click(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/img'))

List<WebElement> productList = driver.findElements(By.xpath('//ul[@id=\'products_container_1865\']/li/div/a/img'))

int size = productList.size()

String url=WebUI.getUrl()

int b = (int)(Math.random()*(size-0+1)+0)

println(b)

productList[b].click()

WebUI.delay(3)

WebUI.navigateToUrl(url)

WebUI.refresh()


WebUI.comment('Search With partial Keyword')

WebUI.setText(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/input_Product Categories_search_store_prd'), 
    'pe')

WebUI.click(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/img'))

WebUI.delay(5)

WebUI.back()

