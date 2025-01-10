package com.practice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources", glue= {"com/practice/stepdef"},publish = true,plugin={"pretty"})
public class OrderRunner extends AbstractTestNGCucumberTests{
	
	

}
