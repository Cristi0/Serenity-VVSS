package lab5.features.edit;

import lab5.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/CoffeeDataEdit.csv")
public class EditFileName
{
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://127.0.0.1:5005/")
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;

    public String id;
    public String name;
    public String valid;

    @Qualifier
    public String getQualifier()
    {
        return id + "," + name + "," + valid;
    }

    @Issue("#EditFile-1")
    @Test
    public void editFileName()
    {
        System.out.println("id    = " + id);
        System.out.println("name  = " + name);
        System.out.println("valid = " + valid);
        endUserSteps.reloadPage();
        endUserSteps.expand();
        endUserSteps.openEditModal(id);
        endUserSteps.enterNewNameForEdit(name);
        endUserSteps.confirmEdit(Boolean.parseBoolean(valid));
    }

}
