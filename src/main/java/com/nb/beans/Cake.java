package com.nb.beans;

import com.nb.annotations.Soft;
import com.nb.beans.interfaces.Dessert;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Soft
public class Cake implements Dessert {
}
