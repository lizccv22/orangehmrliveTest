package net.serenity.orange.tasks;

import net.serenity.orange.ui.CreateEmployeeElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateEmployeeData implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor){
        return Text.of(CreateEmployeeElements.RESULTS_LIST).viewedBy(actor).asList();
    }
    public static  Question<List<String>> displayed(){
        return new ValidateEmployeeData();
    }
}
