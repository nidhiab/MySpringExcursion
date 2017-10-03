package com.nb.beans;

import com.nb.beans.conditions.IsDevProfile;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;




public class ConditionalEx {
    public ConditionalEx() {
        System.out.println("ConditionalEx...");
    }
    public String getMessage(){
        return "Hello from ConditionalEx";
    }
}
