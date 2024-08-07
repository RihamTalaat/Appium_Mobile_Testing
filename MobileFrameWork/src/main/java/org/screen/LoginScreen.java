package org.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.base.Base;

public class LoginScreen extends Base {
    @iOSXCUITFindBy(xpath="//")
    @AndroidFindBy(xpath = "//")
    MobileElement emailFiledLocator;

}
