package lab5.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://127.0.0.1:5005/")
public class CoffeePage extends PageObject
{
    @FindBy(id = "expand")
    private WebElementFacade expandOption;
    @FindBy(id = "collapse")
    private WebElementFacade collapseOption;
    @FindBy(id = "edit")
    private WebElementFacade editOption;
    @FindBy(id = "newName")
    private WebElementFacade newNameTextArea;
    @FindBy(id = "confirmEdit")
    private WebElementFacade confirmEditButton;

    private WebElementFacade getFile(String id)
    {
        return find(By.id(id));
    }

    public void expand()
    {
        this.expandOption.click();
    }

    public void clickEdit()
    {
        this.editOption.click();
    }

    public void clickFile(String fileID)
    {
        getFile(fileID).click();
    }

    public void writeNewName(String name)
    {
        newNameTextArea.type(name);
    }

    public boolean isConfirmEnabled()
    {
        return confirmEditButton.isEnabled();
    }

    public void confirmEdit()
    {
        confirmEditButton.click();
    }
}
