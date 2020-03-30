package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public class MainClass {
public static void main(String[] args) throws InterruptedException, IOException {
	
	LibGlobal lib = new LibGlobal();
		
	lib.getDriver();
	lib.loadUrl("http://adactin.com/HotelApp/index.php");
	
	LoginPage page = new LoginPage();
	
	lib.send(page.getUserName(),"abiraghul6");
	lib.send(page.getPassword(),"Abi3988");
	lib.clickBtn(page.getBtnLogin());
	
	SearchPage spage = new SearchPage();
	
	lib.chooseByValue(spage.getSelectLocation(), "London");
	lib.chooseByVisibleText(spage.getSelectHotels(), "Hotel Hervey");
	lib.chooseByVisibleText(spage.getSelectRoomType(),"Super Deluxe");
	lib.chooseByVisibleText(spage.getRooms(),"3 - Three");
	lib.send(spage.getCheckIn(),"23/06/2022");
	lib.send(spage.getCheckOut(),"27/06/2022");
	lib.chooseByVisibleText(spage.getAdultsRoom(), "3 - Three");
	lib.chooseByVisibleText(spage.getChildRoom(),"2 - Two");
	lib.clickBtn(spage.getSearch());
	
	SelectPage selpage = new SelectPage();
	
	lib.clickBtn(selpage.getButton());
	lib.clickBtn(selpage.getCtnbtn());
	
	BookingPage bpage = new BookingPage();
	
	lib.send(bpage.getFirstname(), "Abinaya");
	lib.send(bpage.getLastname(), "Rithu");
	lib.send(bpage.getAddress(), "Karapakkam");
	lib.send(bpage.getCredit(), "8765432197634521");
	lib.chooseByVisibleText(bpage.getCredittype(), "Master Card");
	lib.chooseByVisibleText(bpage.getMonth(),"March");
	lib.chooseByVisibleText(bpage.getYear(),"2022");
	lib.send(bpage.getCcvv(),"345");
	lib.clickBtn(bpage.getBooknow());
		
	ConfirmBooking cbook = new ConfirmBooking();
		
	Thread.sleep(5000);
   
	lib.getAttribute(cbook.getText());
	
	String attribute = cbook.getText().getAttribute("value");
	System.out.println(attribute);
	
	lib.CreateExc("aaa", 0, 1, attribute);
}
}
