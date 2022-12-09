package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest
{
    AccountPage accountPage = new AccountPage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    CustomerPage customerPage = new CustomerPage();

    OpenCustomerPage openCustomerPage = new OpenCustomerPage();

    @Test
    public void bankManagerShouldAddCustomerSuccessfully(){
        //bankManagerLoginPage.userClickOnBankManger();
      //  bankManagerLoginPage.userShouldClickOnAddCustomerButton();
        customerPage.userEnterFirstName("");
        customerPage.userEnterLastName("");
        customerPage.userEnterPostCode("");
       // customerPage.userClickOnAddCustomerAfterFillInFOrm();
        customerPage.getTextFromPopUp();
        String ExpectedMessage = "Customer added successfully with customer id :6";
        Assert.assertEquals(customerPage.getTextFromAlert(), ExpectedMessage, "No Message Displayed");
        customerPage.acceptAlert();
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully(){
       // bankManagerLoginPage.userClickOnBankManger();
        openCustomerPage.userShouldClickOnOpenAccountPage();
        openCustomerPage.userShouldClickOnCustomerName();
        openCustomerPage.userShouldSelectCustomerNameFromDropDown();
        openCustomerPage.userClickOnCurrencyButton();
        openCustomerPage.selectCurrencyInPoundFromDropDown();
        openCustomerPage.userClickOnProcessButton();
        customerPage.getTextFromPopUp();
        String ExpectedMessage = "Account created successfully with account Number :1016";
        Assert.assertEquals(customerPage.getTextFromAlert(), ExpectedMessage, "No Message Displayed");
        customerPage.acceptAlert();

    }
    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        customerLoginPage.userClickOnLoginTab();
        customerLoginPage.userClickOnYourName();
        customerLoginPage.userSelectYourNameFromDropDown();
        customerLoginPage.userClickOnLoginButton();
        String expectedMessage = "Logout";
        Assert.assertEquals(customerLoginPage.verifyLogoutMessage(),expectedMessage,"NO Message Displayed");
        Thread.sleep(1000);
        customerLoginPage.userClickOnLogOutButton();
        String expectedText = "Your Name :";
        Assert.assertEquals(customerLoginPage.verifyYourNameTextinCustomerLogInPage(),expectedText,"No Message Displayed");



    }
    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException{
        customerLoginPage.userClickOnLoginTab();
        customerLoginPage.userClickOnYourName();
        customerLoginPage.userSelectYourNameFromDropDown();
        customerLoginPage.userClickOnLoginButton();
        accountPage.userClickOnDeposit();
        accountPage.userClickOnAmountToBeDepositedAndAdded100();
        accountPage.userClickOnDepositButton();
        Thread.sleep(1000);
        String expectedText = "Deposit Successful";
        Assert.assertEquals(accountPage.userVerifyDepositSuccessFull(),expectedText,"no message displayed");


    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{
        customerLoginPage.userClickOnLoginTab();
        customerLoginPage.userClickOnYourName();
        customerLoginPage.userSelectYourNameFromDropDown();
        customerLoginPage.userClickOnLoginButton();
        Thread.sleep(1000);
        accountPage.userClickOnWithDrawl();
        Thread.sleep(1000);
        accountPage.selectPoundSign();
        accountPage.userClickOnAmountToBeWithDrawn50();
        accountPage.userClickOnWithdrawButton();
        String ExpectedMessage = "Transaction successful";
        Assert.assertEquals(accountPage.verifyTransactionMessage(),ExpectedMessage,"No messageDisplayed");



    }


}

