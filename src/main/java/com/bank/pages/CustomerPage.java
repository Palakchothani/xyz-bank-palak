package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerPage extends Utility {
    By enterFirstName = By.xpath("");

    public void userEnterFirstName(String firstname) {
        sendTextToElement(enterFirstName, firstname);
    }

    By enterLastName = By.xpath("");

    public void userEnterLastName(String lastname) {
        sendTextToElement(enterLastName, lastname);
    }

    By enterPostCode = By.xpath("");

    public void userEnterPostCode(String postcode) {
        sendTextToElement(enterPostCode, postcode);
    }

    By clickOnAddCustomer = By.xpath("");

    public void userClickOnAddCustomerAfterFillInForm() {
        clickOnElement(clickOnAddCustomer);
    }

    public String getTextFromPopUp() {
      return getTextFromAlert();
    }



    public void alertAccept(){
        driver.switchTo().alert().getText();
    }



}
