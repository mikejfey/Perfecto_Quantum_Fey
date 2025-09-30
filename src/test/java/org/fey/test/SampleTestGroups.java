package org.fey.test;

import org.testng.annotations.Test;


public class SampleTestGroups {

    @Test(groups = {"smoke"})

    public void testLogin() {
        System.out.println("Running smoke test: Login");
    }

    @Test(groups = {"regression"})
    public void testCheckout() {
        System.out.println("Running regression test: Checkout");
    }

    @Test(groups = {"smoke", "android"})
    public void testSearchOnAndroid() {
        System.out.println("Running smoke test on Android");
    }

    @Test(groups = {"ios"})
    public void testSearchOniOS() {
        System.out.println("Running test on iOS");
    }
}
