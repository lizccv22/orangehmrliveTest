package net.serenity.orange.tasks;

import net.serenity.orange.ui.LoginElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class LoginElementsFunctions implements Task {
    private final String enterUsername;
    private final String enterPassword;

    protected LoginElementsFunctions(String enterUsername, String enterPassword) {
        this.enterUsername = enterUsername;
        this.enterPassword = enterPassword;
    }

    @Override
    @Step("Entering #credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(enterUsername)
                        .into(LoginElements.USERNAME_FIELD));
        actor.attemptsTo(
                Enter.theValue(enterPassword)
                        .into(LoginElements.PASSWORD_FIELD));
        actor.attemptsTo(Click.on(LoginElements.LOGIN_BUTTON));
    }

    public static LoginElementsFunctions enteringUsername(String enterUsername, String enterPassword) {
        return instrumented(LoginElementsFunctions.class, enterUsername, enterPassword);
    }

}
