package net.serenity.orange.tasks;

import net.serenity.orange.ui.CreateEmployeeElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployeeElementsFunctions implements Task {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    protected CreateEmployeeElementsFunctions(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    @Step("Entering #employeeData")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreateEmployeeElements.PIM_TAB));
        actor.attemptsTo(Click.on(CreateEmployeeElements.ADD_BUTTON));
        actor.attemptsTo(
                Enter.theValue(firstName)
                        .into(CreateEmployeeElements.FIRST_NAME_FIELD));
        actor.attemptsTo(
                Enter.theValue(middleName)
                        .into(CreateEmployeeElements.MIDDLE_NAME_FIELD));
        actor.attemptsTo(
                Enter.theValue(lastName)
                        .into(CreateEmployeeElements.LAST_NAME_FIELD));
        actor.attemptsTo(Click.on(CreateEmployeeElements.SAVE_BUTTON));
    }

    public static CreateEmployeeElementsFunctions enteringEmployeeData(String firstName, String middleName, String lastName) {
        return instrumented(CreateEmployeeElementsFunctions.class, firstName, middleName, lastName);
    }
}
