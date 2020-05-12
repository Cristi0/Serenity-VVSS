package lab5.steps.serenity;

import lab5.pages.CoffeePage;
import net.thucydides.core.annotations.Step;

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
    public void expand()
    {
        coffeePage.expand();
    }

    @Step
    public void openEditModal(String fileID)
    {
        coffeePage.clickEdit();
        coffeePage.clickFileOrFolder(fileID);
    }

    @Step
    public void enterNewNameForEdit(String name)
    {
        coffeePage.writeNewNameForEdit(name);
    }

    @Step
    public void confirmEdit(boolean isValid)
    {
        assertThat(coffeePage.isConfirmEditEnabled(), is(isValid));
        if (isValid)
            coffeePage.confirmEdit();
    }

    @Step
    public void openAddModal()
    {
        coffeePage.clickAddOption();
    }

    @Step
    public void enterFolderNameForAdd(String name)
    {
        coffeePage.writeFolderNameForAdd(name);
    }

    @Step
    public void confirmAdd()
    {
        assertThat(coffeePage.isConfirmAddEnabled(), is(true));
        coffeePage.confirmAdd();
    }

    @Step
    public String returnIDOfLastFolder()
    {
        return coffeePage.getLastFolder().getAttribute("id");
    }

    @Step
    public void doubleClickLastFolder()
    {
        coffeePage.doubleClickLastFolder();
    }

    @Step
    public String returnIDOfFirstFile()
    {
        return coffeePage.getFirstFile().getAttribute("id");
    }

    @Step
    public void openUploadModal()
    {
        coffeePage.openUploadModal();
    }

    @Step
    public void selectFileForUpload(String filePath)
    {
        coffeePage.selectFileForUpload(filePath);
    }

    @Step
    public void confirmUpload()
    {
        assertThat(coffeePage.isConfirmUploadEnabled(), is(true));
        coffeePage.confirmUpload();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        coffeePage.clickOkButton();
    }

    public void returnToRoot()
    {
        coffeePage.clickRoot();
    }

    public void enableDelete()
    {
        coffeePage.clickDelete();
    }

    public void clickFolder(String folderID)
    {
        coffeePage.clickFileOrFolder(folderID);
    }

    public void confirmAction()
    {
        coffeePage.confirmAction();
    }

    public boolean isCollapsed()
    {
        return coffeePage.isCollapsed();
    }
}