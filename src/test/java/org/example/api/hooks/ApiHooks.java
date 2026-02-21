package org.example.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApiHooks {
    @Before
    public void messageBeforeScenario(Scenario scenario){
        System.out.println("=======================================================================================\n" +
                "                       Début du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }

    @After
    public void messageAfterScenario(Scenario scenario){
        System.out.println("=======================================================================================\n" +
                "                       Fin du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }
}
