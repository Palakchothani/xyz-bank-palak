package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility
{
 By clickOnManagerLogin = By.xpath("//div[@class='borderM box padT20']/child::div[2]/button");

 public void userClickOnBankManager() {
     clickOnElement(clickOnManagerLogin);
 }

     By clickOnAddCustomer = By.xpath("//div[@class='center']/button[1]");


     public void userShouldClickAddCustomerButton(){
         clickOnElement(clickOnAddCustomer);

     }
}
