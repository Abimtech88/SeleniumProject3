package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	public static WebDriver driver;
	public WebDriver getDriver() {
	System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\PageModel\\driver\\chromedriver79.exe");
	driver = new ChromeDriver();
	return driver;
	}
	public void loadUrl(String url) {
	driver.get(url);
	}
	public void gettitle(String name) {
	driver.getTitle();
	}
	public void getcurrentUrl(String title) {
	driver.getCurrentUrl();
	}
	public static void maxWin() {
		driver.manage().window().maximize();
	}
	public void send(WebElement we,String name) {
		we.sendKeys(name);
	}
	public void clickBtn(WebElement clk) {
		clk.click();
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void close() {
		driver.close();
	}
	public void clear(WebElement e) {
		e.clear();
    }
	public void getText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
	}
	public void getAttribute(WebElement e ) {
		
		String attribute = e.getAttribute("value");
		System.out.println(attribute);
	}
	public void windowClose() {
		driver.close();
	}
	public void fndeleme(WebElement element, String name) {
		element.sendKeys(name);
	}
	public void fndelmnts(WebElement element, String name) {
		element.sendKeys(name);
	}
	public void getpgesrc(String ps) {
		driver.getPageSource();
	}
	public void winhan(String winhn) {
		driver.getWindowHandle();
	}
	
	//Robot class
	public void clickEnter(WebElement e) throws AWTException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void ctrlA(WebElement e) throws AWTException {
	Robot r = new Robot();	
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_A);
	}
	public void ctrlV(WebElement e) throws AWTException {
	Robot r = new Robot();	
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
	}
	
	//Takesscreenshot
 	public void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File s =ts.getScreenshotAs(OutputType.FILE);
		File d =new File("D:\\Abi New Files\\Course\\Framwork\\Screenshot\\abi.bmp");
		FileUtils.copyFile(s,d);
 	}
 	//Frames
 	public void iFrame() {
	driver.switchTo().frame(0);
	}
 	public void iFrameId(WebElement e,String Id) {
	  driver.switchTo().frame(Id);
	}
	public void iFrameName(WebElement e , String name) {
		driver.switchTo().frame(name);
	}
	public void IFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
	public void parentframe() {
		driver.switchTo().parentFrame();
	}
	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	public void firstFrame() {
		driver.switchTo().parentFrame();
	}
	
	//WindowHandling
	public void windowHandle(String Url) {
		driver.switchTo().window(Url);
	}
 	public void windowHandles(String Url) {
 		driver.switchTo().window(Url);
    }
 	public void windowId(String winId) {
		driver.switchTo().window(winId);
	}
 	
 	
 	//Actions class
    public void mouseOverAction(WebElement e) {
	Actions a = new Actions(driver);
	a.moveToElement(e).perform(); 
	}
    public void dragDrop(WebElement s,WebElement d ) {
	Actions a = new Actions(driver);
	a.dragAndDrop(s, d);
	}
    public void rightClk(WebElement e) {
    	Actions a = new Actions(driver);
    	a.contextClick().perform();
    }
    public void doubleClk(WebElement e) {
       	Actions a = new Actions(driver);
       	a.doubleClick(e).perform();
    }
    public void clkAndhold() {
		Actions a= new Actions(driver);
		a.clickAndHold();
	}
   public void clk() {
	   Actions a= new Actions(driver);
	   a.click();
	 }
   public void keyUpclk(CharSequence c) {
	   Actions a= new Actions(driver);
	   a.keyUp(c);
   }
    public void keyUpEleclk(WebElement e, CharSequence c) {
	  Actions a= new Actions(driver);
	  a.keyUp(e, c);
    }
    public void keyDownclk(CharSequence c) {
	   Actions a= new Actions(driver);
	   a.keyDown(null);
  }
 public void keyDownEleclk(WebElement e, CharSequence c) {
	  Actions a= new Actions(driver);
	  a.keyDown(e, null);
 }
    
	
	//Select Class
 		public void getAlloption(WebElement e) {
		List<WebElement> allValue = new Select(e).getOptions();
		
		for (WebElement x : allValue) {
			String text = x.getText();
			System.out.println(text);
		}
		
		//Duplicate print
		Set<WebElement> dupSet = new HashSet<WebElement>();
		dupSet.addAll(allValue);
		
		int a = allValue.size();
		int b = dupSet.size();
		
		int c=a -b;
		System.out.println("Duplicates present "+c);
 		}	
	
 		public void choosebyIndex(WebElement elmt) {
	    new Select(elmt).selectByIndex(0);
		}
	    public void chooseByValue(WebElement element,String name) {
	    	new Select(element).selectByValue(name);
		}
	    public void chooseByVisibleText(WebElement emnt,String name) {
	    	new Select(emnt).selectByVisibleText(name);
		}
	    public void optionsByGet(WebElement element) {
	    	new Select(element).getOptions();
		}
	    public void optionsBySelectAll(WebElement element) {
	    	new Select(element).getAllSelectedOptions();
		}
	    public void getOneSelectOption(WebElement element) {
	    	new Select(element).getFirstSelectedOption();
		}
	    public void multiple(WebElement element) {
	    	new Select(element).isMultiple();
		}
	    public void deselect(WebElement element) {
	    	new Select(element).deselectAll();
		}
	    public void remSelecIndex(WebElement element) {
	    	new Select(element).deselectByIndex(0);
		}
	    public void remSelecValue(WebElement element, String value) {
	    	new Select(element).deselectByValue(value);
		}
	    public void remSelectvisibleText(WebElement element, String value) {
	    	new Select(element).deselectByVisibleText(value);
		}
	    public void deselectvistxt(WebElement element, String value) {
	    	new Select(element).hashCode();
	      
	    }
	    //  Alerts
	    public void okAlert() {
	    	driver.switchTo().alert().accept();
		}
	    public void cancelAlert() {
	    	driver.switchTo().alert().dismiss();
		}
		public void promptAlert(String value) {
			driver.switchTo().alert().sendKeys(value);
		}
		public void gettexttAlert() {
			driver.switchTo().alert().getText();
		}
		public void navigatefwd() {
			driver.navigate().forward();
		}
		public void navigatebkwd() {
			driver.navigate().back();
		}
		
		public void scrExeSet(WebElement e) {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','Abinaya')", e);

		}
		public void scrExeGet(WebElement e) {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			Object obj=js.executeScript("return arguments[0].getAttribute('value')", e);
			String s=(String)obj;
			System.out.println(s);

		}
		public void scrollDown(WebElement e) {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", e);
		}
		public void scrollUp(WebElement e) {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", e);
		}
		public void jsclick(WebElement e) {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", e);
		}
		
		public void CreateExc(String sheetName,int i,int j,String name) throws IOException {
			File floc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\adacin.xls");
			Workbook w = new HSSFWorkbook();
			Sheet s =w.createSheet(sheetName);
			Row r = s.createRow(i);
			Cell c =r.createCell(j);
			Row r1 = s.createRow(i);
			Cell c1 =r1.createCell(j);
			c.setCellValue(name);
			FileOutputStream o = new FileOutputStream(floc);
			w.write(o);
		}
		public void ExcelInStream(File e) throws FileNotFoundException  {
			FileInputStream f = new FileInputStream(e);
			}
		public void ExcelOutStream(File e) throws FileNotFoundException  {
			FileOutputStream f = new FileOutputStream(e);
			}
		public void writeData(int rowNum,int cellNum,String value) throws IOException {
			File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
			FileInputStream stream = new FileInputStream(loc);
			Workbook w = new HSSFWorkbook(stream);
			Sheet s = w.getSheet("abi");
			Row r = s.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			c.setCellValue(value);
			FileOutputStream o = new FileOutputStream(loc);
			w.write(o);

		}

}
