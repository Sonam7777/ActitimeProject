package com.ActitimeCRM.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ActitimeCRM.GenericLibrary.Baseclass;
import com.ActitimeCRM.GenericLibrary.FileLibrary;
import com.ActitimeCRM.ObjectRepository.HomePage;
import com.ActitimeCRM.ObjectRepository.TaskPage;

public class CreateCustomer extends Baseclass {
	
     @Test
     public  void createCustomer() throws EncryptedDocumentException, IOException {
    	 
    	 HomePage hp = new HomePage(driver);
    	 hp.getTasktab().click();
    	 
    	 TaskPage tp = new TaskPage(driver);
    	 tp.getAddnewbtn().click();
    	 tp.getNewcust().click();
    	 
    	 FileLibrary f = new FileLibrary();
    	 String name = f.readDataFromExcel("Demo", 1, 1);
    	 tp.getCustname().sendKeys(name);
         String desc = f.readDataFromExcel("Demo", 1, 2);
    	 tp.getCustdesc().sendKeys(desc);
    	 tp.getCreatecust().click();
    	 
    	 
   }
     
}
