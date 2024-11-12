# Selenium Project

# Project Structure :
- This framework followed Page object Model methodology, Pages package include 3 classes for each screen ( Login Page , Dashboard , Board ) and it has a one Test Page (EndToEndTests) .
- All configuration Data (  Browser Name - Credentials - etc ) exist in TestData package (TestData.java)
- Test Report exist in TestReports package.
- You can run the test by running E2E.xml in the project root path
- Execution automatically recorder as videos in video folder.
- WebDriver Manager automatically handle downloading the needed WebDriver binary executable files for all browsers on all platforms (chrome-firefox-Safari-Edge- Opera)

# Tech Stack:

- Selenium Webdriver
- Maven
- TestNG
- Extent Report for reporting in HTML5 format
- Automation-remarks for recording all test execution as videos
- ShutterBug for image Comparison 

# Requirements :
- jdk-17
- Eclipse or Intellij IDE


### How To Run 
- Right click on EndToEndTests then choose run Or  right click on E2E.xml then choose run 


# Execution Report Snapshot :
<img width="1756" alt="Screenshot 2022-09-27 at 1 52 39 AM" src="https://user-images.githubusercontent.com/66669388/192406881-d2ca5e2a-e1d9-4617-973e-051a91991e30.png">
