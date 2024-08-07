package org.testCase;

import org.base.Base;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    @Test(priority =1)
    public void Login_With_Valid_Credindials(){
        System.out.println("login page");

    }
    @Test(priority = 2)
    public void Login_With_Empty_Email(){

    }
    @Test
    public void tc001_Login_With_Empty_Password(){

    }
    @Test
    public void Click_on_Signup(){

    }

}
