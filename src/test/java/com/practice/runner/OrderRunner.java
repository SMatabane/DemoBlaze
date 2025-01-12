package com.practice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources", glue= {"com/practice/stepdef","com/practice/hooks"},publish = true,plugin={"pretty"})
public class OrderRunner extends AbstractTestNGCucumberTests{
	
	

}
