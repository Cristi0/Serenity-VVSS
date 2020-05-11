package lab5.steps.serenity;

import lab5.pages.CoffeePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps
{
    public CoffeePage coffeePage;

    @Step
    public void reloadPage()
    {
        coffeePage.open();
    }

    @Step
    public void enableEdit()
    {
        coffeePage.expand();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        coffeePage.clickEdit();
    }

    @Step
    public void openModal(String fileID)
    {
        coffeePage.clickFile(fileID);
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Step
    public void enterNewName(String name)
    {
        coffeePage.writeNewName(name);
    }

    @Step
    public void confirmEdit(boolean isValid)
    {
        assertThat(coffeePage.isConfirmEnabled(), is(isValid));
        if (isValid)
            coffeePage.confirmEdit();
    }

    /*
    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    */
}