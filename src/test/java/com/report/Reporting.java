package com.report;

import java.io.File; 
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
public static void generatesJVMReport(String jsonFile) {
		
		File file = new File("C:\\Users\\Naveen\\eclipse-workspace\\OMRBranchAPIAutomation\\target");
		
		Configuration configuration = new Configuration(file, "OMRBranchAPIAutomation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "101");
		configuration.addClassifications("OS", "Windows10");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	
	}
	
	

}
