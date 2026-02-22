package org.example.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.api.support.SharedContext;

import java.nio.charset.StandardCharsets;

public class ApiHooks {
    private final SharedContext sharedContextcontext;

    public ApiHooks(SharedContext sharedContextcontext) {
        //Cucumber injects the same context into all steps and hooks
        this.sharedContextcontext = sharedContextcontext;
    }

    @Before
    public void messageBeforeScenario(Scenario scenario){
        System.out.println("=======================================================================================\n" +
                "                       Début du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }

    @After
    public void messageAfterScenario(Scenario scenario){
        if(scenario.isFailed() && sharedContextcontext.lastResponse != null){
            scenario.attach(
                    sharedContextcontext.lastResponse.asPrettyString().getBytes(),
                    "application/json",
                    "response-body"
            );
        }
        System.out.println("=======================================================================================\n" +
                "                       Fin du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }
}
