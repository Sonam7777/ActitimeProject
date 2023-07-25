package com.ActitimeCRM.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listeners extends Baseclass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		}

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String name = result.getName();
		TakesScreenshot t = (TakesScreenshot) driver;
	    File src = t.getScreenshotAs(OutputType.FILE);
	    File dest = new File("/Screenshot/"+name+".png");
	     try {
			Files.copy(src,dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    		
     }
	
	    @Override
	    public void onTestSuccess(ITestResult result) {
	   	}
	
}
