package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tutorialsninja.action.Action;

public class RegisterPage {

    WebDriver driver;
    Action action;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
    }

    // locators
    private By fname = By.id("input-firstname");
    private By lname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By tel = By.id("input-telephone");
    private By pass = By.id("input-password");
    private By cpass = By.id("input-confirm");
    private By agreecheckbox = By.xpath("//input[@name='agree']");
    private By continuebutton = By.xpath("//input[@value='Continue']");
    private By accountSuccess = By.xpath("//h1[text()='Your Account Has Been Created!']");
    private By emailmandatorymsg = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
    private By existEmailMsg = By.xpath("//div[contains(text(),'Warning: E-Mail Address is already registered!')]");
   
    //methods
    public void newAccountRegister(String fname, String lname, String email, String tel, String pass, String cpass) {
        action.enterText(this.fname, fname);
        action.enterText(this.lname, lname);
        action.enterText(this.email, email);
        action.enterText(this.tel, tel);
        action.enterText(this.pass, pass);
        action.enterText(this.cpass, cpass);
        action.click(agreecheckbox);
        action.click(continuebutton);
    }

    
    public void firstName(String fname) {
        action.enterText(this.fname, fname);
    }

    public void lastName(String lname) {
        action.enterText(this.lname, lname);
    }

    public void email(String email) {
        action.enterText(this.email, email);
    }

    public void telephone(String tel) {
        action.enterText(this.tel, tel);
    }

    public void password(String pass) {
        action.enterText(this.pass, pass);
    }

    public void confirmPassword(String cpass) {
        action.enterText(this.cpass, cpass);
    }

    public void agreeCheckbox() {
        action.click(agreecheckbox);
    }

    public void continueButton() {
        action.click(continuebutton);
    }

    
    public String accountSuccessMsg() {
        return action.getText(accountSuccess);
    }

    public String emailMandatoryMsg() {
        return action.getText(emailmandatorymsg);
    }

    public String existingEmailMsg() {
        return action.getText(existEmailMsg);
    }
}