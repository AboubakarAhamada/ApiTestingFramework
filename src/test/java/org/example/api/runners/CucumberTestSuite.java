package org.example.api.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "org.example.api")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, summary, html:target/cucumber-report.html, json:target/cucumber.json")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "not @ignore")
public class CucumberTestSuite {
}
