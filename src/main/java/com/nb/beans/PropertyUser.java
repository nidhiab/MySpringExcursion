package com.nb.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Nidhia Bhasin on 04-08-2017.
 */
@Component
public class PropertyUser {

    PropertyUser(@Value("${my.property.first}") String prop1, @Value("${my.property.second}") String prop2){
        System.out.println("PropertyUser::prop1::"+prop1);
        System.out.println("PropertyUser::prop2::"+prop2);
    }
}
