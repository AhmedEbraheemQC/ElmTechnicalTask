package Tests;

import Apis.BoardApis;
import Pages.BoardPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import TestData.TestData;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

@Listeners(UniversalVideoListener.class)

public class EndToEndTests extends BaseTest {

    LoginPage loginPage ;
    BoardApis boardApis;
    DashboardPage dashboardPage;
    BoardPage boardPage ;

    @BeforeClass
    public void initialize() throws AWTException {
        loginPage =new LoginPage(driver);
        boardApis = new BoardApis();
        dashboardPage = new  DashboardPage(driver);
        boardPage = new BoardPage(driver);
    }


    @Test (priority = 0,description = "Login using email & password")
    @Video
    public void LoginWithValidCredentials() {

        logger = report.createTest("Test Login Functionality with valid Credentials");
        logger.info("Login Using email & password");
        logger.assignCategory("Positive Scenario");

        loginPage.loginWithValidCredentials(TestData.UserOneEmail,TestData.UserOnePassword);

        logger.info("Test Case Ended");

    }



    @Test(priority =  1 ,description = "Create board ")
    void createBoard() throws IOException {


        logger = report.createTest("Create Board");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        boardApis.createBoard();

        logger.info("Test Case Ended");

    }


    @Test(priority = 2,description = "Share board ")
    public void shareBoard() throws FileNotFoundException {
        logger = report.createTest("Share Board");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        boardApis.shareBoard();

        logger.info("Test Case Ended");

    }


    @Test(priority = 3,description = "Add Sticker ")
    @Video
    public void AddSticker() throws IOException, InterruptedException {
        logger = report.createTest("Add Sticker");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        dashboardPage.refreshDashboard()
                .openBoardByName(TestData.BoardName);

        boardPage.addSticker(TestData.StickerName)
                .takeScreenshot(TestData.ScreenShotOne);

        dashboardPage.signOut();

        loginPage.loginWithValidCredentials(TestData.UserTwoEmail,TestData.UserTwoPassword);
        dashboardPage.openBoardByName(TestData.BoardName);
        boardPage.takeScreenshot(TestData.ScreenShotTwo);

        Assert.assertEquals(boardPage.compareScreenShots(),true);

        logger.info("Test Case Ended");

    }

    @Test(priority = 4, description = "Delete the created board")
    public void deleteBoard() {
        logger = report.createTest("Delete Board");
        logger.assignCategory("Positive Scenario");
        logger.info("Test Case Started");

        boardApis.deleteBoard();
        logger.info("Test Case Ended");

    }



    }







