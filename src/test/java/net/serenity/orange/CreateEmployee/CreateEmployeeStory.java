package net.serenity.orange.CreateEmployee;

import net.serenity.orange.tasks.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class CreateEmployeeStory {

    private String firstName = "Purple";
    private String middleName = "Hrm";
    private String lastName = "Automation";
    private String employeeName = firstName + " " + middleName + " " + lastName;

    Actor liz = Actor.named("Liz");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenOrangeApp openOrangeApp;

    @Before
    public void lizCanOpenOrangeApp() {
        liz.can(BrowseTheWeb.with(herBrowser));
        liz.wasAbleTo(openOrangeApp);
    }

    @Test
    public void should_be_able_to_add_employee_into_Orange_app() {

        givenThat(liz).wasAbleTo(LoginElementsFunctions.enteringUsername("Admin", "admin"));
        and(liz).wasAbleTo(CreateEmployeeElementsFunctions.enteringEmployeeData(firstName, middleName, lastName));
        when(liz).attemptsTo(SearchEmployeeElementFunctions.enteringEmployeeName(employeeName));
        then(liz).should(eventually(seeThat(ValidateEmployeeData.displayed(), hasItem(firstName + " " + middleName))));
    }
}
