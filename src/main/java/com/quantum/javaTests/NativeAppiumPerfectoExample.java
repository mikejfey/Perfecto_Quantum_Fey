package com.quantum.javaTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class NativeAppiumPerfectoExample {
    public static AndroidDriver driver;
    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
System.out.println("starting............");
        // Perfecto capabilities
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
       // capabilities.setCapability("cloudName", "demo");

        // Device capabilities (example for Android)
        capabilities.setCapability("platformName", "Android");
       // capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "Galaxy.*");
        System.out.println("setting cap............");
        // Application capabilities (apk)
        // capabilities.setCapability("app", "PUBLIC:ExpenseTracker/Native/ExpenseAppVer1.0.apk");
       // capabilities.setCapability("appPackage", "io.perfecto.expense.tracker"); // For Android
        // capabilities.setCapability("appActivity", "com.example.mynativeapp.MainActivity"); // For Android
        System.out.println("driver initializing............");
        // Initialize driver
        URL url = new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/");
        driver = new AndroidDriver(url, capabilities);

        System.out.println("driver initialized............");

        try {
            // Your native app test steps
            // Example: Find an element by accessibility ID and click it
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).sendKeys("cruz");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("password");
            Thread.sleep(5000);
            driver.findElement(By.id("log-in")).click();


            // Example: Enter text into a text field by ID
            //driver.findElementById("usernameField").sendKeys("testuser");


            // Add more test steps and assertions as needed
        } finally {
            driver.quit(); // Close the driver after test execution
            System.out.println("android");
        }
    }
}
