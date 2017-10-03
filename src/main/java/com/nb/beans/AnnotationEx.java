package com.nb.beans;


import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("MyComp")
public class AnnotationEx {
    public void printIt(){
        System.out.println("I am going to test this in assertion!!!");
    }
    public AnnotationEx() {
        System.out.println("AnnotationEx...");
    }
    public String getMessage(){
        return "Hello from AnnotationEx";
    }
}
