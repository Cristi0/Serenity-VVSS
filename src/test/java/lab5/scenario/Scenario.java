package lab5.scenario;

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
@UseTestDataFrom("src/test/resources/CoffeeDataScenario.csv")
public class Scenario
{
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:5005/")
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;

    public String folderName;
    public String filePath;
    public String newName;

    @Qualifier
    public String getQualifier()
    {
        return folderName + "," + filePath;
    }

    private void createFolder()
    {
        if (endUserSteps.isCollapsed())
            endUserSteps.expand();
        endUserSteps.openAddModal();
        endUserSteps.enterFolderNameForAdd(folderName);
        endUserSteps.confirmAdd();
    }

    private void enterLastFolder()
    {
        endUserSteps.doubleClickLastFolder();
    }

    private void uploadFile()
    {
        if (endUserSteps.isCollapsed())
            endUserSteps.expand();
        endUserSteps.openUploadModal();
        endUserSteps.selectFileForUpload(filePath);
        endUserSteps.confirmUpload();
    }

    private void renameFile()
    {
        if (endUserSteps.isCollapsed())
            endUserSteps.expand();
        endUserSteps.openEditModal(endUserSteps.returnIDOfFirstFile());
        endUserSteps.enterNewNameForEdit(newName);
        endUserSteps.confirmEdit(true);
        try
        {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void exitFolder()
    {
        endUserSteps.returnToRoot();
    }

    private void deleteFolder()
    {
        if (endUserSteps.isCollapsed())
            endUserSteps.expand();
        endUserSteps.enableDelete();
        endUserSteps.clickFolder(endUserSteps.returnIDOfLastFolder());
        endUserSteps.confirmAction();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Issue("#Scenario-1")
    @Test
    public void scenario01()
    {
        System.out.println("folderName = " + folderName);
        System.out.println("filePath   = " + filePath);
        System.out.println("newName    = " + newName);
        endUserSteps.reloadPage();

        createFolder();
        enterLastFolder();
        uploadFile();
        renameFile();
        exitFolder();
        deleteFolder();
    }

}
