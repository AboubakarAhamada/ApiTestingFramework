package org.example.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.api.support.SharedContext;

public class PostsSetupHooks {
    private final SharedContext sharedContext;

    public PostsSetupHooks(SharedContext sharedContextcontext) {
        //Cucumber injects the same context into all steps and hooks
        this.sharedContext = sharedContextcontext;
    }
    @Before("@needsExistingPost")
    public void ensureExistingPost(){
        sharedContext.setPostId(19);
    }
    @Before
    public void messageBeforeScenario(Scenario scenario){
        System.out.println("=======================================================================================\n" +
                "                       Début du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }

    @After
    public void messageAfterScenario(Scenario scenario){
        if(scenario.isFailed() && sharedContext.getLastResponse() != null){
            scenario.attach(
                    sharedContext.getLastResponse().asPrettyString().getBytes(),
                    "application/json",
                    "response-body"
            );
        }
        System.out.println("=======================================================================================\n" +
                "                       Fin du scenario <<" +scenario.getName()+">>\n"+
                "=======================================================================================");
    }
}
