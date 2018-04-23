package net.serenity.orange.orangeLogin;

import net.serenity.orange.tasks.LoginElementsFunctions;
import net.serenity.orange.tasks.OpenOrangeApp;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class loginStory {

    Actor liz = Actor.named("Liz");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenOrangeApp openOrangeApp;

    @Before
    public void lizCanOpenTheOrangeApp() {
        liz.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void should_be_able_to_be_logged_into_Orange_app() {

        givenThat(liz).wasAbleTo(openOrangeApp);

        when(liz).attemptsTo(LoginElementsFunctions.enteringUsername("Admin", "admin"));

        then(liz).should(eventually(seeThat(TheWebPage.title(), containsString("OrangeHRM"))));

    }
}
