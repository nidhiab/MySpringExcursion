package com.nb.services;

import com.nb.annotations.Cold;
import com.nb.annotations.Creamy;
import com.nb.beans.XmlDeclaredBeanEx;
import com.nb.beans.interfaces.Dessert;
import com.nb.services.interfaces.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DessertServiceImpl implements DessertService {
    @Autowired
    @Cold
    @Creamy
    Dessert dessert;

    @Autowired
    XmlDeclaredBeanEx xmlDeclaredBeanEx;


    public Dessert getDessert(){
        return dessert;
    }
}
