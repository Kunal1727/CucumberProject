package com.cucumber.practise.CucumberDemo;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		features="FeatureFolder",
		glue="com.cucumber.practise.CucumberDemo",
		plugin  = {"pretty:STDOUT","html:target/HTMLCucumberReport","json:target/Cucumber.json"}
		//,tags = {"@Smoke,@Sanity"}
)
public class MyRunnerClass extends AbstractTestNGCucumberTests 
{
	@Test
	public void run()
	{}
}
