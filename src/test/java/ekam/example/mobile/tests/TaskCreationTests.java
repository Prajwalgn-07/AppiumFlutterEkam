package ekam.example.mobile.tests;

import com.testvagrant.ekam.testBases.testng.MobileTest;
import ekam.example.mobile.screens.HomeScreen;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Test(groups = "mobile")
public class TaskCreationTests extends MobileTest {

    public void shouldCreateNewTask() {
        String taskTitle = "New Task";
        String taskDescription = "New Task";
        HomeScreen homescreen = Page(HomeScreen.class);
        homescreen.addToDoItem(taskTitle, taskDescription);
        assertThat("New task is not displayed",homescreen.getText(taskTitle), equalTo(taskTitle));
    }

    public void shouldCreateAndDeleteTask() {
        String taskTitle = "New Task";
        String taskDescription = "New Task";

        //Create new task
        HomeScreen homescreen = Page(HomeScreen.class);
        homescreen.addToDoItem(taskTitle, taskDescription);
        assertThat("New task is not displayed",homescreen.getText(taskTitle), equalTo(taskTitle));

        //Delete task
        homescreen.navigateTaskToDeletedState(taskTitle);
        homescreen.navigateToTasksState("Deleted");
        assertThat("Task is not deleted",homescreen.getText(taskTitle), equalTo(taskTitle));
    }
}
