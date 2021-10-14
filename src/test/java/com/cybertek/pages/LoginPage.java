package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);

    }

    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })

    public WebElement usernameInput;

    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        usernameInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){


        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        usernameInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver() {
    }
}
