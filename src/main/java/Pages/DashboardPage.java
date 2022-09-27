package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import java.awt.*;

public class DashboardPage {
    private ElementActions elementAction;

    public DashboardPage(WebDriver driver) throws AWTException {
        elementAction = new ElementActions(driver);
    }

    private By home_Button = By.xpath("//div[@data-testid='board-header__logo']");
    private By profileIcon_Button = By.xpath("(//div[@data-testid='user-profile-button__user-icon'])[1]");
    private By signOut_Option = By.xpath("//span[text()='Log out']");


    /***
     * Refresh the dashboard to be able to see the newly created board
     * */
    public DashboardPage refreshDashboard() {
        elementAction.refresh();
        return this;
    }


    /**
     * Open the board by it is name
     * ***/
    public DashboardPage openBoardByName (String boardName) {
        elementAction.waitForElementTobeVisible(By.xpath("//boards-grid-view/div/div//span[text()='"+boardName+"']"));

        elementAction.click(By.xpath("//boards-grid-view/div/div//span[text()='"+boardName+"']"));
        return this;
    }


   /**
    * Signout form the current user
    * **/
    public DashboardPage signOut () {
        elementAction.click(home_Button);
        elementAction.click(profileIcon_Button);
        elementAction.click(signOut_Option);

        return this;
    }
}
