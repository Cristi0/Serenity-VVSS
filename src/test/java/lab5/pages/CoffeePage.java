package lab5.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.components.FileToUpload;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://localhost:5005/")
public class CoffeePage extends PageObject
{
    @FindBy(id = "expand")
    private WebElementFacade expandOption;
    @FindBy(id = "edit")
    private WebElementFacade editOption;
    @FindBy(id = "delete")
    private WebElementFacade deleteOption;
    @FindBy(id = "upload")
    private WebElementFacade uploadOption;
    @FindBy(id = "confirm")
    private  WebElementFacade confirmOption;
    @FindBy(id = "newEditName")
    private WebElementFacade newEditNameTextArea;
    @FindBy(id = "confirmEdit")
    private WebElementFacade confirmEditButton;
    @FindBy(id = "add")
    private WebElementFacade addOption;
    @FindBy(id = "newFolderNameAdd")
    private WebElementFacade newFolderNameAddTextArea;
    @FindBy(id = "confirmAdd")
    private WebElementFacade confirmAddButton;
    @FindBy(id = "selectFiles")
    private WebElementFacade selectFileButton;
    @FindBy(id = "uploadFiles")
    private WebElementFacade uploadFileButton;

    private WebElementFacade getFileOrFolder(String id)
    {
        return find(By.id(id));
    }

    public void expand()
    {
        this.expandOption.click();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void clickEdit()
    {
        editOption.click();
    }

    public void clickFileOrFolder(String fileID)
    {
        getFileOrFolder(fileID).click();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void writeNewNameForEdit(String name)
    {
        newEditNameTextArea.type(name);
    }

    public boolean isConfirmEditEnabled()
    {
        return confirmEditButton.isEnabled();
    }

    public void confirmEdit()
    {
        confirmEditButton.click();

    }

    public void clickAddOption()
    {
        addOption.click();
    }

    public void writeFolderNameForAdd(String name)
    {
        newFolderNameAddTextArea.type(name);
    }

    public boolean isConfirmAddEnabled()
    {
        return confirmAddButton.isEnabled();
    }

    public void confirmAdd()
    {
        confirmAddButton.click();
    }

    public WebElementFacade getFirstFile()
    {
        String fileID = null;
        List<String> ids = find(By.id("fileContainer")).findElements(By.tagName("div"))
                .stream()
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.toList());
        for (String id : ids)
            if (id.length() > 0 && id.charAt(0) == 'f')
            {
                if (fileID == null)
                    fileID = id;
                else if (id.length() < fileID.length())
                    fileID = id;
                else if (id.length() == fileID.length() && id.compareTo(fileID) <= 0)
                    fileID = id;
            }
        if (fileID != null)
            return find(By.id(fileID));
        else
            throw new RuntimeException("Failed to find ANY folder");
    }

    public WebElementFacade getLastFolder()
    {
        String folderID = null;
        List<String> ids = find(By.id("fileContainer")).findElements(By.tagName("div"))
                .stream()
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.toList());
        for (String id : ids)
            if (id.length() > 0 && id.charAt(0) == 'd')
            {
                if (folderID == null)
                    folderID = id;
                else if (id.length() > folderID.length())
                    folderID = id;
                else if (id.length() == folderID.length() && id.compareTo(folderID) >= 0)
                    folderID = id;
            }
        if (folderID != null)
            return find(By.id(folderID));
        else
            throw new RuntimeException("Failed to find ANY folder");
    }

    public void openUploadModal()
    {
        uploadOption.click();
    }

    public void selectFileForUpload(String filePath)
    {
        FileToUpload fileToUpload = new FileToUpload(getDriver(), filePath);
        fileToUpload.fromLocalMachine().to(getDriver().findElement(By.id("selectFiles")));
        /*
        @FindBy(id = "selectFiles")
        private WebElementFacade selectFileButton;
        doesnt exist when class is made so it needs to be found again
         */
    }

    public boolean isConfirmUploadEnabled()
    {
        return uploadFileButton.isEnabled();
    }

    public void confirmUpload()
    {
        uploadFileButton.click();
    }

    public void doubleClickLastFolder()
    {
        Actions actions = new Actions(getDriver());
        Point origin = getDriver().switchTo().activeElement().getLocation();
        Point destination = getLastFolder().getLocation();
        actions.moveByOffset(destination.x - origin.x, destination.y - origin.y).doubleClick().perform();
        actions.moveByOffset(-destination.x + origin.x, -destination.y + origin.y).perform();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void clickOkButton()
    {
        WebElementFacade okButton = find(By.id("okButton"));
        okButton.click();
    }

    public void clickRoot()
    {
        WebElement root = find(By.id("pathContainer")).findElement(By.tagName("div"));
        if (root != null)
            root.click();
        else
            throw new RuntimeException("Failed to find root folder");
    }

    public void clickDelete()
    {
        deleteOption.click();
    }

    public void confirmAction()
    {
        confirmOption.click();
    }

    public boolean isCollapsed()
    {
        return expandOption.isVisible();
    }
}
