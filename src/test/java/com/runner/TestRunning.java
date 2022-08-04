package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags= {"@Login or @Address or @ChangeProfilePic"}, plugin= {"pretty", "json:target\\cucumber.json"}, snippets= SnippetType.CAMELCASE, features= {"src\\test\\resources"}, glue= {"com.stepdefinition"})
public class TestRunning {
	
	@AfterClass
	public static void afterClass() {
		
		Reporting.generatesJVMReport("C:\\Users\\Naveen\\eclipse-workspace\\OMRBranchAPIAutomation\\target\\cucumber.json");
		
	}
	

}
