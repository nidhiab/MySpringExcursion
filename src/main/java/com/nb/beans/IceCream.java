package com.nb.beans;

import com.nb.annotations.Cold;
import com.nb.annotations.Creamy;
import com.nb.beans.interfaces.Dessert;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {
}
