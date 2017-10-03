package com.nb.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Nidhia Bhasin on 01-08-2017.
 */

public class ProfileDevBeanEx {
    String name = "ProfileDevBeanEx";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileDevBeanEx() {
        System.out.println("ProfileDevBeanEx...");
    }

    public String getMessage(){
        return "Hello from ProfileDevBeanEx";
    }
}
