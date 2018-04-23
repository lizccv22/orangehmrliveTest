package net.serenity.orange.tasks;

import net.serenity.orange.ui.CreateEmployeeElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchEmployeeElementFunctions implements Task {

    private final String employeeName;

    protected SearchEmployeeElementFunctions(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    @Step("Entering #employeeData")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreateEmployeeElements.EMPLOYEE_LIST_TAB));
        actor.attemptsTo(
                Enter.theValue(employeeName)
                        .into(CreateEmployeeElements.EMPLOYEE_NAME_FIELD));
        actor.attemptsTo(Click.on(CreateEmployeeElements.SEARCH_BUTTON));
    }

    public static SearchEmployeeElementFunctions enteringEmployeeName(String employeeName) {
        return instrumented(SearchEmployeeElementFunctions.class, employeeName);
    }
}
