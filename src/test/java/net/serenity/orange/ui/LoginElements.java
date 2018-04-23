package net.serenity.orange.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginElements {
    public static Target USERNAME_FIELD = Target.the("username field").located(By.id("txtUsername"));
    public static Target PASSWORD_FIELD = Target.the("password field").located(By.id("txtPassword"));
    public static Target LOGIN_BUTTON = Target.the("login button").located(By.id("btnLogin"));
}
