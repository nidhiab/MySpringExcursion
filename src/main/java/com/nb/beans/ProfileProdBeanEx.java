package com.nb.beans;

import org.springframework.context.annotation.Profile;

/**
 * Created by Nidhia Bhasin on 01-08-2017.
 */

public class ProfileProdBeanEx {
    String name = "ProfileProdBeanEx";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ProfileProdBeanEx() {
        System.out.println("ProfileProdBeanEx...");
    }

    public String getMessage(){
        return "Hello from ProfileProdBeanEx";
    }
}