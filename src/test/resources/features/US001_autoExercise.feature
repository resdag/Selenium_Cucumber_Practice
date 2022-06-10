Feature: US001 Automation Exercise sayfasindaki testler yapilmalidir

  @aetc01
  Scenario: TC01 Register User
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Signup Login button
    And Verify New User Signup! is visible
    And Enter name and email address
    And Click Signup button
    And Verify that ENTER ACCOUNT INFORMATION is visible
    And Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And Click Create Account button
    And Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    And Verify that Logged in as username is visible
    And Click Delete Account button
    And Verify that ACCOUNT DELETED! is visible and click Continue button
    And Close browser

  @aetc02
  Scenario: TC02 Login User with correct email and password
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Signup Login button
    And Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    And Verify that Logged in as username is visible
    And Click Delete Account button
    And Verify that ACCOUNT DELETED! is visible
    And Close browser

  @aetc03
  Scenario:TC03: Login User with incorrect email and password
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Signup Login button
    And Verify Login to your account is visible
    And Enter incorrect email address and password
    And Click login button
    And Verify error Your email or password is incorrect! is visible
    And Close browser

  @aetc04
  Scenario: TC04 Logout User
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Signup Login button
    And Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    And Verify that Logged in as username is visible
    And Click Logout button
    And Verify that user is navigated to login page
    And Close browser

  @aetc05
  Scenario: TC05 Register User with existing email
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Signup Login button
    And Verify New User Signup! is visible
    And Enter name and already registered email address
    And Click Signup button
    And Verify error Email Address already exist! is visible
    And Close browser

  @aetc06
  Scenario: TC06: Contact Us Form
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Contact Us button
    And Verify GET IN TOUCH is visible
    And Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And Click OK button
    And Verify success message Success! Your details have been submitted successfully. is visible
    And Click Home button and verify that landed to home page successfully

  @aetc07
  Scenario: TC07 Verify Test Cases Page
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Test Cases button
    And Verify user is navigated to test cases page successfully

  @aetc08
  Scenario: Verify All Products and product detail page
    Given Launch browser and Navigate to url "autoExUrl"
    And Verify that home page is visible successfully
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And The products list is visible
    And Click on View Product of first product
    And User is landed to product detail page
    And Verify that detail detail is visible: product name, category, price, availability, condition, brand