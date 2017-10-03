package com.nb.beans;

import com.nb.annotations.Cold;
import com.nb.annotations.Fruity;
import com.nb.beans.interfaces.Dessert;
import org.springframework.stereotype.Component;

@Component
@Cold
@Fruity
public class Popsicle implements Dessert {
}
