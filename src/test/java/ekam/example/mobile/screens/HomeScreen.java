package ekam.example.mobile.screens;

import org.openqa.selenium.WebElement;

public class HomeScreen extends FlutterMobileScreen {

    private String createList = "createList";
    private String title = "newListTitle";
    private String description = "newListDescription";
    private String submitList = "newListSubmit";
    private String deleteTask = "deleteIcon";


    public HomeScreen addToDoItem(String title, String description) {
       flutterFinder.byValueKey(this.createList).click();
       flutterFinder.byValueKey(this.title).sendKeys(title);
       flutterFinder.byValueKey(this.description).sendKeys(description);
       flutterFinder.byValueKey(this.submitList).click();
       return this;
    }

    public HomeScreen navigateToTasksState(String tasksState) {
        WebElement webElement= flutterFinder.byText(tasksState);
        webElement.click();
        return this;
    }

    public HomeScreen navigateTask(String taskName, String state){
        if(state.equals("Deleted")) navigateTaskToDeletedState(taskName);
        return this;
    }


    public HomeScreen navigateTaskToDeletedState(String taskName){
        flutterFinder.byText(taskName).click();
        flutterFinder.byValueKey(this.deleteTask).click();
        flutterFinder.byText("Yes").click();
        return this;
    }

    public String getText(String taskName){
        return flutterFinder.byText(taskName).getText();
    }
}
