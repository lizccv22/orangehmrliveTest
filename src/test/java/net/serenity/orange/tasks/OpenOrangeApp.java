package net.serenity.orange.tasks;

import net.serenity.orange.ui.OrangePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenOrangeApp implements Task {

    OrangePage orangePage;

    @Step("Open Orange Web application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(orangePage)
        );
    }
}
