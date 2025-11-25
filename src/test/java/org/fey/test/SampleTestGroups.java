package org.fey.test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SampleTestGroups extends WebDriverTestCase {

    @Test(groups = {"security"})

    public void testLogin() {
        System.out.println("Running smoke test: Login");
    }

    @Test(groups = {"regression", "critical", "high-priority"})
    public void testCheckout() {
        System.out.println("Running regression test: Checkout");
    }

    @Test(groups = {"regression", "low-priority", "android"})
    public void testSearchOnAndroid() {
        System.out.println("Running smoke test on Android");
    }

    @Test(groups = {"ios", "smoke"})
    public void testSearchOniOS() {
        System.out.println("Running test on iOS");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(1 == 1, "1 is not equal to 2");
        softAssert.assertAll();
    }
}
