package com.example.demo;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestResultListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }
}