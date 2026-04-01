package com.example.bai3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3Test {

    @Test
    public void secretShouldBePresent() {
        String password = System.getenv("MY_PASSWORD");
        if (password == null) {
            System.out.println("MY_PASSWORD not found in environment (null)");
        } else {
            System.out.println("MY_PASSWORD is present in environment (not printing the secret)");
        }
        Assert.assertNotNull(password, "Expected MY_PASSWORD to be provided via environment variables");
    }
}
