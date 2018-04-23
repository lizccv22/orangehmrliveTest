package net.serenity.orange.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateEmployeeElements {
    public static Target PIM_TAB = Target.the("PIM tab").located(By.id("menu_pim_viewPimModule"));
    public static Target ADD_BUTTON = Target.the("add button").located(By.id("btnAdd"));
    public static Target FIRST_NAME_FIELD = Target.the("first name field").located(By.id("firstName"));
    public static Target MIDDLE_NAME_FIELD = Target.the("middle name field").located(By.id("middleName"));
    public static Target LAST_NAME_FIELD = Target.the("last name field").located(By.id("lastName"));
    public static Target SAVE_BUTTON = Target.the("save button").located(By.id("btnSave"));
    public static Target EMPLOYEE_LIST_TAB = Target.the("employee list tab").located(By.id("menu_pim_viewEmployeeList"));
    public static Target EMPLOYEE_NAME_FIELD = Target.the("employee name field").located(By.id("empsearch_employee_name_empName"));
    public static Target SEARCH_BUTTON = Target.the("search button").located(By.id("searchBtn"));
    public static Target RESULTS_LIST = Target.the("results list").located(By.id("frmList_ohrmListComponent"));
}
